/*
10
6 11
1 1 1 1 1 1
1 1 0 0 0 1
1 0 0 0 0 1
1 1 0 0 0 1
1 0 0 0 0 1
1 1 1 1 1 1
6 10
1 1 1 1 1 1
1 0 1 0 1 1
1 1 0 1 0 1
1 0 1 0 1 1
1 1 0 1 0 1
1 1 1 1 1 1
7 26
1 1 1 1 1 1 1
1 0 0 0 0 0 1
1 1 0 1 0 0 1
1 0 0 0 0 1 1
1 0 1 0 0 0 1
1 0 0 1 0 0 1
1 1 1 1 1 1 1
7 32
1 1 1 1 1 1 1
1 1 0 0 1 0 1
1 0 1 0 0 0 1
1 0 1 1 0 0 1
1 0 0 1 0 0 1
1 1 0 0 0 1 1
1 1 1 1 1 1 1
7 35
1 1 1 1 1 1 1
1 1 0 0 1 1 1
1 0 0 0 0 0 1
1 1 0 0 1 0 1
1 0 0 1 0 0 1
1 0 1 0 0 1 1
1 1 1 1 1 1 1
8 40
1 1 1 1 1 1 1 1
1 0 0 0 0 0 1 1
1 0 0 1 1 0 1 1
1 0 1 0 1 0 0 1
1 0 0 0 1 0 1 1
1 0 1 1 0 0 0 1
1 1 0 0 0 1 1 1
1 1 1 1 1 1 1 1
8 42
1 1 1 1 1 1 1 1
1 0 0 0 0 1 0 1
1 0 0 1 0 1 0 1
1 1 0 1 0 0 0 1
1 0 0 0 0 0 1 1
1 1 0 1 1 0 1 1
1 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1
9 45
1 1 1 1 1 1 1 1 1
1 0 1 1 1 0 0 1 1
1 0 0 0 1 0 0 0 1
1 0 0 0 1 0 1 1 1
1 1 1 0 1 0 0 0 1
1 1 0 1 1 0 0 1 1
1 1 1 0 1 1 0 0 1
1 0 0 0 0 1 0 0 1
1 1 1 1 1 1 1 1 1
9 48
1 1 1 1 1 1 1 1 1
1 0 1 0 0 0 0 1 1
1 0 1 0 0 0 1 0 1
1 0 1 0 0 0 0 0 1
1 1 0 0 1 0 1 1 1
1 1 0 0 0 1 1 1 1
1 0 0 1 0 1 1 0 1
1 1 1 0 1 1 1 1 1
1 1 1 1 1 1 1 1 1
9 50
1 1 1 1 1 1 1 1 1
1 0 1 1 1 0 0 1 1
1 0 1 0 0 1 0 1 1
1 0 1 0 0 0 0 1 1
1 1 1 0 0 0 0 1 1
1 0 0 1 1 1 1 1 1
1 1 0 0 1 1 0 1 1
1 1 1 1 0 0 1 0 1
1 1 1 1 1 1 1 1 1
*/
import java.io.*;
import java.util.*;

class Solution
{
	static int[][] map;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = 0;
			
			int[][] harvestDay; // 곡식이 열리는 날짜
			int[][] plantCount; // 지금까지 칸에서 싹이 난 횟수
			Stack<Integer> stack = new Stack<>();
            System.out.println("#" + test_case + " ");
		}
	}
}