import java.util.*;
import java.io.*;


public class Solution {
	public static void main(String args[]) throws Exception
	{
		/*
		   6485. 삼성시의 버스 노선
       해당 정류장을 지나는 버스 노선 개수 출력하기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		//일단 배열로 해보자
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[5001];
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				for(int index = start; index<=end; index++) {
					arr[index]++;
				}
			}
			int P = Integer.parseInt(br.readLine());
			
			int ansIdx = 0;
			System.out.print("#"+test_case);
			for(int i = 0; i<P; i++) {
				ansIdx = Integer.parseInt(br.readLine());
				System.out.print(" "+arr[ansIdx]);
			}
			System.out.println();
		}
	}
}
