/*
1949. [모의 SW 역량테스트] 등산로 조성
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq&categoryId=AV5PoOKKAPIDFAUq&categoryType=CODE&problemTitle=1949&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
  public static int[][] map;
  public static boolean[][] visited;
  public static int K;
  public static int maxLength;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      map = new int[N][N];
      visited = new boolean[N][N];
      int max = 0;

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
          max = Math.max(max, map[i][j]);
        }
      }

      ArrayList<int[]> high = new ArrayList<>();

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] == max) {
            high.add(new int[] { i, j });
          }
        }
      }

      maxLength = 0;

      // 시작점에서 dfs 시작
      for (int[] highXY : high) {
        visited[highXY[0]][highXY[1]] = true;
        dfs(highXY[0], highXY[1], 1, false);
        visited[highXY[0]][highXY[1]] = false;
      }

      bw.write("#" + t + " " + maxLength + "\n");
    }

    bw.flush();
  }

  public static void dfs(int x, int y, int length, boolean useDig) {
    maxLength = Math.max(maxLength, length);

    for (int[] d : directions) {
      int nextX = x + d[0];
      int nextY = y + d[1];

      if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length) {
        continue;
      }

      if (visited[nextX][nextY]) {
        continue;
      }

      // 숫자 작으면 이동
      if (map[x][y] > map[nextX][nextY]) {
        visited[nextX][nextY] = true;
        dfs(nextX, nextY, length + 1, useDig);
        visited[nextX][nextY] = false;
      } else {
        // 숫자 안 작은데 파기 안썼으면 쓰고 이동
        if (!useDig && map[x][y] > map[nextX][nextY] - K) {
          int temp = map[nextX][nextY];
          map[nextX][nextY] = map[x][y] - 1;
          visited[nextX][nextY] = true;
          dfs(nextX, nextY, length + 1, !useDig);
          visited[nextX][nextY] = false;
          map[nextX][nextY] = temp;
        }
      }
    }
  }
}
