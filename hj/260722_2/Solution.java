import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		/*
		   5215. 햄버거 다이어트
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			// 주어진 N개를 조합해 L의 범위 내 최대값을 갖는 조합을 찾아야 함
			// 재료 넣을래말래? 넣었을래 이득이야? 아니야?
			
			int[] sc = new int[N];
			int[]cal = new int[N];
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				sc[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] arr = new int[N+1][L+1];
			
			for(int i = 1; i<=N; i++) {
				
				int score = sc[i-1];
				int calory = cal[i-1];
				
				for(int j = 0; j<=L; j++) {
					
					if(calory > j) {
						arr[i][j] = arr[i-1][j];
					}else {
						arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-calory] + score);
					}
					
				}
			}
			
			System.out.println("#"+test_case+ " " + arr[N][L]);

		}
	}
}