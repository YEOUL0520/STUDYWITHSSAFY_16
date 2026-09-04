import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int firstNode = Integer.parseInt(st.nextToken());
			int secondNode = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			int[] parent = new int[V+1]; //자식에게 연결된 부모
			ArrayList<Integer>[] child = new ArrayList[V+1];//부모에게 연결된 자식
			
			//ArrayList 각 칸 초기화 필요
			for(int i = 1; i<= V; i++) {
				child[i] = new ArrayList<>();
			}
			
			for(int i = 0; i<E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				parent[to] = from;
				child[from].add(to);
			}
			
			int sameParent = 0;
			int nowNode = firstNode;
			
			boolean[] visited = new boolean[V+1];
			while(nowNode != 0) {
				visited[nowNode] = true;
				nowNode = parent[nowNode];
			}
			
			nowNode = secondNode;
			while(nowNode != 0) {
				if(visited[nowNode]) {
					sameParent = nowNode;
					break;
				}else {
					nowNode = parent[nowNode];
				}
			}
			
			int size = 0;
			
			Queue<Integer> q = new ArrayDeque<Integer>();
			q.offer(sameParent);
			
			while(!q.isEmpty()) {
				int start = q.poll();
				size++;
				
				for(int next: child[start]) {
					q.offer(next);
				}
			}
			
			System.out.println("#"+test_case+" "+sameParent+" "+size);
		}
		
	}

}
