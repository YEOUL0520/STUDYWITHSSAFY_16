/*
2806. N-Queen (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GKs06AU0DFAXB&categoryId=AV7GKs06AU0DFAXB&categoryType=CODE&problemTitle=2806&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.util.*;
import java.io.*;

class Solution {
  public static int[] queens;
  public static boolean[] isVisit;
  public static int answer;
  public static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int T = Integer.parseInt(br.readLine());
    
    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      
      queens = new int[N]; // queens[행]=열, N번째 행의 어느 열에 들어가있는지 저장
      isVisit = new boolean[N];
      answer = 0;

      putQueen(0);
      
      bw.write("#" + t + " " + answer + "\n");
    }
    
    bw.flush();
  }

  public static void putQueen(int row) {
    if (row == N) {
      answer++;
      return;
    }

    for (int col = 0; col < N; col++) {
      // n번째 열에 배치한 퀸이 없고 대각선에도 없으면 배치
      if (!isVisit[col] && checkDiagonal(row, col)) {
        isVisit[col] = true;
        queens[row] = col;
        putQueen(row + 1);
        queens[row] = -1;
        isVisit[col] = false;
      }
    }
  }

  /* 대각선 검사 : (r1,c1), (r2,c2)일 때, r1 - r2 == c1 - c2면 대각선에 위치함 */
  public static boolean checkDiagonal(int row, int col) {
    // 기존에 배치된 퀸들과 배치하려는 (row, col)을 비교
    for (int queenRow = 0; queenRow < row; queenRow++) { 
      if (Math.abs(queenRow - row) == Math.abs(queens[queenRow] - col)) {
        return false;
      }
    }

    return true;
  }
}
