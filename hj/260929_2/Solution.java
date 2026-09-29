import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int startX, startY, endX, endY;
	static boolean[] visited;
	static int[][] superviser;
	
	public static int dfs(int x, int y, int count) {
		if(count == N) {
			return Math.abs(x - endX) + Math.abs(y - endY);
		}
		
		int answer = Integer.MAX_VALUE;
		
		
		for(int i = 0; i<N; i++) {
			int newX = superviser[i][0];
			int newY = superviser[i][1];
			
			if(!visited[i]) {
				visited[i] = true;
				
				int currLength = Math.abs(x - newX)+Math.abs(y - newY);
				int length = currLength + dfs(newX, newY, count+1);
				answer = Math.min(answer, length);
				visited[i] = false;
			}
		}
		
		return answer;
	}

	public static void main(String args[]) throws Exception
	{
		/*
		   1247. [S/W 문제해결 응용] 3일차 - 최적 경로
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			superviser = new int[N][2];
			visited = new boolean[N];
			
			for(int i = 0; i<N; i++) {
				superviser[i][0] = Integer.parseInt(st.nextToken());
				superviser[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int answer = dfs(startX, startY, 0);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}

}
