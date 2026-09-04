/*
1226. [S/W 문제해결 기본] 7일차 - 미로1 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14vXUqAGMCFAYD&categoryId=AV14vXUqAGMCFAYD&categoryType=CODE&problemTitle=1226&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int t = 1; t <= 10; t++) {
      int testcase = Integer.parseInt(br.readLine());

      int[][] map = new int[16][16];
      int[] start = new int[2];

      for (int i = 0; i < map.length; i++) {
        String line = br.readLine();
        for (int j = 0; j < map[i].length; j++) {
          map[i][j] = line.charAt(j) - '0';

          if (map[i][j] == 2) {
            start = new int[] { i, j };
          }
        }
      }

      boolean isPossible = false;
      ArrayDeque<int[]> queue = new ArrayDeque<>();
      queue.offer(start);
      map[start[0]][start[1]] = 1;

      while (!queue.isEmpty()) {
        int[] cur = queue.poll();

        for (int[] d : directions) {
          int nextX = cur[0] + d[0];
          int nextY = cur[1] + d[1];

          if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map.length) {
            continue;
          }

          if (map[nextX][nextY] == 1) {
            continue;
          }

          if (map[nextX][nextY] == 3) {
            isPossible = true;
            queue.clear();
            break;
          }

          queue.offer(new int[] { nextX, nextY });
          map[nextX][nextY] = 1;
        }
      }

      bw.write("#" + testcase + " " + (isPossible ? "1" : "0") + "\n");
    }

    bw.flush();
  }
}
