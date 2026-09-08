import java.util.*;
import java.io.*;

class Solution {
	static int N, K;
	static int[][] map;
	static boolean[][] visited;
	static int ans;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void dfs(int x, int y, int length, boolean usedCut) {
		
		//현재까지 만든 등산로 길이 저장
		ans = Math.max(ans, length);
		
		for(int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			//범위를 벗어난 경우
			if(newX < 0 || newY < 0 || newX >= N || newY >= N) {
				continue;
			}
			
			//현재 경로에서 이미 방문한 경우
			if(visited[newX][newY]) {
				continue;
			}
			
			//다음 칸이 현재 칸보다 작을때
			if(map[newX][newY] < map[x][y]) {
				visited[newX][newY] = true;
				
				dfs(newX, newY, length + 1, usedCut);
				
				visited[newX][newY] = false;
			}
			
			//다음 칸이 현재보다 높거나 같을때
			else if(!usedCut) {
				
				//다음 칸을 현재 칸보다 1 낮게 만들 때 필요한 공사 깊이
				int cut = map[newX][newY] - map[x][y] + 1;
				
				if(cut <= K) {
					int originalHeight = map[newX][newY];
					
					//현재 칸보다 1 낮게 깎기
					map[newX][newY] = map[x][y] - 1;
					visited[newX][newY] = true;
					
					dfs(newX, newY, length + 1, true);
					
					//다른 경로 탐색을 위해 원상 복구
					visited[newX][newY] = false;
					map[newX][newY] = originalHeight;
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//가장 높은 봉우리들의 위치 저장
			ArrayList<int[]> high = new ArrayList<>();
			int max = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					
					if(map[i][j] > max) {
						max = map[i][j];
						high.clear();
						high.add(new int[]{i, j});
					}
					else if(map[i][j] == max) {
						high.add(new int[]{i, j});
					}
				}
			}
			
			ans = 0;
			visited = new boolean[N][N];
			
			//모든 최고봉을 시작점으로 DFS 실행
			for(int[] pos : high) {
				int startX = pos[0];
				int startY = pos[1];
				
				visited[startX][startY] = true;
				
				dfs(startX, startY, 1, false);
				
				visited[startX][startY] = false;
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
}