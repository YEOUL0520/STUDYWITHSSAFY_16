/*
1251. [S/W 문제해결 응용] 4일차 - 하나로 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD&categoryId=AV15StKqAQkCFAYD&categoryType=CODE&problemTitle=1251&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int N;
  public static int[] x;
  public static int[] y;
  public static boolean[] visited;
  public static double L2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      x = new int[N];
      y = new int[N];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        x[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        y[i] = Integer.parseInt(st.nextToken());
      }

      double E = Double.parseDouble(br.readLine()); // 환경 부담 세율

      visited = new boolean[N];
      L2 = Double.MAX_VALUE; // 각 해저터널 길이의 합 (이걸 최소로 하되 모든 섬 연결하기)

      // 0부터 시작
      visited[0] = true;
      connect(1, 0);

      double result = E * L2;

      bw.write("#" + t + " " + String.format("%.0f", result) + "\n");
    }

    bw.flush();
  }

  /* Prim 알고리즘 사용 */
  public static void connect(int cnt, double length) {
    if (cnt == N) {
      L2 = Math.min(L2, length);
      return;
    }

    int select = 0;
    double min = Double.MAX_VALUE;

    // 현재 연결된 노드들에서 가장 가중치가 작은 섬 선택
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        continue;
      }

      for (int j = 0; j < N; j++) {
        if (visited[j]) {
          continue;
        }

        double distance = Math.pow(x[j] - x[i], 2) + Math.pow(y[j] - y[i], 2);

        if (min > distance) {
          min = distance;
          select = j;
        }
      }
    }

    visited[select] = true;
    connect(cnt + 1, length + min);
  }
}
