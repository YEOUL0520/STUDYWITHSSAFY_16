/*
6730. 장애물 경주 난이도 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWefy5x65PoDFAUh&categoryId=AWefy5x65PoDFAUh&categoryType=CODE&problemTitle=6730&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      int[] arr = new int[N];

      st = new StringTokenizer(br.readLine());
      for (int n = 0; n < N; n++) {
        arr[n] = Integer.parseInt(st.nextToken());
      }

      int up = 0;
      int down = 0;

      for (int n = 0; n < N - 1; n++) {
        int diff = arr[n] - arr[n + 1];

        if (diff > 0) { // 내가 높은 경우
          down = Math.max(down, diff);
        } else {  // 내가 낮은 경우
          up = Math.max(up, -(diff));
        }
      }

      bw.write("#" + t + " " + up + " " + down + "\n");
    }

    bw.flush();
  }
}
