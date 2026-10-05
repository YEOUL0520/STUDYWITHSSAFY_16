import java.util.*;
import java.io.*;

public class Solution {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	static int N;
	static int[] num;
	static int[] operator; //1: +, 2: -, 3: *, 4: % 
	
	public static void dfs(int idx, int result) {
		if(idx == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		//각 연산자 4개 case에 대해 넣을래 말래
		for(int i = 0; i<4; i++) {
			if(operator[i] == 0) continue;
			
			operator[i]--;
			
			if(i == 0) {
				dfs(idx+1, result+num[idx]);
			}else if(i == 1) {
				dfs(idx+1, result-num[idx]);
			}else if(i == 2) {
				dfs(idx+1, result*num[idx]);
			}else if(i == 3) {
				dfs(idx+1, result/num[idx]);
			}
			
			operator[i]++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		operator = new int[4];
		for(int i = 0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		// 각 연산자로 만들 수 있는 모든 경우 찾기
		// 해당 경우에서 최댓값 및 최솟값 찾기
		dfs(1, num[0]);
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}
}
