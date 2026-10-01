/*
1267. [S/W 문제해결 응용] 10일차 - 작업순서 (D6)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18TrIqIwUCFAZN&categoryId=AV18TrIqIwUCFAZN&categoryType=CODE&problemTitle=1267&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());

      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for (int v = 0; v <= V; v++) {
        graph.add(new ArrayList<>());
      }

      int[] cnt = new int[V + 1]; // 인덱스 번호의 작업을 하기 위해 남은 선행 작업 수

      st = new StringTokenizer(br.readLine());
      for (int e = 0; e < E; e++) {
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        graph.get(start).add(end);
        cnt[end]++;
      }

      // 방문 안했고, 선행 작업이 없으면 작업 가능
      // 이걸 모든 작업 끝날 때까지 반복

      int completed = 0;  // 완료한 작업 개수
      ArrayDeque<Integer> queue = new ArrayDeque<>();
      boolean[] visited = new boolean[V + 1];
      int idx = V;  // 1 ~ V 순회

      bw.write("#" + t);

      // 모든 작업 완료할 때까지 반복
      while (completed < V) {
        idx = idx % V + 1;

        // 방문했거나 선행 작업 남았으면 패스
        if (visited[idx] || cnt[idx] != 0) {
          continue;
        }

        visited[idx] = true;
        queue.offer(idx);

        while (!queue.isEmpty()) {
          int cur = queue.poll();
          completed++;
          bw.write(" " + cur);

          for (int next : graph.get(cur)) {
            cnt[next]--;

            if (visited[next] || cnt[next] != 0) {
              continue;
            }

            visited[next] = true;
            queue.offer(next);
          }
        }
      }
      
      bw.write("\n");
    }

    bw.flush();
  }
}
