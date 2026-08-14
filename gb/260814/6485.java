/*
6485. 삼성시의 버스 노선 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWczm7QaACgDFAWn&categoryId=AWczm7QaACgDFAWn&categoryType=CODE&problemTitle=6485&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      int[] busCnt = new int[5001]; // 버스 정류장 번호 1~5000

      for (int n = 0; n < N; n++) {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        for (int i = A; i <= B; i++) {
          busCnt[i]++;
        }
      }

      int P = Integer.parseInt(br.readLine());

      bw.write("#" + t);

      for (int p = 0; p < P; p++) {
        int busStopNum = Integer.parseInt(br.readLine());
        bw.write(" " + busCnt[busStopNum]);
      }

      bw.write("\n");
    }

    bw.flush();
  }
}
