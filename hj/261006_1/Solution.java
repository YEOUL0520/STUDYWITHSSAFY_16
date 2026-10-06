import java.util.*;
import java.io.*;

/*
5215. 햄버거 다이어트
*/
public class Solution {
	static int N;
	static int L;
	static int ans;
	
	static int[] T;
	static int[] K;
	
	public static void dfs(int idx, int num, int cal) {
		if(cal > L) {
			return;
		}
		
		ans = Math.max(ans, num);
		
		//순서 없는 조합이라 visited 필요 X
		for(int i = idx; i <N; i++) {
			dfs(i+1, num+T[i], cal+K[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=TC; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			T = new int[N];
			K = new int[N];
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				T[i] = Integer.parseInt(st.nextToken());
				K[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = Integer.MIN_VALUE;
			dfs(0,0,0);
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}

}
