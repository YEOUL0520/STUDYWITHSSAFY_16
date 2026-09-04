/*
1234. [S/W 문제해결 기본] 10일차 - 비밀번호 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14_DEKAJcCFAYD&categoryId=AV14_DEKAJcCFAYD&categoryType=CODE&problemTitle=1234&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    for (int t = 1; t <= 10; t++) {
      st = new StringTokenizer(br.readLine());
      int length = Integer.parseInt(st.nextToken());
      String input = st.nextToken();

      Stack<Integer> stack = new Stack<>();

      for (int i = 0; i < length; i++) {
        int num = input.charAt(i) - '0';

        if (stack.isEmpty()) {
          stack.push(num);
          continue;
        }

        if (stack.peek() == num) {
          stack.pop();
        } else {
          stack.push(num);
        }
      }

      int[] answer = new int[stack.size()];

      for (int i = answer.length - 1; i >= 0; i--) {
        answer[i] = stack.pop();
      }

      bw.write("#" + t + " ");
      for (int n : answer) {
        bw.write(String.valueOf(n));
      }
      bw.write("\n");
    }

    bw.flush();
  }
}
