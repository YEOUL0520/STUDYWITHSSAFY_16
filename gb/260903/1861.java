/*
1861. 정사각형 방 (D4) 
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc&categoryId=AV5LtJYKDzsDFAXc&categoryType=CODE&problemTitle=1861&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  public static class Move {
    int[] start;
    int[] position;
    int cnt;

    public Move(int[] start, int[] position, int cnt) {
      this.start = start;
      this.position = position;
      this.cnt = cnt;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      int[][] room = new int[N][N];
      ArrayDeque<Move> queue = new ArrayDeque<>();
      int[][] max = new int[N][N];  // 해당 방에서 시작했을 때 최대 이동 횟수 저장

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          room[i][j] = Integer.parseInt(st.nextToken());
          queue.offer(new Move(new int[] { i, j }, new int[] { i, j }, 1));
        }
      }
      
      while (!queue.isEmpty()) {
        Move cur = queue.poll();
        max[cur.start[0]][cur.start[1]] = Math.max(max[cur.start[0]][cur.start[1]], cur.cnt); // 최대 이동 횟수 갱신

        for (int[] d : directions) {
          int nextX = cur.position[0] + d[0];
          int nextY = cur.position[1] + d[1];

          // 범위 체크
          if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
            continue;
          }

          // 현재 방의 숫자보다 1 크지 않으면 이동 불가능
          if (room[cur.position[0]][cur.position[1]] + 1 != room[nextX][nextY]) {
            continue;
          }

          queue.offer(new Move(cur.start, new int[] { nextX, nextY }, cur.cnt + 1));
        }
      }

      // 최대 이동 횟수를 가지는 시작 방의 번호와 이동 횟수 출력, 이동 횟수 같으면 적힌 수 작은 것
      int[] maxPosition = new int[] { 0, 0 };

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (max[maxPosition[0]][maxPosition[1]] < max[i][j] || (max[maxPosition[0]][maxPosition[1]] == max[i][j] && room[maxPosition[0]][maxPosition[1]] > room[i][j])) {
            maxPosition = new int[] { i, j };
          }
        }
      }

      bw.write("#" + t + " " + room[maxPosition[0]][maxPosition[1]] + " " + max[maxPosition[0]][maxPosition[1]] + "\n");
    }

    bw.flush();
  }
}
