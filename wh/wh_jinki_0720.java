/*
진기는 0초부터 붕어빵을 만들기 시작하며, M초의 시간을 들이면 K개의 붕어빵을 만들 수 있다.

서빙은 진기가 하는 것이 아니기 때문에, 붕어빵이 완성되면 어떤 시간 지연도 없이 다음 붕어빵 만들기를 시작할 수 있다.

0초 이후에 손님들이 언제 도착하는지 주어지면, 모든 손님들에게 기다리는 시간없이 붕어빵을 제공할 수 있는지 판별하는 프로그램을 작성하라.
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 세 자연수 N, M, K(1 ≤ N, M, K ≤ 100)가 공백으로 구분되어 주어진다.

두 번째 줄에는 N개의 정수가 공백으로 구분되어 주어지며,

각 정수는 각 사람이 언제 도착하는지를 초 단위로 나타낸다. 각 수는 0이상 11,111이하이다.
 */

package _code_problem.wh;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt(); // N 붕어빵을 먹으려고 하는 사람
            int M = sc.nextInt(); // M 붕어빵을 만들 때 걸리는 시간
            int K = sc.nextInt(); // K 한 번에 만들 수 있는 붕어빵 개수

            int arrivalTime[] = new int[N];

            for (int i = 0; i < N; i++)
            {
                arrivalTime[i] = sc.nextInt();
            }

            boolean possibleForEveryone = true;
            int time = 0;
            int totalBread = 0;
            Arrays.sort(arrivalTime);

            for (int i = 0; i < N; i++)
            {
                time = arrivalTime[i];
                totalBread = (time / M) * K;
                int requiredBread = i + 1;

                if (totalBread < requiredBread)
                {
                    possibleForEveryone = false;
                    break;
                }
            }

            System.out.println("#" + test_case + " " + (possibleForEveryone ? "Possible" : "Impossible"));
		}
	}
}