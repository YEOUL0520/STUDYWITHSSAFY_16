/*
1251. [S/W 문제해결 응용] 4일차 - 하나로 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD&categoryId=AV15StKqAQkCFAYD&categoryType=CODE&problemTitle=1251&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      int N = Integer.parseInt(br.readLine());
      int[] xList = new int[N];
      int[] yList = new int[N];

      st = new StringTokenizer(br.readLine());
      for (int n = 0; n < N; n++) {
        xList[n] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int n = 0; n < N; n++) {
        yList[n] = Integer.parseInt(st.nextToken());
      }

      double E = Double.parseDouble(br.readLine());
      
      double answer = prim(N, xList, yList);
      
      bw.write("#" + t + " " + Math.round(answer * E) + "\n");
    }

    bw.flush();
  }

  public static double prim(int N, int[] xList, int[]yList) {
    boolean[] isVisit = new boolean[N];

    double[] minEdge = new double[N]; // 각 섬으로 연결할 수 있는 최소 거리^2 
    Arrays.fill(minEdge, Double.MAX_VALUE);
    minEdge[0] = 0; // 간선 탐색 시작할 노드 선택

    double result = 0;

    for (int i = 0; i < N; i++) {
      // 간선 중에 거리가 최소인 것 찾기
      int minVertex = -1; // 이번에 MST에서 선택할 섬 번호
      double min = Double.MAX_VALUE;  // 지금까지 검사한 섬들 중 가장 작은 거리

      for (int j = 0; j < N; j++) {
        if (!isVisit[j] && minEdge[j] < min) {
          min = minEdge[j];
          minVertex = j;
        }
      }

      // 선택한 최소 거리 간선을 MST에 연결
      isVisit[minVertex] = true;
      result += min;

      // 선택한 섬에서 다른 섬 확인
      for (int j = 0; j < N; j++) {
        if (isVisit[j]) {
          continue;
        }

        double dx = xList[minVertex] - xList[j];
        double dy = yList[minVertex] - yList[j];
        double distance = dx * dx + dy * dy;

        // 기존 거리보다 작으면 최소 거리 갱신
        if (distance < minEdge[j]) {
          minEdge[j] = distance;
        }
      }
    }

    return result;
  }
}
