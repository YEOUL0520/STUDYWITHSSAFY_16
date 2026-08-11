/*
1213. [S/W 문제해결 기본] 3일차 - String (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14P0c6AAUCFAYi&categoryId=AV14P0c6AAUCFAYi&categoryType=CODE&problemTitle=1213&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int t = 1; t <= 10; t++) {
      int testcase = Integer.parseInt(br.readLine());
      String target = br.readLine();
      String line = br.readLine();
      int answer = 0;

      for (int start = 0; start <= line.length() - target.length(); start++) {
        if (line.charAt(start) != target.charAt(0)) {
          continue;
        }

        boolean isSame = true;

        for (int i = 1; i < target.length(); i++) {
          if (line.charAt(i + start) != target.charAt(i)) {
            isSame = false;
            break;
          }
        }

        if (isSame) {
          answer++;
        }
      }

      bw.write("#" + testcase + " " + answer + "\n");
    }

    bw.flush();
  }
}
