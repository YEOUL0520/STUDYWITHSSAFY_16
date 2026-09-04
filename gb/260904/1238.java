/*
1238. [S/W 문제해결 기본] 10일차 - Contact (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE&problemTitle=1238&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static class Move {
    int num;
    int cnt;

    public Move(int num, int cnt) {
      this.num = num;
      this.cnt = cnt;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    for (int t = 1; t <= 10; t++) {
      st = new StringTokenizer(br.readLine());
      int length = Integer.parseInt(st.nextToken());
      int start = Integer.parseInt(st.nextToken());

      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();  // 그래프
      int[] visited = new int[101]; // 방문 체크 배열: 방문 안했으면 Integer.MIN_VALUE, 방문 했으면 현재 위치까지 오는데 걸린 시간 저장

      // 1~100까지의 번호를 쓰기 때문에 해당 개수만큼 ArrayList를 넣어줌
      for (int i = 0; i <= 100; i++) {
        graph.add(new ArrayList<>());
        visited[i] = Integer.MIN_VALUE;
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < length / 2; i++) {  // 입력을 from, to 두 개씩 읽으니까 절반만큼 반복
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        graph.get(from).add(to);  // from에서 to로 갈 수 있음
      }

      // BFS 시작
      ArrayDeque<Move> queue = new ArrayDeque<>();
      queue.offer(new Move(start, 0));  // 시작점 넣기
      visited[start] = 0; // 시작점도 방문 체크

      while (!queue.isEmpty()) {  // 큐가 빌 때까지 반복하며 이동
        Move cur = queue.poll();  // 큐에서 하나 꺼냄

        for (int next : graph.get(cur.num)) { // 현재 번호에서 갈 수 있는 곳들 검사
          // 이미 방문 했으면 패스
          if (visited[next] != Integer.MIN_VALUE) {
            continue;
          }

          // 방문 안했으면 방문 체크하고 큐에 넣기
          visited[next] = cur.cnt + 1;
          queue.offer(new Move(next, cur.cnt + 1));
        }
      }

      // 최대 이동 시간을 가지는 번호 찾기
      int maxIdx = 0;

      for (int i = 0; i <= 100; i++) {
        if (visited[maxIdx] <= visited[i]) {
          maxIdx = i;
        }
      }

      bw.write("#" + t + " " + maxIdx + "\n");
    }

    bw.flush();
  }
}
