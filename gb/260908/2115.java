/*
2115. [모의 SW 역량테스트] 벌꿀채취
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu&categoryId=AV5V4A46AdIDFAWu&categoryType=CODE&problemTitle=2115&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int N;
  public static int M;
  public static int C;
  public static int[][] map;
  public static int maxProfit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken()); // 벌통 크기
      M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통 개수
      C = Integer.parseInt(st.nextToken()); // 최대 꿀 채취량
      
      map = new int[N][N];
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      maxProfit = 0;

      // 첫 번째 일꾼 위치 정하기
      for (int oneR = 0; oneR < N; oneR++) {
        for (int oneC = 0; oneC <= N - M; oneC++) {
          int oneProfit = getHoney(oneR, oneC, 0, 0, 0);
          selectTwo(oneR, oneC, oneProfit);
        }
      }

      bw.write("#" + t + " " + maxProfit + "\n");
    }

    bw.flush();
  }

  /* 두 번째 일꾼 위치 정하기 */
  public static void selectTwo(int oneR, int oneC, int oneProfit) {
    for (int twoR = oneR; twoR < N; twoR++) {
      // 첫 번째 일꾼이 같은 행에 있으면 M만큼 건너뛰고 탐색
      if (twoR == oneR) {
        for (int twoC = oneC + M; twoC <= N - M; twoC++) {
          int twoProfit = getHoney(twoR, twoC, 0, 0, 0);
          maxProfit = Math.max(maxProfit, oneProfit + twoProfit);
        }
      } else {
        for (int twoC = 0; twoC <= N - M; twoC++) {
          int twoProfit = getHoney(twoR, twoC, 0, 0, 0);
          maxProfit = Math.max(maxProfit, oneProfit + twoProfit);
        }
      }
    }
  }

  /* 꿀 채취 */
  public static int getHoney(int r, int c, int idx, int honey, int profit) {
    // 최대 꿀 채취량 초과하면 종료
    if (honey > C) {
      return 0;
    }

    // 끝까지 체크했으면 수익 계산
    if (idx >= M) {
      return profit;
    }

    // 현재 위치 채취 안 함
    int no = getHoney(r, c, idx + 1, honey, profit);

    // 현재 위치 채취함
    int curHoney = map[r][c + idx];
    int yes = getHoney(r, c, idx + 1, honey + curHoney, profit + curHoney * curHoney);

    return Math.max(no, yes);
  }
}
