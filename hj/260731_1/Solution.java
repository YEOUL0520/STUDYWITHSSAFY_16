import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			int[][] arr = new int[N][N];
			
			// 배열 입력
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 방향별 이동 정의 (처음엔 별개 함수 만들어주려다 더 줄일 수 없겠단 생각이 들어서 그냥 함)
			// 먼저 밀고 -> 같은 것끼리 +
			
			if(dir.equals("left")) {
				for(int i = 0; i<N; i++) {
					int newJ = 0;
					for(int j = 0; j<N; j++) {
						if(arr[i][j] != 0) {
							int value = arr[i][j];
							arr[i][j] = 0;
							arr[i][newJ] = value;
							newJ++;
						}
					}
				}
				
				for(int i = 0; i<N; i++) {
					for(int j =0; j<N-1; j++) {
						if(arr[i][j]!= 0 && arr[i][j] == arr[i][j+1]) {
							arr[i][j] *= 2;
							arr[i][j+1] = 0;
							j++;
						}
					}
				}
				
				for(int i = 0; i<N; i++) {
					int newJ = 0;
					for(int j = 0; j<N; j++) {
						if(arr[i][j] != 0) {
							int value = arr[i][j];
							arr[i][j] = 0;
							arr[i][newJ] = value;
							newJ++;
						}
					}
				}
			}
			
			
			if(dir.equals("right")) {
				for(int i = 0; i<N; i++) {
					int newJ = N-1;
					for(int j = N-1; j>=0; j--) {
						if(arr[i][j] != 0) {
							int value = arr[i][j];
							arr[i][j] = 0;
							arr[i][newJ] = value;
							newJ--;
						}
					}
				}
				
				for(int i = 0; i<N; i++) {
					for(int j = N-1; j>0; j--) {
						if(arr[i][j]!= 0 && arr[i][j] == arr[i][j-1]) {
							arr[i][j] *= 2;
							arr[i][j-1] = 0;
							j--;
						}
					}
				}
				
				for(int i = 0; i<N; i++) {
					int newJ = N-1;
					for(int j = N-1; j>=0; j--) {
						if(arr[i][j] != 0) {
							int value = arr[i][j];
							arr[i][j] = 0;
							arr[i][newJ] = value;
							newJ--;
						}
					}
				}
			}
			
			
			if(dir.equals("down")) {
				for(int j = 0; j<N; j++) {
					int newI = N-1;
					for(int i = N-1; i>=0; i--) {
						if(arr[i][j] != 0) {
							int value = arr[i][j];
							arr[i][j] = 0;
							arr[newI][j] = value;
							newI--;
						}
					}
				}
				
				for(int j = 0; j<N; j++) {
					for(int i = N-1; i>0; i--) {
						if(arr[i][j]!= 0 && arr[i][j] == arr[i-1][j]) {
							arr[i][j] *= 2;
							arr[i-1][j] = 0;
							i--;
						}
					}
				}
				
				for(int j = 0; j<N; j++) {
					int newI = N-1;
					for(int i = N-1; i>=0; i--) {
						if(arr[i][j] != 0) {
							int value = arr[i][j];
							arr[i][j] = 0;
							arr[newI][j] = value;
							newI--;
						}
					}
				}
			}
			
			if(dir.equals("up")) {
				for(int j = 0; j<N; j++) {
					int newI = 0;
					for(int i = 0; i<N; i++) {
						if(arr[i][j] != 0) {
							int value = arr[i][j];
							arr[i][j] = 0;
							arr[newI][j] = value;
							newI++;
						}
					}
				}
				
				for(int j = 0; j<N; j++) {
					for(int i = 0; i<N-1; i++) {
						if(arr[i][j]!= 0 && arr[i][j] == arr[i+1][j]) {
							arr[i][j] *= 2;
							arr[i+1][j] = 0;
							i++;
						}
					}
				}
				
				for(int j = 0; j<N; j++) {
					int newI = 0;
					for(int i = 0; i<N; i++) {
						if(arr[i][j] != 0) {
							int value = arr[i][j];
							arr[i][j] = 0;
							arr[newI][j] = value;
							newI++;
						}
					}
				}
			}

			System.out.println("#"+test_case);
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.print("\n");
			}
		}
	}

}
