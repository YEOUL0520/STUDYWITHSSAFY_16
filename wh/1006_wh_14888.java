import java.io.*;
import java.util.*;

class Solution
{
    static int[] operators;
    static int[] numbers;
    static int max, min, N;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            numbers = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // +, -, *, /
            operators = new int[4];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                operators[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            // numbers[0]은 이미 사용했으므로 다음 숫자는 index 1부터
            calculate(numbers[0], 1);

            System.out.println(max);
            System.out.println(min);
        }
    }

    static void calculate(int number, int count)
    {
        // 모든 숫자를 사용한 경우
        if (count == N) {
            min = Math.min(min, number);
            max = Math.max(max, number);
            return;
        }

        // 0: +, 1: -, 2: *, 3: /
        for (int i = 0; i < 4; i++)
        {
            if (operators[i] == 0) {
                continue;
            }

            operators[i]--;

            switch (i)
            {
                case 0:
                    calculate(
                        number + numbers[count],
                        count + 1
                    );
                    break;

                case 1:
                    calculate(
                        number - numbers[count],
                        count + 1
                    );
                    break;

                case 2:
                    calculate(
                        number * numbers[count],
                        count + 1
                    );
                    break;

                case 3:
                    calculate(
                        number / numbers[count],
                        count + 1
                    );
                    break;
            }

            operators[i]++;
        }
    }
}