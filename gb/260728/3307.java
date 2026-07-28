/*
3307. 최장 증가 부분 수열 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWBOKg-a6l0DFAWr&categoryId=AWBOKg-a6l0DFAWr&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=4
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
      int[] arr = new int[N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int n = 0; n < N; n++) {
        arr[n] = Integer.parseInt(st.nextToken());
      }

      int[] lengthArr = new int[N];

      for (int i = 1; i < N; i++) {
        for (int j = 0; j < i; j++) {
          if (arr[i] >= arr[j]) {
            lengthArr[i] = Math.max(lengthArr[i], lengthArr[j] + 1);
          }
        }
      }

      int answer = 0;

      for (int n = 0; n < N; n++) {
        answer = Math.max(answer, lengthArr[n]);
      }

      answer++;

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }
}