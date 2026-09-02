import java.util.*;
import java.io.*;

class Solution {
    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    private static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int tc = Integer.parseInt(br.readLine());

            int[][] map = new int[16][16];

            Node start = new Node(0, 0);

            for (int i = 0; i < 16; i++) {
                String input = br.readLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = input.charAt(j) - '0';

                    if (map[i][j] == 2)
                        start = new Node(i, j);
                }
            }
            int ans = 0;

            Queue<Node> queue = new LinkedList<>();
            boolean[][] visited = new boolean[16][16];
            
            queue.offer(start);
            visited[start.x][start.y] = true;

            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                int x = curr.x;
                int y = curr.y;

                if (map[x][y] == 3) {
                    ans = 1;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= 16 || ny < 0 || ny >= 16) {
                        continue;
                    }

                    if (map[nx][ny] == 1 || visited[nx][ny])
                        continue;

                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}