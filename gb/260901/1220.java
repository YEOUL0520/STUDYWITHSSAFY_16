/*
1220. [S/W 문제해결 기본] 5일차 - Magnetic (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14hwZqABsCFAYD&categoryId=AV14hwZqABsCFAYD&categoryType=CODE&problemTitle=1220&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    for (int t = 1; t <= 10; t++) {
      int N = Integer.parseInt(br.readLine());
      int[][] arr = new int[N][N];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int answer = 0;

      for (int i = 0; i < N; i++) {
        boolean meetN = false;

        for (int j = 0; j < N; j++) {
          if (arr[j][i] == 1) {
            meetN = true;
          }
          if (meetN && arr[j][i] == 2) {
            answer++;
            meetN = false;
          }
        }

        // int nIdx = 0;
        // for (int j = 0; j < N; j++) {
        //   if (arr[j][i] == 1) {
        //     nIdx = j;
        //     break;
        //   }
        // }

        // int sIdx = 0;
        // for (int j = N - 1; j >= 0; j--) {
        //   if (arr[j][i] == 2) {
        //     sIdx = j;
        //     break;
        //   }
        // }

        // int prev = 1;
        // for (int j = nIdx; j <= sIdx; j++) {
        //   if (prev == 0 && arr[j][i] == 1) {
        //     prev = arr[j][i];
        //   }
        //   else if (prev == 1 && arr[j][i] == 2) {
        //     answer++;
        //     prev = 0;
        //   }
        // }
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }
}
