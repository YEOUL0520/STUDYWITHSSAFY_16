/*
1249. [S/W 문제해결 응용] 4일차 - 보급로 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD&categoryId=AV15QRX6APsCFAYD&categoryType=CODE&problemTitle=1249&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

  public static class Node implements Comparable<Node> {
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
      this.x = x;
      this.y = y;
      this.cost = cost;
    }

    // 비용 기준 오름차순 정렬
    @Override
    public int compareTo(Node other) {
      return Integer.compare(this.cost, other.cost);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      int[][] map = new int[N][N];
      int[][] cost = new int[N][N];

      for (int i = 0; i < N; i++) {
        String line = br.readLine();
        for (int j = 0; j < N; j++) {
          map[i][j] = line.charAt(j) - '0';
          cost[i][j] = Integer.MAX_VALUE;
        }
      }

      PriorityQueue<Node> pq = new PriorityQueue<>(); // 비용이 작은 걸 우선
      pq.add(new Node(0, 0, 0));
      cost[0][0] = 0; // 시작점은 비용 0

      while (!pq.isEmpty()) {
        Node cur = pq.poll();

        // 이미 구했던 비용보다 더 비싸면 버림
        if (cur.cost > cost[cur.x][cur.y]) {
          continue;
        }

        for (int[] d : directions) {
          int nextX = cur.x + d[0];
          int nextY = cur.y + d[1];

          if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
            continue;
          }

          int nextCost = cur.cost + map[nextX][nextY];

          // 더 적은 비용이면 들어감
          if (nextCost < cost[nextX][nextY]) {
            cost[nextX][nextY] = nextCost;
            pq.add(new Node(nextX, nextY, cur.cost + map[nextX][nextY]));           
          }
        }
      }

      bw.write("#" + t + " " + cost[N-1][N-1] + "\n");
    }

    bw.flush();
  }
}
