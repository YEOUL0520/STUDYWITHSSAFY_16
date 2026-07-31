/*
1238. [S/W 문제해결 기본] 10일차 - Contact (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE&problemTitle=1238&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      int dataLength = Integer.parseInt(st.nextToken());
      int start = Integer.parseInt(st.nextToken());

      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for (int i = 0; i <= 100; i++) {
        graph.add(new ArrayList<>());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < dataLength / 2; i++) {
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        graph.get(from).add(to);
      }

      int[] orderList = new int[101]; // 연락 받은 순서 저장
      boolean[] isVisit = new boolean[101];
      Queue<Integer> queue = new LinkedList<>();
      int max = 0;
      
      queue.add(start);
      isVisit[start] = true;

      while (!queue.isEmpty()) {
        int cur = queue.poll();

        for (int next : graph.get(cur)) {
          if (isVisit[next]) {
            continue;
          }

          queue.add(next);
          isVisit[next] = true;
          orderList[next] = orderList[cur] + 1;
          max = Math.max(max, orderList[next]);
        }
      }

      for (int i = 100; i > 0; i--) {
        if (max == orderList[i]) {
          bw.write("#" + t + " " + i + "\n");
          break;
        }
      }
    }

    bw.flush();
  }
}
