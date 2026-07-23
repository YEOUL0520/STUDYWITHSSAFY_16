# `wh` Java 코딩 테스트 프로젝트 가이드

이 문서는 `jomang_0721_wh.java`가 있는 `STUDYWITHSSAFY_16/wh` 폴더를 작업 루트로 사용한다. 이후 문제도 이 폴더에서 작성하고, 로컬 테스트 후 온라인 저지에 제출한다.

## 1. 현재 프로젝트 구조

PowerShell에서 다음 경로로 이동해 작업을 시작한다.

```powershell
Set-Location C:\SSAFY\_self_project\STUDYWITHSSAFY_16\wh
```

```text
STUDYWITHSSAFY_16/
└─ wh/
   ├─ .gitignore
   ├─ GUIDE.md
   ├─ input.txt              # 로컬 테스트 입력, Git 제외
   ├─ jomang_0721_wh.java    # 현재 SWEA 풀이
   └─ 문제별_풀이.java       # 이후 문제 풀이
```

현재 소스처럼 파일명이 `jomang_0721_wh.java`여도 내부 클래스가 `class Solution`처럼 `public`이 아니면 컴파일할 수 있다. 컴파일 결과는 `Solution.class`이며 실행 명령도 `java Solution`이다. 온라인 저지에 제출할 때는 일반적으로 `package` 선언을 넣지 않는다.

## 2. 저지별 클래스 이름

| 사이트 | 파일 및 클래스 이름 | 출력 형식 |
|---|---|---|
| 백준 | `Main.java`, `public class Main` | 문제에서 요구하는 값만 출력 |
| SWEA | `Solution.java`, `public class Solution` | 보통 `#테스트케이스번호 정답` |
| 프로그래머스 | 사이트에서 제시한 `class Solution` | 메서드의 반환값으로 제출 |

파일 이름과 `public class` 이름은 반드시 같아야 한다.

## 3. 기본 제출 템플릿

백준 기준 템플릿이다. SWEA에서는 클래스 이름을 `Solution`으로 바꾸고 테스트 케이스 출력 형식을 적용한다.

```java
import java.io.BufferedInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();

        // 1. 입력
        // 2. 알고리즘 수행
        // 3. 결과 저장
        out.append(n);

        System.out.print(out);
    }

    private static final class FastScanner {
        private final BufferedInputStream in = new BufferedInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int index;
        private int size;

        private int read() throws IOException {
            if (index >= size) {
                size = in.read(buffer);
                index = 0;

                if (size == -1) {
                    return -1;
                }
            }

            return buffer[index++];
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int value = 0;
            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = read();
            }

            return value * sign;
        }

        long nextLong() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long value = 0;
            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = read();
            }

            return sign == 1 ? value : -value;
        }

        String next() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ' && c != -1);

            StringBuilder value = new StringBuilder();
            while (c > ' ') {
                value.append((char) c);
                c = read();
            }

            return value.toString();
        }
    }
}
```

입력 크기가 매우 작고 구현 속도가 더 중요하면 `Scanner`를 써도 되지만, 큰 입력에서는 `BufferedInputStream`이나 `BufferedReader`가 안전하다.

## 4. SWEA 템플릿

```java
import java.io.BufferedInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(); // 위 기본 템플릿의 FastScanner 사용
        StringBuilder out = new StringBuilder();

        int testCount = fs.nextInt();

        for (int testCase = 1; testCase <= testCount; testCase++) {
            // 입력 및 풀이
            int answer = 0;

            out.append('#')
               .append(testCase)
               .append(' ')
               .append(answer)
               .append('\n');
        }

        System.out.print(out);
    }

    // 여기에 기본 템플릿의 FastScanner 클래스를 붙인다.
}
```

## 5. 현재 파일 컴파일 및 실행

`wh` 폴더에서 현재 문제를 다음과 같이 실행한다.

```powershell
javac -encoding UTF-8 jomang_0721_wh.java
Get-Content input.txt | java Solution
```

직접 입력하려면 컴파일 후 다음 명령을 실행하고 입력을 붙여 넣는다.

```powershell
java Solution
```

새 SWEA 문제 파일도 내부 클래스 이름이 `Solution`이면 같은 방식으로 실행한다.

```powershell
javac -encoding UTF-8 새문제파일.java
Get-Content input.txt | java Solution
```

문제를 바꿀 때 이전 `Solution.class`가 남아 혼동되지 않도록 항상 새 소스를 먼저 컴파일한다. 생성되는 `.class` 파일과 로컬 `input.txt`는 이 폴더의 `.gitignore`에서 제외된다.

## 6. 문제 풀이 순서

1. 입력값의 의미와 범위를 변수 옆에 적는다.
2. 결과가 `int` 범위를 넘을 수 있는지 계산한다.
3. 가장 단순한 풀이의 시간 복잡도를 구한다.
4. 제한 시간 안에 가능한 알고리즘을 선택한다.
5. 정상 입력보다 경계값을 먼저 테스트한다.
6. 제출 직전에 클래스 이름, `package`, 출력 형식을 확인한다.

예를 들어 최대값 두 개를 곱할 때 결과가 약 21억을 넘을 수 있다면 계산 전에 `long`으로 변환한다.

```java
long result = (long) a * b;
```

## 7. 필수 테스트 케이스

- 입력의 최솟값과 최댓값
- 원소가 하나뿐인 경우
- 모든 값이 같은 경우
- 이미 정렬된 경우와 역순인 경우
- 정답이 없거나 항상 가능한 경우
- 결과가 `int` 범위를 넘는 경우
- 시간의 경계처럼 `<`와 `<=`가 달라지는 경우

## 8. 제출 전 체크리스트

- [ ] 제출 코드에서 `package` 선언을 제거했는가?
- [ ] 파일명과 `public class` 이름이 같은가?
- [ ] 디버깅용 출력이 남아 있지 않은가?
- [ ] 테스트 케이스마다 상태를 초기화했는가?
- [ ] 정렬이 필요하다면 실제로 정렬했는가?
- [ ] 나눗셈이 정수 나눗셈인지 실수 나눗셈인지 확인했는가?
- [ ] 누적합과 곱셈에 `long`이 필요한지 확인했는가?
- [ ] 마지막 공백과 줄바꿈이 출력 조건에 어긋나지 않는가?
- [ ] 최악의 입력에서 시간 및 메모리 제한을 만족하는가?

## 9. 자주 사용하는 import

필요한 것만 추가한다.

```java
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
```

`import java.util.*;`도 제출에는 사용할 수 있지만, 학습 중에는 어떤 자료구조를 사용하는지 드러나도록 필요한 클래스만 명시하는 편이 좋다.
