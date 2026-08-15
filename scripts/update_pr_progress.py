#!/usr/bin/env python3
"""Update the participant table with each member's total pull request count."""

from __future__ import annotations

import json
import os
import re
import sys
from pathlib import Path
from urllib.error import HTTPError
from urllib.parse import quote
from urllib.request import Request, urlopen


README = Path(__file__).resolve().parents[1] / "README.md"
START = "<!-- PR_PROGRESS_START -->"
END = "<!-- PR_PROGRESS_END -->"

# PR count thresholds inspired by Baekjoon's tier progression.
TIERS = (
    (150, "Ruby", "e0115f"),
    (100, "Diamond", "00b4fc"),
    (60, "Platinum", "27e2a4"),
    (40, "Gold", "ec9a00"),
    (20, "Silver", "435f7a"),
    (1, "Bronze", "ad5600"),
    (0, "Unranked", "555555"),
)


def participants(readme: str) -> list[str]:
    """Read GitHub usernames from the profile links before the progress row."""
    profile_section = readme.split(START, 1)[0]
    names = re.findall(r'<a href="https://github\.com/([^/"?#]+)">', profile_section)
    return list(dict.fromkeys(names))


def pr_count(repository: str, username: str, token: str) -> int:
    query = quote(f"repo:{repository} is:pr author:{username}")
    request = Request(
        f"https://api.github.com/search/issues?q={query}&per_page=1",
        headers={
            "Accept": "application/vnd.github+json",
            "Authorization": f"Bearer {token}",
            "X-GitHub-Api-Version": "2022-11-28",
            "User-Agent": "study-pr-progress-action",
        },
    )
    try:
        with urlopen(request, timeout=30) as response:
            return int(json.load(response)["total_count"])
    except HTTPError as error:
        details = error.read().decode("utf-8", errors="replace")
        raise RuntimeError(f"GitHub API request failed for {username}: {error.code} {details}") from error


def tier_for(count: int) -> tuple[str, str]:
    for minimum, name, color in TIERS:
        if count >= minimum:
            return name, color
    raise AssertionError("TIERS must include a zero-count tier")


def progress_row(names: list[str], counts: list[int]) -> str:
    cells = []
    for name, count in zip(names, counts, strict=True):
        tier, color = tier_for(count)
        badge = f"https://img.shields.io/badge/{tier}-{count}%20Hits!-{color}?style=flat-square"
        cells.append(
            f'    <td align="center"><img src="{badge}" alt="{name}: {tier}, {count} Hits!" /></td>'
        )
    return "\n".join([START, "  <tr>", *cells, "  </tr>", f"  {END}"])


def main() -> int:
    token = os.environ.get("GITHUB_TOKEN")
    repository = os.environ.get("GITHUB_REPOSITORY")
    if not token or not repository:
        print("GITHUB_TOKEN and GITHUB_REPOSITORY are required.", file=sys.stderr)
        return 2

    readme = README.read_text(encoding="utf-8")
    names = participants(readme)
    if not names:
        print("No participant profile links were found.", file=sys.stderr)
        return 1
    if START not in readme or END not in readme:
        print("Progress markers are missing from README.md.", file=sys.stderr)
        return 1

    counts = [pr_count(repository, name, token) for name in names]
    replacement = progress_row(names, counts)
    updated = re.sub(
        rf"{re.escape(START)}.*?{re.escape(END)}",
        replacement,
        readme,
        count=1,
        flags=re.DOTALL,
    )
    README.write_text(updated, encoding="utf-8")
    print(", ".join(f"{name}: {count}" for name, count in zip(names, counts, strict=True)))
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
