/*
1824. 혁진이의 프로그램 검증 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4yLUiKDUoDFAUx&categoryId=AV4yLUiKDUoDFAUx&categoryType=CODE&problemTitle=1824&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] directions = new int[][] {{ -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};  // 상하좌우
  public static char[][] map;
  public static boolean[][][][] isVisit;  // x, y, 이동 방향, 메모리 값을 저장해 방문 체크
  public static Boolean isPossible;

  public static class Move {
    int x;
    int y;
    int memory;
    int dIdx;

    public Move(int x, int y, int memory, int dIdx) {
      this.x = x;
      this.y = y;
      this.memory = memory;
      this.dIdx = dIdx;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      int R = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());

      map = new char[R][C];
      for (int i = 0; i < R; i++) {
        String line = br.readLine();
        for (int j = 0; j < C; j++) {
          map[i][j] = line.charAt(j);
        }
      }

      isVisit = new boolean[R][C][4][16]; // 이동 방향: 0~3, 메모리 값: 0~15
      isPossible = false;

      Stack<Move> stack = new Stack<>();
      stack.add(new Move(0, 0, 0, 3));  // 위치 초기값: (0, 0), 메모리 초기값: 0, 이동 방향 초기값: 오른쪽

      while (!stack.isEmpty() && !isPossible) {
        Move cur = stack.pop();

        // 맵 방향 체크
        if (cur.x < 0) cur.x = map.length - 1;
        if (cur.x >= map.length) cur.x = 0;
        if (cur.y < 0) cur.y = map[0].length - 1;
        if (cur.y >= map[0].length) cur.y = 0;

        // 방문했었으면 종료
        if (isVisit[cur.x][cur.y][cur.dIdx][cur.memory]) {
          continue;
        }

        // 도착지이면 true로 바꾸고 종료
        char value = map[cur.x][cur.y];
        
        if (value == '@') {
          isPossible = true;
          break;
        }

        // 방문 처리
        isVisit[cur.x][cur.y][cur.dIdx][cur.memory] = true;

        // 입력 처리
        switch (value) {
          case '<':
            cur.dIdx = 2;
            break;
          
          case '>':
            cur.dIdx = 3;
            break;

          case '^':
            cur.dIdx = 0;
            break;
          
          case 'v':
            cur.dIdx = 1;
            break;

          case '_':
            if (cur.memory == 0) { 
              cur.dIdx = 3;
            } else {
              cur.dIdx = 2;
            }
            break;

          case '|':
            if (cur.memory == 0) {
              cur.dIdx = 1;
            } else {
              cur.dIdx = 0;
            }
            break;

          case '?':
            for (int d = 0; d < directions.length; d++) {
              int nextX = cur.x + directions[d][0];
              int nextY = cur.y + directions[d][1];
              stack.add(new Move(nextX, nextY, cur.memory, d));
            }
            break;

          case '.':
            break;

          case '+':
            cur.memory = (cur.memory + 1) % 16;
            break;

          case '-':
            cur.memory = (cur.memory - 1 + 16) % 16;
            break;

          default:
            int num = value - '0';
            cur.memory = num;
            break;
        }

        // 이동 추가
        int nextX = cur.x + directions[cur.dIdx][0];
        int nextY = cur.y + directions[cur.dIdx][1];

        stack.add(new Move(nextX, nextY, cur.memory, cur.dIdx));
      }

      bw.write("#" + t + " " + (isPossible ? "YES" : "NO") + "\n");
    }

    bw.flush();
  }
}
