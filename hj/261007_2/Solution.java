import java.util.*;
import java.io.*;

/*
   1260. [S/W 문제해결 응용] 7일차 - 화학물질2
 */
class Solution
{
	static int N;
	static int row;
	static int col;
	
	static int[][] arr;
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
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
			
			ArrayList<int[]> list = new ArrayList<>();
			
			// 1. 각 행렬 크기 알아내서 저장
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(arr[i][j] != 0) {
						int row = 0;
						int col = 0;
						
						while(i+row <N && arr[i+row][j] != 0) {
							row++;
						}
						
						while(j+col <N && arr[i][j+col] != 0) {
							col++;
						}
						
						list.add(new int[] {row, col});
						
						for(int r = i; r<i+row; r++) {
							for(int c = j; c<j+col; c++) {
								arr[r][c] = 0;
							}
						}
					}
				}
			}
			
			// 2. 행렬 곱 순서 찾기
			// 아무 곳에도 안 이어지면 첫 번째, 다음부터는 끝 - 시작 같은거 찾기
			int start = -1;
			
			for(int i = 0; i< list.size(); i++) {
				boolean isStart = true;
				
				for(int j = 0; j<list.size(); j++) {
					if(list.get(i)[0] == list.get(j)[1]) {
						isStart = false;
						break;
					}
				}
				
				if(isStart) {
					start = i;
					break;
				}
			}
			
			boolean[] visited = new boolean[list.size()];
			ArrayList<int[]> ordered = new ArrayList<>();
			int curr = start;
			
			while(curr != -1) {
				int[] now = list.get(curr);
				
				ordered.add(now);
				visited[curr] = true;
				
				int next = -1;
				
				for(int i = 0; i<list.size(); i++) {
					if(!visited[i] && now[1] == list.get(i)[0]) {
						next = i;
						break;
					}
				}
				
				curr = next;
			}
			
			// 3. 행렬 곱 횟수 찾기
			int size = ordered.size();
			int[][] dp = new int[size][size];
			
			for(int len = 2; len <= size; len++) {
				for(int i = 0; i+len-1<size; i++) {
					int j = i+len -1;  // 행렬을 len만큼 묶어서 연산할 때, i: 시작 위치 / j : 끝 위치.
					
					dp[i][j] = Integer.MAX_VALUE;
					
					//어디서 자를 건데? k로 하나씩 해 보는거
					for(int k = i; k<j; k++) {
						int cost = dp[i][k] + dp[k+1][j] + ordered.get(i)[0] * ordered.get(k)[1] *ordered.get(j)[1];
						dp[i][j] = Math.min(dp[i][j], cost); 
					}
				}
			}

			int ans = dp[0][size - 1];

			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
}