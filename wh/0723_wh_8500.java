/*
좌석이 일렬로 나열된 극장에 N명의 사람이 앉아있다.
i번 사람의 왼쪽과 오른쪽으로 적어도 A_i개의 좌석이 연속해서 비어 있다.
즉, i번 사람은 2A_i개의 좌석이 비어 있는 것을 아는 것이다.
이 때, 극장의 좌석 개수로 가능한 수의 최소값을 구하는 프로그램을 작성하라.
사람들은 번호 순서대로 극장에 앉아 있는 것이 아님에 유의하라.
[입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N(1 ≤ N ≤ 104)이 주어진다.
두 번째 줄에는 N개의 정수 A1, A2, ⋯, AN(0 ≤ Ai ≤ 104)이 공백 하나로 구분되어 주어진다.
2 // 테스트 케이스 개수
3 // 첫 번째 테스트 케이스
2 3 2
5 // 두 번째 테스트 케이스
5 2 3 1 4	
[출력]
각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
각 테스트 케이스마다 극장의 좌석 개수로 가능한 수의 최소값을 출력한다.
#1 13 // 첫 번째 테스트 케이스 결과
#2 25 // 두 번째 테스트 케이스 결과
*/

import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int[] array = new int[2];
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int answer = 0;

			int N = sc.nextInt();

			int[] people = new int[N];

			for (int i = 0; i < N; i++) {
				people[i] = sc.nextInt();
			}

			Arrays.sort(people); // 관객의 좌우로 비어있는 좌석의 수의 배열을 정렬(가장 많은 공간을 차지하는 관객을 찾는다.)

			answer += people[N] * 2; // 가장 많은 공간을 차지하는 관객의 좌우 공간을 확보(다음 관객부터는 추가 좌석 배정이 필요 없다.)

			for (int i = 0; i < N - 1; i++) {
				answer += people[i]; // 남은 좌석을 할당
			}

			answer += N; // 최종적으로 관객이 차지하는 좌석을 할당

			System.out.println("#" + test_case + " " + answer);
		}
        sc.close();
	}
}