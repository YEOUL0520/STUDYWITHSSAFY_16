/*
3499. 퍼펙트 셔플 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW&categoryId=AWGsRbk6AQIDFAVW&categoryType=CODE&problemTitle=3499&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      String[] card = new String[N];

      st = new StringTokenizer(br.readLine());
      for (int n = 0; n < N; n++) {
        card[n] = st.nextToken();
      }

      int leftIdx = 0;
      int rightIdx = (N % 2 == 0) ? N / 2 : (N + 1) / 2;

      bw.write("#" + t);

      while (rightIdx < N) {
        bw.write(" " + card[leftIdx++]);
        bw.write(" " + card[rightIdx++]);
      }

      if (N % 2 != 0) {
        bw.write(" " + card[leftIdx++]);
      }

      bw.write("\n");
    }

    bw.flush();
  }
}
