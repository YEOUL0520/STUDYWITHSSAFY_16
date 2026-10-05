import java.util.*;
import java.io.*;

/* Problem 03 : 작업 전환 비용 
모든 작업을 정확히 한 번씩 수행하면서, 
연속해서 수행되는 두 작업 사이의 전환 비용의 총합이 가장 작아지도록 작업 순서를 정하려고 한다.
전환 비용이 주어질 때, 모든 작업을 한 번씩 배치하여 수행했을 때 가능한 최소 전환 비용의 총합을 구하여라.
*/

public class Solution {
	static int[][] prize;
	static boolean[] visited;
	static int N;
	static int min;
	
	public static void dfs(int current, int idx, int result) {
		if(idx == N) {
			min = Math.min(min, result);
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i ,idx+1, result + prize[current][i]);
				visited[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			prize = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					prize[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			
			// 시작 상태도 여러 후보 중 골라야 하는 경우 (0단계를 main에서 선수행)
			for(int i = 0; i<N; i++) {
				visited[i] = true;
				dfs(i, 1, 0);
				visited[i] = false;
			}
			
			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

}
