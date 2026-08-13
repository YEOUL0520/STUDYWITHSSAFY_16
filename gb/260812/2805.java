/*
2805. 농작물 수확하기 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB&categoryId=AV7GLXqKAWYDFAXB&categoryType=CODE&problemTitle=2805&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      int[][] map = new int[N][N];

      for (int i = 0; i < N; i++) {
        String line = br.readLine();
        for (int j = 0; j < N; j++) {
          map[i][j] = line.charAt(j) - '0';
        }
      }

      int answer = 0;
      int row = 0;

      for (int d = N / 2; d >= 0; d--) {
        for (int j = d; j < N - d; j++) {
          answer += map[row][j];
          
          if (d != 0) {
            answer += map[N - row - 1][j];
          }
        }
        row++;
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }
}
