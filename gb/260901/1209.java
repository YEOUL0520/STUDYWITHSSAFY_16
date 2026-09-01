/*
1209. [S/W 문제해결 기본] 2일차 - Sum (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13_BWKACUCFAYh&categoryId=AV13_BWKACUCFAYh&categoryType=CODE&problemTitle=1209&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      int[][] arr = new int[100][100];

      for (int i = 0; i < 100; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 100; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int answer = 0;

      int rightDiagonalSum = 0;
      int leftDiagonalSum = 0;

      for (int i = 0; i < 100; i++) {
        int horizontalSum = 0;
        int verticalSum = 0;

        for (int j = 0; j < 100; j++) {
          horizontalSum += arr[i][j];
          verticalSum += arr[j][i];

          if (i == j) {
            rightDiagonalSum += arr[i][j];
          }

          if (i + j == 100 - 1) {
            leftDiagonalSum += arr[i][j];
          }
        }

        answer = Math.max(answer, Math.max(horizontalSum, verticalSum));
      }

      answer = Math.max(answer, Math.max(rightDiagonalSum, leftDiagonalSum));
      
      bw.write("#" + testcase + " " + answer + "\n");
    }

    bw.flush();
  }
}
