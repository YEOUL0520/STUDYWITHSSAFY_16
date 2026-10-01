/*
7465. 창용 마을 무리의 개수 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU&categoryId=AWngfZVa9XwDFAQU&categoryType=CODE&problemTitle=7465&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      int N = Integer.parseInt(st.nextToken()); // 창용 마을에 사는 사람 수
      int M = Integer.parseInt(st.nextToken()); // 사람 관계 수

      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for (int n = 0; n <= N; n++) {
        graph.add(new ArrayList<>());
      }

      for (int m = 0; m < M; m++) {
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        graph.get(n1).add(n2);
        graph.get(n2).add(n1);
      }

      int cnt = 0;
      boolean[] visited = new boolean[N + 1];

      ArrayDeque<Integer> queue = new ArrayDeque<>();
      
      for (int i = 1; i <= N; i++) {
        if (visited[i]) {
          continue;
        }

        cnt++;
        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
          int cur = queue.poll();

          for (int next : graph.get(cur)) {
            if (visited[next]) {
              continue;
            }

            queue.add(next);
            visited[next] = true;
          }
        }
      }

      bw.write("#" + t + " " + cnt + "\n");
    }

    bw.flush();
  }
}
