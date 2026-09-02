/*
1219. [S/W 문제해결 기본] 4일차 - 길찾기 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14geLqABQCFAYD&categoryId=AV14geLqABQCFAYD&categoryType=CODE&problemTitle=1219&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    for (int t = 1; t <= 10; t++) {
      st = new StringTokenizer(br.readLine());
      int testcase = Integer.parseInt(st.nextToken());
      int cnt = Integer.parseInt(st.nextToken());

      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for (int i = 0; i < 100; i++) {
        graph.add(new ArrayList<>());
      }

      st = new StringTokenizer(br.readLine());
      while (cnt-- > 0) {
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        graph.get(start).add(end);
      }

      boolean isPossible = false;
      boolean[] visited = new boolean[100];
      ArrayDeque<Integer> queue = new ArrayDeque<>();
      queue.offer(0);
      visited[0] = true;
      
      while(!queue.isEmpty()) {
        int cur = queue.poll();

        for (int next : graph.get(cur)) {
          if (visited[next]) {
            continue;
          }

          if (next == 99) {
            isPossible = true;
            queue.clear();
            break;
          }

          queue.add(next);
          visited[next] = true;
        }
      }

      bw.write("#" + testcase + " " + (isPossible ? "1" : "0") + "\n");
    }

    bw.flush();
  }
}
