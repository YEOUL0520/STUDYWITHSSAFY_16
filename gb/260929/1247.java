/*
1247. [S/W 문제해결 응용] 3일차 - 최적 경로 (D5)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD&categoryId=AV15OZ4qAPICFAYD&categoryType=CODE&problemTitle=1247&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static boolean[] visited;
  public static int N;
  public static int[][] customer;
  public static int[] home;
  public static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());

      st = new StringTokenizer(br.readLine());
      int[] company = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
      home = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
      customer = new int[N][2];

      for (int n = 0; n < N; n++) {
        customer[n][0] = Integer.parseInt(st.nextToken());
        customer[n][1] = Integer.parseInt(st.nextToken());
      }

      visited = new boolean[N];
      answer = Integer.MAX_VALUE;

      permutation(company, 0, 0);

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }

  public static void permutation(int[] prev, int length, int cnt) {
    if (cnt == N) {
      int distance = Math.abs(prev[0] - home[0]) + Math.abs(prev[1] - home[1]);
      answer = Math.min(answer, length + distance);
      return;
    }

    if (answer <= length) {
      return;
    }

    for (int i = 0; i < N; i++) {
      if (visited[i]) {
        continue;
      }

      int distance = Math.abs(customer[i][0] - prev[0]) + Math.abs(customer[i][1] - prev[1]);

      visited[i] = true;
      permutation(customer[i], length + distance, cnt + 1);
      visited[i] = false;
    }
  }
}
