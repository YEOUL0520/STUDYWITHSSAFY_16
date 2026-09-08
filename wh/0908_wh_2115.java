/*
[입력]
10 // 전체 테스트 케이스 숫자
4 2 13
6 1 9 7    
9 8 5 8
3 4 5 3
8 2 6 7
[출력]
#1 174
*/
import java.util.*;
import java.io.*;

class Solution
{
    static int N;
    static int M;
    static int C;
    static int[][] barrel;
    static int result = 0;
    static int max_section;
    static int[][] profits;
    static void calculate(int r, int start, int idx, int sum, int profit) {
        if (idx == M) {
            max_section = Math.max(max_section, profit);
            return;
        }

        calculate(r, start, idx + 1, sum, profit);

        int honey = barrel[r][start + idx];

        if (sum + honey <= C) {
            calculate(r, start, idx + 1, sum + honey, profit + honey * honey);
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
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            barrel = new int[N][N];
            profits = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    barrel[i][j] = Integer.parseInt(st.nextToken()); 
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    max_section = 0;
                    calculate(i, j, 0, 0, 0);
                    profits[i][j] = max_section;
                }
            }

            result = 0;

            for (int r1 = 0; r1 < N; r1++) {
                for (int c1 = 0; c1 <= N - M; c1++) {
                    for (int r2 = 0; r2 < N; r2++) {
                        for (int c2 = 0; c2 <= N - M; c2++) {

                            boolean notOverlap = r1 != r2 ||
                                    c1 + M <= c2 ||
                                    c2 + M <= c1;

                            if (notOverlap) {
                                result = Math.max(
                                        result,
                                        profits[r1][c1] + profits[r2][c2]);
                            }
                        }
                    }
                }
            }


            System.out.println("#" + test_case + " " + result);
		}
	}
}