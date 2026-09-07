/*
두 명의 손님에게 음식을 제공하려고 한다.

두 명의 손님은 식성이 비슷하기 때문에, 최대한 비슷한 맛의 음식을 만들어 내야 한다.

N개의 식재료가 있다.

식재료들을 각각 N / 2개씩 나누어 두 개의 요리를 하려고 한다. (N은 짝수이다.)

이때, 각각의 음식을 A음식, B음식이라고 하자.

비슷한 맛의 음식을 만들기 위해서는 A음식과 B음식의 맛의 차이가 최소가 되도록 재료를 배분해야 한다.

음식의 맛은 음식을 구성하는 식재료들의 조합에 따라 다르게 된다.
*/
import java.util.*;
import java.io.*;

class Solution
{   
    static int[][] map;
    static int N;
    static int result;
    static boolean[] selected;

    static void calculate(int start, int count) {
        if (count == N / 2) {
            int tasteA = 0;
            int tasteB = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (selected[i] && selected[j]) {
                        tasteA += map[i][j] + map[j][i];
                    } else if (!selected[i] && !selected[j]) {
                        tasteB += map[i][j] + map[j][i];
                    }
                }
            }

            result = Math.min(result, Math.abs(tasteA - tasteB));
            return;
        }

        for (int i = start; i < N; i++) {
            selected[i] = true;
            calculate(i + 1, count + 1);
            selected[i] = false;
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

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            selected = new boolean[N];
            result = Integer.MAX_VALUE;

            calculate(0, 0);

            System.out.println("#" + test_case + " " + result);
		}
	}
}