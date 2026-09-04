/*
4193. 수영대회 결승전 ( 완전 탐색 + 구현 ) (D4)
https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWKaG6_6AGQDFARV&categoryId=AWKaG6_6AGQDFARV&categoryType=CODE
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  public static class Move {
    int x;
    int y;
    int time;

    public Move(int x, int y, int time) {
      this.x = x;
      this.y = y;
      this.time = time;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      int[][] map = new int[N][N];
      boolean[][][] visited = new boolean[N][N][3];  // 위치, 소용돌이 시간 (0 ~ 2, 0에서만 지나갈 수 있음)

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      st = new StringTokenizer(br.readLine());
      int startX = Integer.parseInt(st.nextToken());
      int startY = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int endX = Integer.parseInt(st.nextToken());
      int endY = Integer.parseInt(st.nextToken());

      ArrayDeque<Move> queue = new ArrayDeque<>();
      visited[startX][startY][0] = true;
      queue.offer(new Move(startX, startY, 0));
      int answer = -1;

      while (!queue.isEmpty()) {
        Move cur = queue.poll();

        if (cur.x == endX && cur.y == endY) {
          answer = cur.time;
          break;
        }

        for (int[] d : directions) {
          int nextX = cur.x + d[0];
          int nextY = cur.y + d[1];
          int nextTime = cur.time + 1;

          // 범위 체크
          if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
            continue;
          }

          // 장애물이면 패스
          if (map[nextX][nextY] == 1) {
            continue;
          }

          int nextState = nextTime % 3;

          // 소용돌이이고 지나갈 수 없으면 기다리기
          if (map[nextX][nextY] == 2 && nextState != 0) {
            // 기다린 상태를 방문하지 않았으면 기다리기
            if (!visited[cur.x][cur.y][nextState]) {
              visited[cur.x][cur.y][nextState] = true;
              queue.offer(new Move(cur.x, cur.y, nextTime));
            }
          }
          // 이동
          else {
            if (!visited[nextX][nextY][nextState]) {
              visited[nextX][nextY][nextState] = true;
              queue.offer(new Move(nextX, nextY, nextTime));
            }
          }
        }
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }
}
