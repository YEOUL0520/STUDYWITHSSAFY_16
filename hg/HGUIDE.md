# `wh` Java & Python Guide ⚡

> SWEA D1부터 차근차근 부수기 위한 초간단 가이드

---

## 📂 1. 프로젝트 구조

```text
STUDYWITHSSAFY_16/
└─ wh/
    ├─ GUIDE.md
    ├─ input.txt       # 테스트 입력 파일
    ├─ Solution.java   # 자바 풀이
    └─ solution.py     # 파이썬 풀이

```

---

## ⚙️ 2. 저지별 클래스 & 명명 규칙

| 사이트 | 자바 (Java) | 파이썬 (Python) | 출력 포인트 |
| --- | --- | --- | --- |
| **SWEA** | `Solution.java` (`public class Solution`) | `solution.py` | `#테스트케이스번호 정답` |
| **백준** | `Main.java` (`public class Main`) | `main.py` | 요구하는 값만 출력 |
| **프로그래머스** | 규칙에 따른 클래스 | 함수 형태 제출 | 결과값 반환 |

* **주의:** 제출 시 `package` 선언은 **반드시 삭제**할 것!

---

## 🛠️ 3. 기본 템플릿

### ☕ Java (`Solution.java`)

```java
import java.io.BufferedInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입출력 세팅
        int testCount = 1; // 필요시 입력으로 변경

        for (int tc = 1; tc <= testCount; tc++) {
            int answer = 0; // 로직 구현

            System.out.println("#" + tc + " " + answer);
        }
    }
}

```

### 🐍 Python (`solution.py`)

```python
import sys

# 로컬 테스트용 (제출 시 주석 처리)
# sys.stdin = open('input.txt', 'r')

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    test_count = int(input_data[0])
    
    for tc in range(1, test_count + 1):
        answer = 0 # 로직 구현
        print(f"#{tc} {answer}")

if __name__ == '__main__':
    solve()

```

---

## 🚀 4. 로컬 실행 및 컴파일 (PowerShell)

```powershell
# 경로 이동
Set-Location C:\SSAFY\_self_project\STUDYWITHSSAFY_16\wh

# Java 실행
javac -encoding UTF-8 Solution.java
Get-Content input.txt | java Solution

# Python 실행
Get-Content input.txt | python solution.py

```

---

## ✅ 5. 제출 전 3초 체크리스트

* [ ] `package` 선언 지웠나요?
* [ ] 자바 클래스 이름이 `Solution` (또는 `Main`)인가요?
* [ ] 출력 포맷(`#tc 정답`)을 맞췄나요?