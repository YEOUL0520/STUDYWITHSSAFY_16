package _code_problem.wh;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

/*
100X100의 2차원 배열이 주어질 때, 각 행의 합, 각 열의 합, 각 대각선의 합 중 최댓값을 구하는 프로그램을 작성하여라.
 */

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int answer = 0;
            
			int test = 0;
            sc.nextInt();
            
			int[][] grid = new int[100][100];
			for (int i = 0; i < 100; i++) 
			{
				for (int j = 0; j < 100; j++)
				{
					grid[i][j] = sc.nextInt();
				}
			}

			
			int diagSumLeft = 0;
			int diagSumRight = 0;
			for (int i = 0; i < 100; i++)
			{
				int rowSum = 0;
				int colSum = 0;
				
				for (int j = 0; j < 100; j++)
				{
					rowSum += grid[i][j]; // row 합 계산
					colSum += grid[j][i]; // col 합 계산
				}
				diagSumLeft += grid[i][i]; // 왼쪽 위에서 오른쪽 아래로 대각선 합 계산
				diagSumRight += grid[i][99 - i]; // 오른쪽 위에서 왼쪽 아래로 합 계산
				
				answer = (answer > rowSum) ? answer : rowSum;
				answer = (answer > colSum) ? answer : colSum;

			}
			answer = (answer > diagSumLeft) ? answer : diagSumLeft;
			answer = (answer > diagSumRight) ? answer : diagSumRight;

			System.out.println("#" + test_case + " " + answer);
		}
	}
}