import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//dp로 적용
			int count = 0;
			int[] dp = new int[N];
			
			for(int i = 0; i<N; i++) {
				dp[i] = 1; // 숫자 i를 선택할 경우. 일단 1개 선택했으니 길이 1
				for(int j = 0; j<i; j++) {
					if (arr[j] < arr[i]) {
						dp[i] = Math.max(dp[i], dp[j]+1); //기존 최대 or j붙인거 중 더 큰값.
					}
				}
			}
			int answer = 0;
			for(int i =0; i<N; i++) {
				if(dp[i]>=answer) {
					answer = dp[i];
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}

}
