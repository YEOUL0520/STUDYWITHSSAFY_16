import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   1206. [S/W 문제해결 기본] 1일차 - View
		 */
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int N;
			N = sc.nextInt();
			
			int[] arr = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int answer = 0;
			
			for(int i = 2; i<N-2; i++) {
				int leftHigh = Math.max(arr[i-2], arr[i-1]);
				int rightHigh = Math.max(arr[i+2], arr[i+1]);
				
				if(arr[i] - leftHigh >0 && arr[i] - rightHigh >0) {
					answer += Math.min(arr[i] - leftHigh, arr[i] - rightHigh);
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}