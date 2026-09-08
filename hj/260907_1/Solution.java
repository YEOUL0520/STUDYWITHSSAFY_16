import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] arr;
	static boolean[] selected;
	static int ans;
	
	public static void comb(int idx, int count) {
		
		
		//몇 개 중에 고르는 건지?
		if(count == N/2) {
			int tasteA = 0;
			int tasteB = 0;
			
			//선택 다 끝났으니까 계산
			for(int i = 0; i<N; i++) {
				for(int j = i+1; j<N; j++) {
					if(selected[i] && selected[j]) {
						tasteA += arr[i][j]+arr[j][i];
					}else if(!selected[i] && !selected[j]) {
						tasteB += arr[i][j]+arr[j][i];
					}
				}
			}
			
			int diff = Math.abs(tasteA - tasteB);
			
			ans = Math.min(ans, diff);
			
			return;
		}
		
		for(int i = idx; i<N; i++) {
			selected[i] = true;
			comb(i+1, count+1);
			selected[i] = false;
		}
	}
	public static void main(String[] args) throws IOException
	{
		/*
		   4012. [모의 SW 역량테스트] 요리사
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			selected = new boolean[N];
			ans = Integer.MAX_VALUE; //최소 case 갱신할 변수
			
			selected[0] = true;
			comb(1,1);
			
			//가능한 모든 경우의 조합 -> 되추적(Backtracking)
			
			System.out.println("#"+test_case+" "+ans);
		}
		
		
		
	}

}
