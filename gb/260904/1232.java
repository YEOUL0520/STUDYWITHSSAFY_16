/*
1232. [S/W 문제해결 기본] 9일차 - 사칙연산 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141J8KAIcCFAYD&categoryId=AV141J8KAIcCFAYD&categoryType=CODE&problemTitle=1232&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    for (int t = 1; t <= 10; t++) {
      int N = Integer.parseInt(br.readLine());
      String[] input = new String[N + 1];
      int[] result = new int[N + 1];

      for (int n = 0; n < N; n++) {
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        String c = st.nextToken();

        if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
          input[num] = c + " " + st.nextToken() + " " + st.nextToken();
        } else {
          result[num] = Integer.valueOf(c);
        }
      }

      for (int i = N; i > 0; i--) {
        if (input[i] == null) {
          continue;
        }

        st = new StringTokenizer(input[i]);
        char ope = st.nextToken().charAt(0);
        int num1 = result[Integer.parseInt(st.nextToken())];
        int num2 = result[Integer.parseInt(st.nextToken())];

        switch (ope) {
          case '+':
            result[i] = num1 + num2;
            break;
          case '-':
            result[i] = num1 - num2;
            break;
          case '*':
            result[i] = num1 * num2;
            break;
          case '/':
            result[i] = num1 / num2;
            break;
        }
      }

      bw.write("#" + t + " " + result[1] + "\n");
    }

    bw.flush();
  }
}
