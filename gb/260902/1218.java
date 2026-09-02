/*
1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD&categoryId=AV14eWb6AAkCFAYD&categoryType=CODE&problemTitle=1218&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int t = 1; t <= 10; t++) {
      int length = Integer.parseInt(br.readLine());
      String line = br.readLine();
      boolean isPossible = true;
      Stack<Character> stack = new Stack<>();

      for (int i = 0; i < length; i++) {
        char input = line.charAt(i);

        if (input == ')') {
          if (stack.peek() == '(') {
            stack.pop();
          } else {
            isPossible = false;
            break;
          }
        } else if (input == ']') {
          if (stack.peek() == '[') {
            stack.pop();
          } else {
            isPossible = false;
            break;
          }
        } else if (input == '}') {
          if (stack.peek() == '{') {
            stack.pop();
          } else {
            isPossible = false;
            break;
          }
        } else if (input == '>') {
          if (stack.peek() == '<') {
            stack.pop();
          } else {
            isPossible = false;
            break;
          }
        } else {
          stack.add(input);
        }
      }

      bw.write("#" + t + " " + (isPossible ? "1" : "0") + "\n");
    }

    bw.flush();
  }
}
