/*
1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기 (D2)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh&categoryId=AV13zo1KAAACFAYh&categoryType=CODE&problemTitle=1204&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int testcase = Integer.parseInt(br.readLine());

      int[] cnt = new int[101]; // 0~100점 중 나온 횟수 저장

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 1000; i++) {
        int score = Integer.parseInt(st.nextToken());
        cnt[score]++;
      }

      int maxIdx = 0;

      for (int i = 0; i <= 100; i++) {
        if (cnt[maxIdx] <= cnt[i]) {
          maxIdx = i;
        }
      }

      bw.write("#" + testcase + " " + maxIdx + "\n");
    }

    bw.flush();
  }
}
