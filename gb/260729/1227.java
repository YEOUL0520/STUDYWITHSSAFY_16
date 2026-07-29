/*
1227. [S/W 문제해결 기본] 7일차 - 미로2 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV14wL9KAGkCFAYD&categoryId=AV14wL9KAGkCFAYD&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=4&pageSize=10&pageIndex=2&&&&&&&&&&
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int t = 1; t <= 10; t++) {
      br.readLine();

      int[][] map = new int[100][100];
      boolean[][] isVisit = new boolean[100][100];
      boolean isPossible = false;

      int startX = 0;
      int startY = 0;

      for (int i = 0; i < 100; i++) {
        String line = br.readLine();
        for (int j = 0; j < 100; j++) {
          map[i][j] = line.charAt(j) - '0';
          
          // 시작점 찾기
          if (map[i][j] == 2) {
            startX = i;
            startY = j;
          }
        }
      }

      Queue<int[]> queue = new LinkedList<>();
      queue.add(new int[] {startX, startY});
      isVisit[startX][startY] = true;

      while(!queue.isEmpty()) {
        int[] cur = queue.poll();

        for (int[] d : directions) {
          int nextX = cur[0] + d[0];
          int nextY = cur[1] + d[1];

          if (nextX < 0 || nextY < 0 || nextX >= 100 || nextY >= 100) {
            continue;
          }

          // 이동할 위치가 벽이거나 방문한 곳이면 패스
          if (map[nextX][nextY] == 1 || isVisit[nextX][nextY]) {
            continue;
          }

          // 도착지에 도착했으면 탐색 종료
          if (map[nextX][nextY] == 3) {
            isPossible = true;
            queue.clear();
            break;
          }

          isVisit[nextX][nextY] = true;
          queue.add(new int[] {nextX, nextY});
        }
      }

      bw.write("#" + t + " " + (isPossible ? "1" : "0") + "\n");
    }

    bw.flush();
  }
}
