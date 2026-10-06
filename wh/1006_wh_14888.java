import java.io.*;
import java.util.*;

class Solution
{
    static int operators[];
    static int numbers[];
    static int max, min, N, number;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            numbers = new int[N];
            for (int i = 0; i  < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            operators = new int[N - 1];
            for (int j = 0; j < N - 1; j++) {
                operators[j] = Integer.parseInt(st.nextToken());
            }

            calculate(numbers[0], 0);
            
            System.out.println("#" + test_case + " ");
		}
	}

    static void calculate(int number, int count) {
        if (count == N) {
            min = Math.min(number, min);
            max = Math.max(number,max);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (operators[i] == 0) {
                continue;
            }

            operators[i]--;
            switch (i) {
                case 0:
                    calculate(number + numbers[count], count + 1);
                    break;
                case 1: 
                    calculate(number - numbers[count], count + 1);
                    break;
                case 2: 
                    calculate(number * numbers[count], count + 1);
                    break;
                case 3: 
                    calculate(number / numbers[count], count + 1);
                    break;
                default:
                    throw new AssertionError();
            }
            operators[i]++;
        }
    }
}