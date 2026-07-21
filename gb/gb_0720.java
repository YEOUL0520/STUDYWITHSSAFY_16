package _code_problem.gb;

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int testcase = sc.nextInt();
			int[][] map = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int answer = Integer.MIN_VALUE;
			int sum = 0;

			// 가로
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					sum += map[i][j];
				}

				answer = Math.max(answer, sum);
				sum = 0;
			}

			// 세로
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					sum += map[j][i];
				}

				answer = Math.max(answer, sum);
				sum = 0;
			}

			// 오른쪽 밑 대각선
			for (int i = 0; i < 100; i++) {
				sum += map[i][i];
			}

			answer = Math.max(answer, sum);
			sum = 0;

			// 왼쪽 밑 대각선
			for (int i = 0; i <= 99; i++) {
				sum += map[i][99 - i];
			}

			answer = Math.max(answer, sum);
			sum = 0;

			System.out.println("#" + t + " " + answer);
		}
	}
}