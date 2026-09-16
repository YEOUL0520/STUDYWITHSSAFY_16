/*
1953. [모의 SW 역량테스트] 탈주범 검거
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq&categoryId=AV5PpLlKAQ4DFAUq&categoryType=CODE&problemTitle=1953&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };  // 상하좌우
  public static int[][] map;

  public static class Move {
    int r;
    int c;
    int time;

    public Move(int r, int c, int time) {
      this.r = r;
      this.c = c;
      this.time = time;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); // 세로 크기
      int M = Integer.parseInt(st.nextToken()); // 가로 크기
      int R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 세로 위치
      int C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 가로 위치
      int L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간

      map = new int[N][M];
      boolean[][] visited = new boolean[N][M];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());

          if (map[i][j] == 0) {
            visited[i][j] = true;
          }
        }
      }

      int answer = 0;

      ArrayDeque<Move> queue = new ArrayDeque<>();
      queue.offer(new Move(R, C, 1));
      visited[R][C] = true;

      while (!queue.isEmpty()) {
        Move cur = queue.poll();

        if (cur.time > L) {
          break;
        }

        answer++;

        for (int dIdx = 0; dIdx < directions.length; dIdx++) {
          int nextR = cur.r + directions[dIdx][0];
          int nextC = cur.c + directions[dIdx][1];

          // 범위 체크
          if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) {
            continue;
          }

          // 현재 위치에서 다음 위치로 갈 수 있는지 확인
          if (!checkConnect(cur.r, cur.c, nextR, nextC, dIdx)) {
            continue;
          }

          // 방문 체크
          if (visited[nextR][nextC]) {
            continue;
          }

          queue.offer(new Move(nextR, nextC, cur.time + 1));
          visited[nextR][nextC] = true;
        }
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }

  /* 현재 위치와 다음 위치가 연결되어 있는지 확인 */
  public static boolean checkConnect(int r, int c, int nextR, int nextC, int dIdx) {
    int cur = map[r][c];
    int next = map[nextR][nextC];

    switch (cur) {
      case 1: // 상하좌우
        if ((dIdx == 0 && (next == 1 || next == 2 || next == 5 || next == 6)) || (dIdx == 1 && (next == 1 || next == 2 || next == 4 || next == 7)) || (dIdx == 2 && (next == 1 || next == 3 || next == 4 || next == 5)) || (dIdx == 3 && (next == 1 || next == 3 || next == 6 || next == 7))) {
          return true;
        }
        break;
      case 2: // 상하
        if ((dIdx == 0 && (next == 1 || next == 2 || next == 5 || next == 6)) || (dIdx == 1 && (next == 1 || next == 2 || next == 4 || next == 7))) {
          return true;
        }
        break;
      case 3: // 좌우
        if ((dIdx == 2 && (next == 1 || next == 3 || next == 4 || next == 5)) || (dIdx == 3 && (next == 1 || next == 3 || next == 6 || next == 7))) {
          return true;
        }
        break;
      case 4: // 상우
        if ((dIdx == 0 && (next == 1 || next == 2 || next == 5 || next == 6)) || (dIdx == 3 && (next == 1 || next == 3 || next == 6 || next == 7))) {
          return true;
        }
        break;
      case 5: // 하우
        if ((dIdx == 1 && (next == 1 || next == 2 || next == 4 || next == 7)) || (dIdx == 3 && (next == 1 || next == 3 || next == 6 || next == 7))) {
          return true;
        }
        break;
      case 6: // 하좌
        if ((dIdx == 1 && (next == 1 || next == 2 || next == 4 || next == 7)) || (dIdx == 2 && (next == 1 || next == 3 || next == 4 || next == 5))) {
          return true;
        }
        break;
      case 7: // 상좌
        if ((dIdx == 0 && (next == 1 || next == 2 || next == 5 || next == 6)) || (dIdx == 2 && (next == 1 || next == 3 || next == 4 || next == 5))) {
          return true;
        }
        break;
    }

    return false;
  }
}
