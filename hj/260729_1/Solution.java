import java.util.*;
import java.io.*;

public class Solution {
	//BFS (시작좌표, 미로배열)
	static boolean bfs(int startRow, int startCol, int[][] arr) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[100][100];
		
		int[] dx = {-1, 1,0,0};
		int[] dy = {0,0,-1,1};
		
		queue.offer(new int[] {startRow, startCol});
		visited[startRow][startCol] = true; //초기설정
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx>=100 || ny<0 || ny>=100) {
					continue;
				}
				
				if(arr[nx][ny] ==1 || visited[nx][ny]) {
					continue;
				}
				
				if(arr[nx][ny] == 3) {
					return true;
				}
				
				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny});
			}
		}
		
		return false;
	}

	public static void main(String args[]) throws IOException
	{
		/*
		   1227.미로2
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
		
			int T = Integer.parseInt(br.readLine());
			
			
			int[][] arr = new int[100][100];
			int startRow = 0;
			int startCol = 0;
			
			for(int i=0; i<100; i++) {
				String line = br.readLine(); //g하.. 이거때매틀림
				for(int j=0; j<100; j++) {
					arr[i][j] = line.charAt(j) - '0';
					
					if (arr[i][j] == 2) {
						startRow = i;
						startCol = j;
					}
				}
			}
			
			//경로 존재 유무 찾기 -> DFS or BFS
			int answer = 0;
			if(bfs(startRow, startCol, arr) == true) {answer = 1;}
			
			System.out.println("#"+T+" "+answer);
		}
	}

}
