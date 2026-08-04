
/*
아래 그림과 같은 미로가 있다. 100*100 행렬의 형태로 만들어진 미로에서 흰색 바탕은 길, 노란색 바탕은 벽을 나타낸다.
가장 좌상단에 있는 칸을 (0, 0)의 기준으로 하여, 가로방향을 x 방향, 세로방향을 y 방향이라고 할 때, 미로의 시작점은 (1, 1)이고 도착점은 (13, 13)이다.
주어진 미로의 출발점으로부터 도착지점까지 갈 수 있는 길이 있는지 판단하는 프로그램을 작성하라.
[입력]
1은 벽을 나타내며 0은 길, 2는 출발점, 3은 도착점을 나타낸다.
[출력]
도달 가능 여부를 1 또는 0으로 표시한다 (1 - 가능함, 0 - 가능하지 않음).
 */
import java.util.*;
import java.io.*;

class Solution {
	public static int[] dr = { -1, 1, 0, 0 }; // row 방향
	public static int[] dc = { 0, 0, -1, 1 }; // col 방향

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int possible = 0; // Default is not possible
			int[][] maze = new int[100][100];
			int[][] visited = new int[100][100];

			Queue<int[]> route = new LinkedList<>();

			route.add(new int[] { 1, 1 });
			visited[1][1] = 1;

			for (int i = 0; i < 100; i++) {
				String line = br.readLine();

				for (int j = 0; j < 100; j++) {
					maze[i][j] = line.charAt(j) - '0';
				}
			}

			while (!route.isEmpty()) {
				int[] curr = route.element();
				route.remove();

				int row = curr[0];
				int col = curr[1];

				if (maze[row][col] == 3) {
					possible = 1;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int px = row + dr[i];
					int py = col + dc[i];

					if (px >= 1 && py >= 1 && px < 100 && py < 100) {
						if (maze[px][py] != 1 && visited[px][py] == 0) {

							visited[px][py] = 1;

							route.offer(new int[] { px, py });
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + possible);
		}
	}
}