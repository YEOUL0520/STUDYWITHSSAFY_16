import java.util.*;
import java.io.*;

public class Solution {
	static double answer;
	static int N;
	static int[][] probability;
	static boolean[] visited;
	
	public static void dfs(int person, double currPercent) {
		// 조합들 중 확률이 최대가 되는 조합을 골라야 하는 문제.
		// 첫 번째 직원이 고를 수 있는 가짓수 = n개. 두 번째 직원이 고를 수 있는 가짓수 = n-1개. ... 마지막 직원은 1개. 재귀적으로.. 어떻게?

		if (currPercent <= answer) {
			return;
		}
		
		if(person == N) {
			answer = Math.max(answer, currPercent);
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				
				dfs(person+1, currPercent * probability[person][i]/100.0);
				
				visited[i] = false; //재귀 끝나면 되돌리기
			}
		}
	}
	public static void main(String args[]) throws IOException
	{
		/*
		   1865. 동철이의 일 분배
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			
			//주어지는 값은 정수 형태, 해당 정수가 0. 뒤의 소수점 자리가 됨에 유의할 것. 마지막에 /10000 연산 수행해주면 될 듯?
			
			probability = new int[N][N];
			visited = new boolean[N];
			answer = 0.0;
			
			
			for (int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					probability[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 1.0);
			
			
			sb.append("#").append(test_case).append(" ").append(String.format("%.6f", answer*100)).append("\n");
		}
		
		System.out.print(sb);
	}
}
