/*
2117. [모의 SW 역량테스트] 홈 방범 서비스
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu&categoryId=AV5V61LqAf8DFAWu&categoryType=CODE&problemTitle=2117&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] map;
  public static int N;
  public static int M;
  public static int maxHouse;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      map = new int[N][N];
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      maxHouse = 0;

      // 모든 곳을 중심점으로 잡아보기
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          find(i, j, 1);
        }
      }

      bw.write("#" + t + " " + maxHouse + "\n");
    }

    bw.flush();
  }

  public static void find(int centerR, int centerC, int K) {
    // 최대 K를 넘으면 종료 (최대 K: 모든 칸을 포함하는 크기의 K, N이 홀수만 나오면 N 초과로 판단 가능하지만 짝수인 경우도 있으므로 N + 1 초과로 판단)
    if (K > N + 1) {
      return;
    }

    // 서비스 제공받는 집 수 구하기
    int house = 0;

    for (int i = centerR - K; i <= centerR + K; i++) {
      for (int j = centerC - K; j <= centerC + K; j++) {
        // 범위 체크
        if (i < 0 || j < 0 || i >= N || j >= N) {
          continue;
        }

        // 서비스 영역(마름모)에 포함되고 집이면 house 증가
        if (Math.abs(i - centerR) + Math.abs(j - centerC) < K && map[i][j] == 1) {
          house++;
        }
      }
    }

    // 이익 계산
    int cost = K * K + (K - 1) * (K - 1);
    int profit = M * house - cost;

    // 손해 안 보면 최대 집 수 갱신
    if (profit >= 0) {
      maxHouse = Math.max(maxHouse, house);
    }

    // 중심점 유지하고 범위 넓히기
    find(centerR, centerC, K + 1);
  }
}
