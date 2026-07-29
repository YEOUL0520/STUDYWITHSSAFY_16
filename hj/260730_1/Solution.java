import java.util.*;
import java.io.*;

public class Solution {
	public static boolean bfs(int startRow, int startCol, int[][] arr) {
		Queue<int[]> queue = new ArrayDeque<>();
		int[][] visited = new int[16][16];
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		queue.offer(new int[] {startRow, startCol});
		visited[startRow][startCol] = 1;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			
			for(int i=0;i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= 16 || ny < 0 || ny >=16) {
					continue;
				}
				if(visited[nx][ny] == 1 || arr[nx][ny] == 1) {
					continue;
				}
				if(arr[nx][ny] == 3) {
					queue.clear();
					return true;
				}
				
				visited[nx][ny] = 1;
				queue.offer(new int[] {nx, ny});
			}
		}
		queue.clear();
		return false;
	}

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[16][16];
			int startRow = 0;
			int startCol = 0;
			
			for(int i = 0; i<16; i++) {
				String line = br.readLine();
				for(int j = 0; j<16; j++) {
					arr[i][j] = line.charAt(j) - '0';
					if(arr[i][j] == 2) {
						startRow = i;
						startCol = j;
					}
				}
			}
			
			int answer = 0;
			if(bfs(startRow, startCol, arr) == true) answer = 1;
			System.out.println("#"+test_case+" "+answer);                                                                                                                                                                                                                                                                                                                                                                                                         
		}
	}

}
