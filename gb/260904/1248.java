/*
1248. [S/W 문제해결 응용] 3일차 - 공통조상 (D5)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15PTkqAPYCFAYD&categoryId=AV15PTkqAPYCFAYD&categoryType=CODE&problemTitle=1248&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());
      
      int[] parents = new int[V + 1];
      ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

      for (int v = 0; v <= V; v++) {
        tree.add(new ArrayList<>());
      }

      st = new StringTokenizer(br.readLine());
      for (int e = 0; e < E; e++) {
        int parent = Integer.parseInt(st.nextToken());
        int child = Integer.parseInt(st.nextToken());
        parents[child] = parent;
        tree.get(parent).add(child);
      }

      // 노드 1의 부모들을 리스트에 추가
      ArrayList<Integer> parents1 = new ArrayList<>();
      int cur = parents[node1];

      while (true) {
        if (cur == 0) {
          break;
        }

        parents1.add(cur);
        cur = parents[cur];
      }

      // 노드 2의 부모들을 리스트에 추가
      ArrayList<Integer> parents2 = new ArrayList<>();
      cur = parents[node2];

      while (true) {
        if (cur == 0) {
          break;
        }

        parents2.add(cur);
        cur = parents[cur];
      }

      // 공통 조상 찾기
      int common = 0;

      for (int p1 : parents1) {
        for (int p2 : parents2) {
          if (p1 == p2) {
            common = p1;
            break;
          }
        }
        
        if (common != 0) {
          break;
        }
      }

      // 서브 트리 크기 찾기
      int size = 0;
      ArrayDeque<Integer> queue = new ArrayDeque<>();
      queue.offer(common);

      while (!queue.isEmpty()) {
        int node = queue.poll();
        size++;

        for (int child : tree.get(node)) {
          queue.offer(child);
        }
      }

      bw.write("#" + t + " " + common + " " + size + "\n");
    }

    bw.flush();
  }
}
