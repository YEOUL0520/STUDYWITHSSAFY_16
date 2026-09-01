/*
1210. [S/W 문제해결 기본] 2일차 - Ladder1 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh&categoryId=AV14ABYKADACFAYh&categoryType=CODE&problemTitle=1210&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    for (int t = 1; t <= 10; t++) {
      int testcase = Integer.parseInt(br.readLine());
      int[][] map = new int[100][100];
      int[] start = new int[2]; // 도착 위치

      for (int i = 0; i < 100; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 100; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());

          if (map[i][j] == 2) {
            start = new int[] { i, j };
          }
        }
      }

      int x = start[1];
      int y = start[0];

      while (y != 0) {
        int check = checkLadder(map, x, y);

        if (check == 1) { // 가로 막대 끝날 때까지 왼쪽으로 이동
          while (x > 0 && map[y][x - 1] == 1) {
            x--;
          }
        }
        else if (check == 2) {  // 가로 막대 끝날 때까지 오른쪽으로 이동
          while (x < 99 && map[y][x + 1] == 1) {
            x++;
          }
        }

        y--;  // 위로 이동
      }

      bw.write("#" + testcase + " " + x + "\n");
    }

    bw.flush();
  }

  // 좌우 사다리 있는지 확인 (0: 없음, 1: 왼쪽, 2: 오른쪽)
  public static int checkLadder(int[][] map, int x, int y) {
    int rightX = x + 1;
    int leftX = x - 1;

    if (leftX >= 0) {
      if (map[y][leftX] == 1) {
        return 1;
      }
    }

    if (rightX < 100) {
      if (map[y][rightX] == 1) {
        return 2;
      }
    }

    return 0;
  }
}
