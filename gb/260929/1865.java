/*
1865. 동철이의 일 분배 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LuHfqDz8DFAXc&categoryId=AV5LuHfqDz8DFAXc&categoryType=CODE&problemTitle=1865&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static boolean[] completed;
  public static double answer;
  public static int N;
  public static int[][] grid;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    
    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      grid = new int[N][N];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          grid[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      completed = new boolean[N];
      answer = 0.0;

      permutation(0, 1.0);

      bw.write("#" + t + " " + String.format("%.6f", answer * 100) + "\n");
    }

    bw.flush();
  }

  public static void permutation(int idx, double sum) {
    if (idx == N) {
      answer = Math.max(answer, sum);
      return;
    }

    if (sum <= answer) {
      return;
    }

    for (int i = 0; i < N; i++) {
      if (completed[i]) {
        continue;
      }

      if (grid[idx][i] == 0) {
        continue;
      }

      completed[i] = true;
      permutation(idx + 1, sum * grid[idx][i] / 100.0);
      completed[i] = false;
    }
  }
}
