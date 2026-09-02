import java.util.*;
import java.io.*;


public class Solution {
	public static boolean bfs(int[] arr1, int[] arr2) {
		Queue<Integer> q = new ArrayDeque<> ();
		
		boolean[] visited = new boolean[100];
		visited[0] = true;
		
		q.offer(0);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(arr1[now] != -1) {
				int next = arr1[now];
				
				if(next == 99) {
					return true;
				}
				
				if(!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
			if(arr2[now] != -1) {
				int next = arr2[now];
				
				if(next == 99) {
					return true;
				}
				
				if(!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
		
		return false;
	}
	public static void main(String args[]) throws IOException
	{
		/*
		   1219. [S/W 문제해결 기본] 4일차 - 길찾기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			int[] arr1 = new int[100];
			int[] arr2 = new int[100];
			
			Arrays.fill(arr1, -1);
			Arrays.fill(arr2, -1);
			
			for(int i = 0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(arr1[x] == -1) {
					arr1[x] = y;
				}else {
					arr2[x] = y;
				}
			}
			
			int answer = bfs(arr1, arr2) ? 1 : 0;
			System.out.println("#"+test_case+" "+answer);
		}
	}

}
