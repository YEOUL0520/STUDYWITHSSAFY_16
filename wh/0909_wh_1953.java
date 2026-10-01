import java.util.*;
import java.io.*;

class Solution
{
    static int N;
    static int M;
    static int R; 
    static int C;
    static int L;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] opposite = {1, 0, 3, 2};
    static boolean[][] open = {
        {},                                  // 0: 터널 없음
        {true,  true,  true,  true},         // 1: 상하좌우
        {true,  true,  false, false},        // 2: 상하
        {false, false, true,  true},         // 3: 좌우
        {true,  false, false, true},         // 4: 상우
        {false, true,  false, true},         // 5: 하우
        {false, true,  true,  false},        // 6: 하좌
        {true,  false, true,  false}         // 7: 상좌
    };  
    static int result = 0;

    static int calculate() {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {R, C});
        visited[R][C] = 1;
        
        int count = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int x = curr[0];
            int y = curr[1];
            int time = visited[x][y];

            if (time == L) {
                continue;
            }

            int curr_type = map[x][y];

            for (int d = 0; d < 4; d++) {
                if (!open[curr_type][d]) {
                    continue;
                }

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    continue;
                }

                if (visited[nx][ny] != 0) {
                    continue;
                }

                int next_type = map[nx][ny];

                if (!open[next_type][opposite[d]]) {
                    continue;
                }

                visited[nx][ny] = time + 1;
                count++;

                queue.offer(new int[] {nx, ny});
            }
        }

        return count;
    }

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            result = calculate();

            System.out.println("#" + test_case + " " + result);
		}
	}
} 