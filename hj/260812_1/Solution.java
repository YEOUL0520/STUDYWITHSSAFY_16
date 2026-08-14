import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		/*
		  2805. 농작물 수확하기
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			
			
			for(int i = 0; i<N; i++) {
				String input = br.readLine();
				for(int j = 0; j <N; j++) {
					arr[i][j] = input.charAt(j) - '0';
				}
			}
			
			int middle = N/2;
			int answer = 0;
			
			 for (int i = 0; i < N; i++) {
	                int distance = Math.abs(middle - i);

	                for (int j = distance; j < N - distance; j++) {
	                    answer += arr[i][j];
	                }
	            }
			

			System.out.println("#" + test_case +" " + answer);
		}
	}

}
