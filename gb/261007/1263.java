/*
1263. [S/W 문제해결 응용] 8일차 - 사람 네트워크2 (D6)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18P2B6Iu8CFAZN&categoryId=AV18P2B6Iu8CFAZN&categoryType=CODE&problemTitle=1263&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());

      int[][] graph = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          graph[i][j] = Integer.parseInt(st.nextToken());

          // 연결되지 않은 부분의 길이는 1000000으로 설정 (int 최대값으로 설정하면 아래에서 더했을 때 오버플로우 날 수 있음)
          if (i != j && graph[i][j] == 0) {
            graph[i][j] = 1000000;
          }
        }
      }

      // 플로이드 워셜 알고리즘 사용
      // 현재 i->j 거리와 i->k->j 거리를 비교해 최소값을 저장
      for (int k = 0; k < N; k++) {
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
          }
        }
      }

      int min = Integer.MAX_VALUE;

      for (int i = 0; i < N; i++) {
        int sum = 0;

        for (int j = 0; j < N; j++) {
          sum += graph[i][j];
        }

        min = Math.min(min, sum);
      }

      bw.write("#" + t + " " + min + "\n");
    }

    bw.flush();
  }
}
