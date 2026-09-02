/*
4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어진다.

이 문자열에 사용된 괄호들의 짝이 모두 맞는지 판별하는 프로그램을 작성한다.
[입력]
각 테스트 케이스의 첫 번째 줄에는 테스트케이스의 길이가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.
총 10개의 테스트케이스가 주어진다.

181
(({<(({{[[[[<<[[(<[[{([{{{[<[[[{<<(<[[{}[]{}{}[]]]><<>{})[]{}><>[]<>><>}][]]<>{}]>]()}()()(){}}}{}][])(){}<>()}]{}[]]>()[][][]){}]]{}[]<>><>{}[]{}<>>]]]][]{}{}[]()}}))>}<>{}()))[][]
298
{({{[({([{(<[([(([<({[{{[[({{[({([<{(<[[(<((<[{[<[([((<{{[([{<<[{(<({[<{}()>[]<>][]})>[])<>()[]}]>><>(){}()[]}]{}()<>[]<>)<>{}<>{}{}]}()}<>>)[]){}])]>[][]{}]()}][]()>[]))[]>)]][]>)[]{}}[]<><>>]()[])}{}){}]}}<><>){}][]{}{}]<>[]}(){}<>}][]})[]()><>]))])]>{}{}())}{}])<>}{})]{}{}}[])())<>{}[]<><>}[]{}

[출력]
#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 유효성 여부를 1 또는 0으로 표시한다 (1 - 유효함, 0 - 유효하지 않음).
#1 0
#2 0
*/

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int ans = 0;
            String input = br.readLine();

            if (N % 2 == 1) {
                System.out.println("#" + test_case + " " + ans);
                continue;
            }

            Stack<Character> vec = new Stack<>();
            boolean isValid = true;

            for (int i = 0; i < N; i++) {
                char curr = input.charAt(i);

                if (curr == '(' || curr == '{' || curr == '<' || curr == '[') {
                    vec.push(curr);
                } else {
                    if (vec.isEmpty()) {
                        isValid = false;
                        break;
                    }

                    char open = vec.pop();

                    if ((open == '(' && curr != ')') ||
                            (open == '{' && curr != '}') ||
                            (open == '<' && curr != '>') ||
                            (open == '[' && curr != ']')) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!vec.isEmpty()) {
                isValid = false;
            }

            ans = isValid ? 1 : 0;
            System.out.println("#" + test_case + " " + ans);
        }
    }
}