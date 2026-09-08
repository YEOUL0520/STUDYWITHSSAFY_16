 import java.util.*;
import java.io.*;

class Solution
{
	static int N,M,C;
	static int[][] arr;
	static int[][] profit;
	
	//row, startCol부터 가로 M칸 중 C넘지 않도록 꿀 선택했을 떄 최대 수익
	public static int maxProfit(int r, int startCol) {
		int max = 0;
		
		//가로 M칸을 선택 할래말래
		//M개의 벌통에서 만들 수 있는 모든 부분집합을 하나씩 확인
		//2진수로, 각 자리가 벌통의 선택 여부가 되도록 함
		for(int choose = 0; choose<(1<<M); choose++) {
			
			int sum = 0; 
			int nowProfit = 0;
			
			for(int i = 0; i<M; i++) {
				//i를 선택했는지 확인
				if((choose&(1<<i)) != 0){
					int honey = arr[r][startCol+i];
					sum += honey;
					nowProfit += honey*honey;
				}
			}
			
			if(sum <= C) {
				max = Math.max(max, nowProfit);
			}
		}
		return max;
	}
	public static void main(String args[]) throws IOException
	{
		/*
		   2115. [모의 SW 역량테스트] 벌꿀채취
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			profit = new int[N][N-M+1];
			//영역 선택 -> 부분집합 내에서 최대
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N-M+1; j++) {
					profit[i][j] = maxProfit(i,j);
				}
			}
			
			int ans = 0;
			
			for(int rowA = 0; rowA<N; rowA++) {
				for(int colA = 0; colA<N-M+1; colA++) {
					for(int rowB = 0; rowB<N; rowB++) {
						for(int colB = 0; colB<N-M+1; colB++) {
							if(rowA == rowB && colA == colB) {
								continue;
							}
							if(rowA == rowB && Math.abs(colA-colB) <M) {
								continue;
							}
							int total = profit[rowA][colA] + profit[rowB][colB];
							ans = Math.max(ans, total);
						}
					}
				}
			}
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
}