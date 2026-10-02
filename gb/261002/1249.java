/*
1249. [S/W 문제해결 응용] 4일차 - 보급로 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD&categoryId=AV15QRX6APsCFAYD&categoryType=CODE&problemTitle=1249&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      int[][] map = new int[N][N];
      int[][] time = new int[N][N];  // 해당 위치에 도달하는데 걸리는 최소 시간 저장

      for (int i = 0; i < N; i++) {
        String line = br.readLine();
        for (int j = 0; j < N; j++) {
          map[i][j] = line.charAt(j) - '0';
          time[i][j] = Integer.MAX_VALUE;
        }
      }

      // (0, 0)부터 시작
      ArrayDeque<int[]> queue = new ArrayDeque<>();
      queue.offer(new int[] { 0, 0 });
      time[0][0] = 0;

      // bfs 실행
      while (!queue.isEmpty()) {
        int[] cur = queue.poll();

        // 다음 위치 찾기
        for (int[] d : directions) {
          int nextR = cur[0] + d[0];
          int nextC = cur[1] + d[1];

          // 범위 체크
          if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) {
            continue;
          }

          // 다음 위치로 갔을 때 걸리는 시간
          int nextTime = time[cur[0]][cur[1]] + map[nextR][nextC];

          // 기존에 구한 시간보다 더 걸리면 패스
          if (time[nextR][nextC] <= nextTime) {
            continue;
          }

          // 다음 위치로 이동
          queue.offer(new int[] { nextR, nextC });
          time[nextR][nextC] = nextTime;
        }
      }

      bw.write("#" + t + " " + time[N - 1][N - 1] + "\n"); 
    }

    bw.flush();
  }
}
