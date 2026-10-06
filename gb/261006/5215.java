/*
5215. 햄버거 다이어트 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT&categoryId=AWT-lPB6dHUDFAVT&categoryType=CODE&problemTitle=5215&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int N;
  public static int L;
  public static int answer;
  public static int[] scores;
  public static int[] calories;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken()); // 재료의 수
      L = Integer.parseInt(st.nextToken()); // 제한 칼로리

      scores = new int[N];
      calories = new int[N];

      for (int n = 0; n < N; n++) {
        st = new StringTokenizer(br.readLine());
        scores[n] = Integer.parseInt(st.nextToken());
        calories[n] = Integer.parseInt(st.nextToken());
      }

      answer = Integer.MIN_VALUE;      
      combination(0, 0, 0);

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }

  public static void combination(int idx, int score, int calory) {
    if (calory > L) {
      return;
    }

    if (idx == N) {
      answer = Math.max(answer, score);
      return;
    }

    combination(idx + 1, score + scores[idx], calory + calories[idx]);
    combination(idx + 1, score, calory);
  }
}
