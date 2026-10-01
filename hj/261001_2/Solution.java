import java.util.*;
import java.io.*;


class Solution
{
	static int V;
	static int E;
	static boolean[] visited;
	static List<Integer>[] graph;
	static StringBuilder answer;
	
	public static void dfs(int start) throws IOException {
		//모든 점 돌아야 하고, 가능한 하나만 제시하면 됨.
		visited[start] = true;
		
		for(int i = 0; i<graph[start].size(); i++) {
			int next = graph[start].get(i);
			
			if(!visited[next]) {
				dfs(next);
			}
		}
		
		answer.append(start).append(" ");
	}
	public static void main(String args[]) throws IOException
	{
		/*
		   1267. [S/W 문제해결 응용] 10일차 - 작업순서
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[V+1];
			for(int i = 1; i<V+1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<E; i++) {
				
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				graph[end].add(start); //역순으로 저장
			}
			
			visited = new boolean[V+1];
			answer = new StringBuilder();
			
			for(int i = 1; i<=V; i++) {
				if(!visited[i]) {
					dfs(i);
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
}