/*
문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.

예를 들어

“3+(4+5)*6+7”

라는 문자열로 된 계산식을 후위 표기식으로 바꾸면 다음과 같다.

"345+6*+7+"

변환된 식을 계산하면 64를 얻을 수 있다.

문자열 계산식을 구성하는 연산자는 +, * 두 종류이며 문자열 중간에 괄호가 들어갈 수 있다.

이 때 괄호의 유효성 여부는 항상 옳은 경우만 주어진다.

피연산자인 숫자는 0 ~ 9의 정수만 주어진다.

[입력]

각 테스트 케이스의 첫 번째 줄에는 테스트 케이스의 길이가 주어진다. 그 다음 줄에 바로 테스트 케이스가 주어진다.

총 10개의 테스트 케이스가 주어진다.
113
(9+(5*2+1)+(3*3*7*6*9*1*7+1+8*6+6*1*1*5*2)*4*7+4*3*8*2*6+(7*8*4*5)+3+7+(2+6+5+1+7+6+7*3*(6+2)+6+6)*2+4+2*2+4*9*3)
[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 답을 출력한다.
#1 672676
*/

import java.util.*;
import java.io.*;

class Solution {
    static int priority(char text) {
        if (text == '*' || text == '/')
            return 2;
        else if (text == '+' || text == '-')
            return 1;

        return 0;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Stack<Integer> numStack = new Stack<>();
            Stack<Character> opStack = new Stack<>();

            StringBuilder post = new StringBuilder();
            for (int i = 0; i < N; i++) {
                char text = input.charAt(i);
                if (Character.isDigit(text))
                    post.append(text);
                else if (text == '(')
                    opStack.push(text);
                else if (text == ')') {
                    while (!opStack.isEmpty() && opStack.peek() != '(') {
                        post.append(opStack.pop());
                    }
                    opStack.pop();
                } else {
                    while (!opStack.isEmpty() && opStack.peek() != '(' && priority(opStack.peek()) >= priority(text)) {
                        post.append(opStack.pop());
                    }

                    opStack.push(text);
                }

            }

            while (!opStack.isEmpty()) {
                post.append(opStack.pop());
            }

            for (int i = 0; i < post.length(); i++) {
                char text = post.charAt(i);

                if (Character.isDigit(text)) {
                    numStack.push(text - '0');
                } else {
                    int right = numStack.pop();
                    int left = numStack.pop();

                    if (text == '+') {
                        numStack.push(left + right);
                    } else if (text == '*') {
                        numStack.push(left * right);
                    }
                }
            }

            System.out.println("#" + test_case + " " + numStack.pop());
        }
    }
}