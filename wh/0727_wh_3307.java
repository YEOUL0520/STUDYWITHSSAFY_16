/*
주어진 두 수열의 최장 증가 부분 수열(Longest Increasing Subsequence)의 길이를 계산하는 프로그램을 작성하시오.

수열 { A1, A2, ... , AN }의 최장 증가 부분 수열 B는 다음과 같이 정의된다.

{ B1, B2, ... , BK }에서 0≤K≤N, B1 < B2 < ... < BK이고,

AB1 ≤ AB2 ≤ ... ≤ ABK인 최대 K로 구성된 수열이다.

예를 들어, 수열이 { 1, 3, 2, 5, 4, 7 } 이라면, 최장 부분 증가 수열의 길이는 4가 된다.
*/
import java.util.*;
import java.io.FileInputStream;

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
            int[] lis = new int[N]; // 증가하는 최장 부분수열
            int[] arr = new int[N]; // 원본 수열

            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            int ans = 0;
            for (int i = 0; i < lis.length; i++) { 
                lis[i] = 1; // 가장 짧은 길이의 LIS는 길이 1의 LIS이다.
                for (int j = 0; j < i; j++) { // 배열을 순환하며, 현재 i 번째 숫자보다 작으면
                    if (arr[i] > arr[j]) {
                        lis[i] = Math.max(lis[i], lis[j] + 1); // LIS의 길이가 1 증가한다.
                    }
                }
                ans = Math.max(ans, lis[i]); // 정답에는 가장 긴 길이를 가진 LIS의 길이를 저장
            }

            System.out.println("#" + test_case + " " + ans);
            
		}
	}
}


