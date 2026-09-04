/*
사칙연산으로 구성되어 있는 식은 이진 트리로 표현할 수 있다. 아래는 식 “(9/(6-4))*3”을 이진 트리로 표현한 것이다.

임의의 정점에 연산자가 있으면 해당 연산자의 왼쪽 서브 트리의 결과와 오른쪽 서브 트리의 결과에 해당 연산자를 적용한다.
사칙연산 “+, -, *, /”와 양의 정수로만 구성된 임의의 이진 트리가 주어질 때, 이를 계산한 결과를 출력하는 프로그램을 작성하라.

계산 중간 과정에서의 연산은 모두 실수 연산으로 한다.

[입력]
총 10개의 테스트 케이스가 주어진다. (총 테스트 케이스의 개수는 입력으로 주어지지 않는다)
각 테스트 케이스의 첫 줄에는 정점의 개수 N(1≤N≤1000)이 주어진다. 그다음 N 줄에 걸쳐 각 정점의 정보가 주어진다.

정점이 정수면 정점 번호와 양의 정수가 주어지고, 정점이 연산자이면 정점 번호, 연산자, 해당 정점의 왼쪽 자식, 오른쪽 자식의 정점 번호가 차례대로 주어진다.

정점 번호는 1부터 N까지의 정수로 구분된고 루트 정점의 번호는 항상 1이다.

위의 예시에서, 숫자 4가 7번 정점에 해당하면 “7 4”으로 주어지고, 연산자 ‘/’가 2번 정점에 해당하면 두 자식이 각각 숫자 9인 4번 정점과 연산자 ‘-’인 5번 정점이므로 “2 / 4 5”로 주어진다.
5
1 - 2 3
2 - 4 5
3 10
4 88
5 65

[출력]
각 테스트케이스마다 '#t'(t는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 사칙연산을 계산한 결과값을 출력한다.
결과값은 소수점 아래는 버리고 정수로 출력한다.
#1 13
*/

import java.util.*;
import java.io.*;

class Solution {
    static String[] value;
    static int[] leftChild;
    static int[] rightChild;

    static double calculate(int node) {
        if (leftChild[node] == 0) {
            return Double.parseDouble(value[node]);
        }

        double leftValue = calculate(leftChild[node]);
        double rightValue = calculate(rightChild[node]);

        if (value[node].equals("+")) {
            return leftValue + rightValue;
        }

        if (value[node].equals("-")) {
            return leftValue - rightValue;
        }

        if (value[node].equals("*")) {
            return leftValue * rightValue;
        }

        return leftValue / rightValue;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            value = new String[N + 1];
            leftChild = new int[N + 1];
            rightChild = new int[N + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int node = Integer.parseInt(st.nextToken());
                value[node] = st.nextToken();

                if (st.hasMoreTokens()) {
                    leftChild[node] = Integer.parseInt(st.nextToken());
                    rightChild[node] = Integer.parseInt(st.nextToken());
                }
            }
            double ans = calculate(1);
            System.out.println("#" + test_case + " " + (int) ans);
        }
    }
}