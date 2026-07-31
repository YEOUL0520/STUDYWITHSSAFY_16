/*
6109. 추억의 2048게임 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWbrg9uabZsDFAWQ&categoryId=AWbrg9uabZsDFAWQ&categoryType=CODE&problemTitle=6109&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int N;
  public static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      String direction = st.nextToken();

      map = new int[N][N];
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      switch (direction) {
        case "left": mergeLeft(); break;
        case "right": mergeRight(); break;
        case "up": mergeUp(); break;
        case "down": mergeDown(); break;
      }

      bw.write("#" + t + "\n");
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          bw.write(map[i][j] + " ");
        }
        bw.write("\n");
      }

      bw.flush();
    }
  }

  public static void mergeLeft() {
    pushLeft(); // 0 제거

    // 합치기
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N - 1; j++) {
        if (map[i][j] == map[i][j + 1]) {
          map[i][j] *= 2;
          map[i][j + 1] = 0;
        }
      }
    }  

    pushLeft(); // 0 제거
  }

  public static void mergeRight() {
    pushRight(); // 0 제거

    // 합치기
    for (int i = 0; i < N; i++) {
      for (int j = N - 1; j > 0; j--) {
        if (map[i][j] == map[i][j - 1]) {
          map[i][j] *= 2;
          map[i][j - 1] = 0;
        }
      }
    }  

    pushRight(); // 0 제거
  }

  public static void mergeUp() {
    pushUp(); // 0 제거

    // 합치기
    for (int i = 0; i < N - 1; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == map[i + 1][j]) {
          map[i][j] *= 2;
          map[i + 1][j] = 0;
        }
      }
    }  

    pushUp(); // 0 제거
  }

  public static void mergeDown() {
    pushDown(); // 0 제거

    // 합치기
    for (int i = N - 1; i > 0; i--) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == map[i - 1][j]) {
          map[i][j] *= 2;
          map[i - 1][j] = 0;
        }
      }
    }  

    pushDown(); // 0 제거
  }

  public static void pushLeft() {
    int zeroIdx;

    for (int i = 0; i < N; i++) {
      zeroIdx = Integer.MIN_VALUE;
      int j = 0;

      while (j < N) {
        // 땡겨야하는 위치 찾기
        if (map[i][j] == 0 && zeroIdx == Integer.MIN_VALUE) {
          zeroIdx = j;
        }
        
        // 숫자면 땡기기
        if (map[i][j] != 0 && zeroIdx != Integer.MIN_VALUE) {
          map[i][zeroIdx] = map[i][j];
          map[i][j] = 0;
          zeroIdx++;
        }

        j++;
      }
    }
  }

  public static void pushRight() {
    int zeroIdx;

    for (int i = 0; i < N; i++) {
      zeroIdx = Integer.MIN_VALUE;
      int j = N - 1;

      while (j >= 0) {
        // 땡겨야하는 위치 찾기
        if (map[i][j] == 0 && zeroIdx == Integer.MIN_VALUE) {
          zeroIdx = j;
        }
        
        // 숫자면 땡기기
        if (map[i][j] != 0 && zeroIdx != Integer.MIN_VALUE) {
          map[i][zeroIdx] = map[i][j];
          map[i][j] = 0;
          zeroIdx--;
        }

        j--;
      }
    }
  }

  public static void pushUp() {
    int zeroIdx;

    for (int j = 0; j < N; j++) {
      zeroIdx = Integer.MIN_VALUE;
      int i = 0;

      while (i < N) {
        // 땡겨야하는 위치 찾기
        if (map[i][j] == 0 && zeroIdx == Integer.MIN_VALUE) {
          zeroIdx = i;
        }
        
        // 숫자면 땡기기
        if (map[i][j] != 0 && zeroIdx != Integer.MIN_VALUE) {
          map[zeroIdx][j] = map[i][j];
          map[i][j] = 0;
          zeroIdx++;
        }

        i++;
      }
    }
  }

  public static void pushDown() {
    int zeroIdx;

    for (int j = 0; j < N; j++) {
      zeroIdx = Integer.MIN_VALUE;
      int i = N - 1;

      while (i >= 0) {
        // 땡겨야하는 위치 찾기
        if (map[i][j] == 0 && zeroIdx == Integer.MIN_VALUE) {
          zeroIdx = i;
        }
        
        // 숫자면 땡기기
        if (map[i][j] != 0 && zeroIdx != Integer.MIN_VALUE) {
          map[zeroIdx][j] = map[i][j];
          map[i][j] = 0;
          zeroIdx--;
        }

        i--;
      }
    }
  }
}