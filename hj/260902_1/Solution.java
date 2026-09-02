import java.util.*;
import java.io.*;


public class Solution {
	public static boolean bfs(int startX, int startY, int[][] arr) {
		Queue<int[]> q = new ArrayDeque<>();
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		q.offer(new int[]{startX, startY});
		arr[startX][startY] = -1;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int k = 0; k<4; k++) {
				int newX = now[0]+dx[k];
				int newY = now[1]+dy[k];
				
				if(newX < 0 || newY < 0 || newX >= 16 || newY >= 16) {
					continue;
				}
				
				if(arr[newX][newY] == 1 || arr[newX][newY] == -1) {
					continue;
				}
				
				if(arr[newX][newY] == 3) {
					return true;
				}
				
				arr[newX][newY] = -1;
				q.offer(new int[] {newX, newY});
			}
		}
		
		return false;
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		   1226. [S/W 문제해결 기본] 7일차 - 미로1
		*/

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			br.readLine();
			
			int[][] arr = new int[16][16];
			
			int startI = 0;
			int startJ = 0;
			
			int endI = 0;
			int endJ = 0;
			
			for(int i = 0; i<16; i++) {
				String line = br.readLine();
				for(int j = 0; j<16; j++) {
					arr[i][j] = line.charAt(j) - '0';
					if(arr[i][j] == 2) {
						startI = i;
						startJ = j;
					}
				}
			}
			
			//스택으로 풀어서 안에 3이 있는지 확인해도 좋을 것 같은데, 연습하는 겸 bfs 로 품.
			int answer = bfs(startI, startJ, arr) ? 1 : 0;
			System.out.println("#"+test_case+" "+answer);
		}
	}

}
