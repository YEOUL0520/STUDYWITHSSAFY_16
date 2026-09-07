/*
4012. [모의 SW 역량테스트] 요리사
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH&categoryId=AWIeUtVakTMDFAVH&categoryType=CODE&problemTitle=4012&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static ArrayList<Integer> A;
  public static int[][] synergy;
  public static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      synergy = new int[N][N];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          synergy[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      A = new ArrayList<>();
      answer = Integer.MAX_VALUE;

      combination(N, 0);

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }

  /* 음식 조합 */
  public static void combination(int N, int idx) {
    if (A.size() == N / 2) {
      makeFood(N);
      return;
    }

    if (idx == N) {
      return;
    }

    // idx번 재료를 A에 안 넣는 경우
    combination(N, idx + 1);

    // idx번 재료를 A에 넣는 경우
    A.add(idx);
    combination(N, idx + 1);
    A.remove(Integer.valueOf(idx));
  }

  /* 음식 맛 차이 계산 */
  public static void makeFood(int N) {
    int Asum = 0;
    int Bsum = 0;

    ArrayList<Integer> B = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      if (!A.contains(i)) {
        B.add(i);
      }
    }

    for (int ingredient1 : A) {
      for (int ingredient2 : A) {
        Asum += synergy[ingredient1][ingredient2];
      }
    }

    for (int ingredient1 : B) {
      for (int ingredient2 : B) {
        Bsum += synergy[ingredient1][ingredient2];
      }
    }

    answer = Math.min(answer, Math.abs(Asum - Bsum));
  }
}
