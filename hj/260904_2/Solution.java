import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			//0이면 갈 수 있고. 2면 count를 2증가시키는 방식으로. queue에 넣어서.
			
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {startX,startY,0});
			arr[startX][startY] = -1;
			int answer = -1;
			
			while(!q.isEmpty()) {
				int[] now = q.poll();
				int time = now[2];
				boolean wait = false;
				
				int[] dx = {1, -1, 0, 0};
				int[] dy = {0, 0, 1, -1};
				
				if(now[0] == endX && now[1] == endY) {
					answer = time;
					break;
				}
				
				for(int i = 0; i<4; i++) {
					int newX = now[0]+dx[i];
					int newY = now[1]+dy[i];
					
					if(newX < 0 || newX >= N || newY < 0 || newY >= N) {
						continue;
					}
					
					if(arr[newX][newY] == -1 || arr[newX][newY] == 1) {
						continue;
					}else if(arr[newX][newY] == 2){
						if(time%3 == 2) {
							q.offer(new int[] {newX, newY, time+1});
							arr[newX][newY] = -1;
						}else {
							wait = true;
						}
	
					}else if(arr[newX][newY] == 0) {
						q.offer(new int[] {newX, newY, time+1});
						arr[newX][newY] = -1;
					}
				}
				
				if(wait) {
					q.offer(new int[] {now[0], now[1], time+1});
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}

}
