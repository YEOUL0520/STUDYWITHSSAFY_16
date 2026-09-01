import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		/*
		   1210. [S/W 문제해결 기본] 2일차 - Ladder1
		 */
		
		//도착점 X = 2 에서부터 역산

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			br.readLine();
			
			
			int[][] arr = new int[100][100];
			int startIdx = 0;
			
			for(int i = 0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 2) { startIdx = j; }
				}
			}
			
			for(int i = 99; i>=0; i--) {
				// 양 옆 검사하고, 없으면 i 하나씩 줄이면서 위로 올라감
				if(startIdx == 0) {
					//오른쪽만 검사
					if(arr[i][startIdx+1] == 1) {
						for(int j = startIdx+1; j<100; j++) {
							if(arr[i][j]!=1) {
								startIdx = j-1;
								break;
							}else if (j == 99) {
								startIdx = 99;
							}
						}
					}
					
				} else if (startIdx == 99) {
					// 왼쪽만 검사
					if(arr[i][startIdx-1] == 1) {
						for(int j = startIdx -1; j>=0; j--) {
							if(arr[i][j]!=1) {
								startIdx = j+1;
								break;
							} else if (j == 0) {
								startIdx = 0;
							}
						}
					}
				} else {
					//오른쪽만 검사
					if(arr[i][startIdx+1] == 1) {
						for(int j = startIdx+1; j<100; j++) {
							if(arr[i][j]!=1) {
								startIdx = j-1;
								break;
							}else if (j == 99) {
								startIdx = 99;
							}
						}
					} else if(arr[i][startIdx-1] == 1) {
						for(int j = startIdx -1; j>=0; j--) {
							if(arr[i][j]!=1) {
								startIdx = j+1;
								break;
							}else if (j == 0) {
								startIdx = 0;
							}
						}
					}
				}
			}
			
			System.out.println("#"+test_case+" "+startIdx);
		}
	}
}