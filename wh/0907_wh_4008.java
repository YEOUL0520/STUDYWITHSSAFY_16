/*
선표는 게임을 통해 사칙 연산을 공부하고 있다.

N개의 숫자가 적혀 있는 게임 판이 있고, +, -, x, / 의 연산자 카드를 숫자 사이에 끼워 넣어 다양한 결과 값을 구해보기로 했다.

수식을 계산할 때 연산자의 우선 순위는 고려하지 않고 왼쪽에서 오른쪽으로 차례대로 계산한다.

예를 들어 1, 2, 3 이 적힌 게임 판에 +와 x를 넣어 1 + 2 * 3을 만들면 1 + 2를 먼저 계산하고 그 뒤에 * 를 계산한다.

즉 1+2*3의 결과는 9이다.

[제약사항]
1. 시간 제한 : 최대 50 개 테스트 케이스를 모두 통과하는 데 C / C++ / Java 모두 3 초

2. 게임 판에 적힌 숫자의 개수 N 은 3 이상 12 이하의 정수이다. ( 3 ≤ N ≤ 12 )

3. 연산자 카드 개수의 총 합은 항상 N - 1 이다.

4. 게임 판에 적힌 숫자는 1 이상 9 이하의 정수이다.

5. 수식을 완성할 때 각 연산자 카드를 모두 사용해야 한다..

6. 숫자와 숫자 사이에는 연산자가 1 개만 들어가야 한다.

7. 완성된 수식을 계산할 때 연산자의 우선 순위는 고려하지 않고, 왼쪽에서 오른쪽으로 차례대로 계산한다.

8. 나눗셈을 계산 할 때 소수점 이하는 버린다.

9. 입력으로 주어지는 숫자의 순서는 변경할 수 없다.

10. 연산 중의 값은 -100,000,000 이상 100,000,000 이하임이 보장된다.

[입력]
입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T 가 주어지고,

그 다음 줄부터 T 개의 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 숫자의 개수 N 이 주어진다.

다음 줄에는 '+', '-', '*', '/' 순서대로 연산자 카드의 개수가 공백을 사이에 두고 주어진다.

다음 줄에는 수식에 들어가는 N 개의 숫자가 순서대로 공백을 사이에 두고 주어진다.

[출력]
테스트 케이스 개수만큼 T 개의 줄에 각각의 테스트 케이스에 대한 답을 출력한다.

각 줄은 "#t" 로 시작하고 공백을 하나 둔 다음 정답을 출력한다. ( t 는 1 부터 시작하는 테스트 케이스의 번호이다. )

정답은 연산자 카드를 사용하여 만들 수 있는 수식으로 얻은 결과값 중 최댓값과 최솟값의 차이이다.
*/
import java.util.*;
import java.io.*;

class Solution
{   
    static int[] operators;
    static int[] numbers;
    static int N;
    static int min;
    static int max;

    static void calculate(int index, int value) {
        if (index == N) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0)
                continue;

            operators[i]--;

            int next = value;

            switch (i) {
                case 0:
                    next = value + numbers[index];
                break;
                case 1:
                    next = value - numbers[index];
                break;
                case 2:
                    next = value * numbers[index];
                break;
                case 3:
                    next = value / numbers[index];
                break;
            }

            calculate(index + 1, next);
            operators[i]++;
        }
    }
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());

            operators = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operators[i] = Integer.parseInt(st.nextToken());
            }

            numbers = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            
            calculate(1, numbers[0]);

            System.out.println("#" + test_case + " " + (max - min));
		}
	}
}