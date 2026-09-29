import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int [][] p = new int [N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    p[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            double[] dp = new double[1 << N];
            dp[0] = 1.0;

            for (int mask = 0; mask < (1 << N) - 1; mask++) {
                int employee = Integer.bitCount(mask);
                for (int job = 0; job < N; job++) {
                    if ((mask & (1 << job)) == 0) {
                        int nextMask = mask | (1 << job);
                        double nextP = dp[mask] * p[employee][job] / 100.0;
                        dp[nextMask] = Math.max(dp[nextMask], nextP);
                    }
                }
            }
            double answer = dp[(1 << N) - 1] * 100.0;
            System.out.printf("#%d %.6f%n", test_case, answer);
		}
	}
}