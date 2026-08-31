/*
1208. [S/W 문제해결 기본] 1일차 - Flatten (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh&categoryId=AV139KOaABgCFAYh&categoryType=CODE&problemTitle=1208&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    for (int t = 1; t <= 10; t++) {
      int cnt = Integer.parseInt(br.readLine());
      int[] arr = new int[100];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 100; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      while (cnt-- > 0) {
        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 0; i < 100; i++) {
          if (arr[minIdx] > arr[i]) {
            minIdx = i;
          }
          if (arr[maxIdx] < arr[i]) {
            maxIdx = i;
          }
        }

        arr[minIdx]++;
        arr[maxIdx]--;
      }

      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;

      for (int num : arr) {
        max = Math.max(max, num);
        min = Math.min(min, num);
      }

      bw.write("#" + t + " " + (max - min) + "\n");
    }

    bw.flush();
  }
}
