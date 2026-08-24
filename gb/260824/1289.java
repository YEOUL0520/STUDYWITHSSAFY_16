/*
1289. 원재의 메모리 복구하기 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN&categoryId=AV19AcoKI9sCFAZN&categoryType=CODE&problemTitle=1289&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      String input = br.readLine();
      boolean isChange = false; // true: 1, false: 0
      int cnt = 0;

      for (int i = 0; i < input.length(); i++) {
        int answer = input.charAt(i) - '0';
        int curBit = isChange ? 1 : 0;

        if (answer == curBit) {
          continue;
        }

        isChange = !isChange;
        cnt++;
      }

      bw.write("#" + t + " " + cnt + "\n");
    }

    bw.flush();
  }
}