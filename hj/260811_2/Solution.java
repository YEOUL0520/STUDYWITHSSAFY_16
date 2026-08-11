import java.util.*;
import java.io.*;


public class Solution {
  //좌표 및 비용 정보 저장을 위한 Node 클래스를 생성
	public static class Node{
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		/*
		   1249. [S/W 문제해결 응용] 4일차 - 보급로
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				String input = br.readLine();
				for(int j = 0; j<N; j++) {
					arr[i][j] = input.charAt(j) -'0';
				}
			}
			
			int[][] dist = new int[N][N];
			for(int i = 0; i<N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			int[] dx = {1, -1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			
      //Node 정렬 기준을 작성 -> cost 가 작은 Node 부터 꺼낼 수 있도록 함.
			PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost, b.cost));
			
			dist[0][0] = 0;
			
			pq.offer(new Node(0, 0, dist[0][0]));
			
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				int x = now.x;
				int y = now.y;
				int cost = now.cost;
				
				if(cost > dist[x][y]) {
					continue;
				}
				
				for(int i = 0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
          //범위 안에 있는지를 검토
					if(ny>= N || nx >= N || ny< 0 || nx <0) {
						continue;
					}
					
					int newCost = cost + arr[nx][ny];
					
          //비용이 작을 경우엔 갱신 후 queue에 삽입
					if(newCost < dist[nx][ny]) {
						dist[nx][ny] = newCost;
						pq.offer(new Node(nx, ny, newCost));
					}
				}
			}
			
			System.out.println("#"+test_case+" "+dist[N-1][N-1]);
		}
	}

}
