/*
Alice와 Bob은 길이 N미터의 통나무를 자르는 게임을 한다. 게임은 Alice가 먼저 시작하며 그 이후 둘이 번갈아가면서 턴을 가진다. 각 턴을 맡은 사람은, 통나무를 두 조각으로 나누는데, 이 때 잘린 통나무가 모두 자연수(1 이상의 정수) 미터 길이를 가지도록 잘라야 한다. 더 이상 자를 수 없게 되는 사람이 진다. 누가 이기는가?

[입력]
첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다. 각 테스트 케이스는 다음과 같이 구성되었다.
- 첫 번째 줄에 정수 N이 주어진다. (2≤N≤ 109)
5
2
3
10
50
100

[출력]
각 테스트 케이스 마다 한 줄씩
- Alice가 이기면 “Alice”, 아니면 “Bob” 을 출력하라.
#1 Alice
#2 Bob
#3 Alice
#4 Alice
#5 Alice
*/

import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int count = 0;
            String answer = "";

            while ( N > 1 ) {
                N--;
                count++;
            }

            if (count % 2 == 1) {
                answer = "Alice";
            } else {
                answer = "Bob";
            }

            System.out.println("#" + test_case + " " + answer);
        }

        sc.close();
	}
}