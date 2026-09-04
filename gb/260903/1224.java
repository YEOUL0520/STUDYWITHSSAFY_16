/*
1224. [S/W 문제해결 기본] 6일차 - 계산기3 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14tDX6AFgCFAYD&categoryId=AV14tDX6AFgCFAYD&categoryType=CODE&problemTitle=1224&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int t = 1; t <= 10; t++) {
      int length = Integer.parseInt(br.readLine());
      String input = br.readLine();

      ArrayList<Character> result = new ArrayList<>();
      Stack<Character> operatorStack = new Stack<>();

      for (int i = 0; i < length; i++) {
        char c = input.charAt(i);

        // 숫자면 바로 넣기
        if (c - '0' >= 0 && c - '0' <= 9) {
          result.add(c);
          continue;
        }

        // 닫힌 괄호면 열린 괄호 나올 때까지 연산자 옮기기
        if (c == ')') {
          while (true) {
            char ope = operatorStack.pop();

            if (ope == '(') {
              break;
            }

            result.add(ope);
          }
        }
        // 열린 괄호면 바로 넣기
        else if (c == '(') {
          operatorStack.push(c);
        }
        else {
          // 들어온게 *, +인데 peek가 +이면 옮기고 넣기
          if (operatorStack.peek() == '*') {
            result.add(operatorStack.pop());
          }

          operatorStack.push(c);
        }
      }

      int answer = 0;
      Stack<Integer> resultStack = new Stack<>();

      for (int i = 0; i < result.size(); i++) {
        char c = result.get(i);
        System.out.print(c);

        // 숫자면 스택에 넣기
        if (c - '0' >= 0 && c - '0' <= 9) {
          resultStack.push(c - '0');
          continue;
        }

        // 연산자면 계산
        int n1 = resultStack.pop();
        int n2 = resultStack.pop();
        
        switch (c) {
          case '+':
            resultStack.push(n1 + n2);
            break;
          case '*':
            resultStack.push(n1 * n2);
            break;
        }
      }
      System.out.println();

      bw.write("#" + t + " " + resultStack.pop() + "\n");
    }

    bw.flush();
  }
}
