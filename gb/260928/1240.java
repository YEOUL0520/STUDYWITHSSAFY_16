/*
1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15FZuqAL4CFAYD&categoryId=AV15FZuqAL4CFAYD&categoryType=CODE&problemTitle=1240&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] numbers = {
    { 2, 1, 1 },  // 0
    { 2, 2, 1 },  // 1
    { 1, 2, 2 },  // 2
    { 4, 1, 1 },  // 3
    { 1, 3, 2 },  // 4
    { 2, 3, 1 },  // 5
    { 1, 1, 4 },  // 6
    { 3, 1, 2 },  // 7
    { 2, 1, 3 },  // 8
    { 1, 1, 2 }   // 9
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    
    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int oddSum = 0;
      int evenSum = 0;
      int digit = 8;
      boolean find = false;
      
      for (int i = 0; i < N; i++) {
        String line = br.readLine();

        if (find) {
          continue;
        }

        for (int j = M - 1; j >= 0; j--) {
          char num = line.charAt(j);

          if (num == '0') {
            continue;
          }

          int cnt1 = 0;
          while (true) {
            if (line.charAt(j) != '1') {
              break;
            }

            cnt1++;
            j--;
          }

          int cnt2 = 0;
          while (true) {
            if (line.charAt(j) != '0') {
              break;
            }

            cnt2++;
            j--;
          }

          int cnt3 = 0;
          while (true) {
            if (line.charAt(j) != '1') {
              break;
            }

            cnt3++;
            j--;
          }

          for (int k = 0; k < 10; k++) {
            if (numbers[k][0] == cnt3 && numbers[k][1] == cnt2 && numbers[k][2] == cnt1) {
              if (digit % 2 == 0) {
                evenSum += k;
              } else {
                oddSum += k;
              }
              digit--;
              break;
            }
          }
        }

        if (digit == 0) {
          find = true;
        }
      }

      int result = oddSum * 3 + evenSum;
      int answer = 0;

      if (result % 10 == 0) {
        answer = oddSum + evenSum;
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }
}
