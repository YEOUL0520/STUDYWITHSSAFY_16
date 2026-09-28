import java.util.*;
import java.io.*;

public class Solution {
	static int[][] map;
	static boolean[][] visited;
	
	static int N;
	static int M;
	
	static int bfs(int startR, int startC) {
        Queue<int[]> q = new ArrayDeque<>();
        int count = 1;
        
        int[] dr = {-1, 1, 0, 0, -1, 1, 1, -1};
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

        visited[startR][startC] = true;
        q.offer(new int[]{startR, startC});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];

            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }
                if (visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
                count++;
                
            }
            
        }
        
        return count;
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			int countStar = 0;
			int count = 0;
			visited = new boolean[N][M];
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					
					if(map[i][j] == 1 && visited[i][j] == false) {
						countStar++;
						int newCount = bfs(i,j);
						answer = Math.max(answer, newCount);
					}
					
				}
			}
			
			System.out.println("#"+test_case+" "+countStar+" "+answer);
		}
		
	}
}
