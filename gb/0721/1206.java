/*
1206. [S/W 문제해결 기본] 1일차 - View (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh&categoryId=AV134DPqAA8CFAYh&categoryType=CODE&problemTitle=1206&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int t = 1; t <= 10; t++) {
      int N = Integer.parseInt(br.readLine());
      int[] buildings = new int[N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int n = 0; n < N; n++) {
        buildings[n] = Integer.parseInt(st.nextToken());
      }

      int answer = 0;

      for (int i = 2; i < N - 2; i++) {
        int left = 0;
        int right = 0;

        // 왼쪽 확인
        if (buildings[i] > buildings[i - 1] && buildings[i] > buildings[i - 2]) {
          left = buildings[i] - Math.max(buildings[i - 1], buildings[i - 2]);
        }

        // 오른쪽 확인
        if (buildings[i] > buildings[i + 1] && buildings[i] > buildings[i + 2]) {
          right = buildings[i] - Math.max(buildings[i + 1], buildings[i + 2]);
        }

        answer += Math.min(left, right);
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }
}
