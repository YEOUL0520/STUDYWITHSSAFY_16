import java.util.*;
import java.io.*;

/*
   1263. [S/W 문제해결 응용] 8일차 - 사람 네트워크2
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			int[][] dist = new int[N][N];
			int[] cc = new int[N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//재귀적으로 탐색해 들어가면서 각 point에서의 거리 구하기?
			//1일 경우 ++
			int INF = 1_000_000; //MAX_VALUE 쓰면 안되네;
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(i == j) {
						dist[i][j] = 0;
					}
					else if(arr[i][j] == 1) {
						dist[i][j] = 1;
					}
					else if(arr[i][j] == 0){
						dist[i][j] = INF;
					}
				}
			}
			
			for(int k = 0; k<N; k++) {
				for(int i = 0; i<N; i++) {
					for(int j = 0; j<N; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					cc[i] += dist[i][j];
				}
			}
			
			int ans = Integer.MAX_VALUE;
			
			for(int i = 0; i<N; i++) {
				ans = Math.min(ans, cc[i]);
			}
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
}