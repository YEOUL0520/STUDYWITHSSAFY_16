import java.util.*;
import java.io.*;


public class Solution {
	public static void main(String args[]) throws Exception
	{
		/*
		   7194. 화섭이의 미생물 배양
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//how? 1) 더하거나, 2) 곱하거나. 둘 중 하나를 선택. 가능한 case 찾기. 재귀나 DP?BFS?
			//더하고, 곱하는 것 중 하나를 선택해서 계속 반복 -> t를 넘으면 종료, t가 안 되면 다시 돌아오기
			//이렇게 하면 오버플로우남. 일단 수식 일반화를 해보자.
			long makeNum = s;
			long lastNum = 0;
			
			long answer = Long.MAX_VALUE;
			
			//예외 case 처리 필요
			if(b == 1) {
				if(s<=t && (t-s) %a == 0) {
					answer = (t-s)/ a;
				}else {
					answer = -1;
				}
				
				System.out.println("#"+test_case+" "+answer);
				continue;
			}
			
			for(int k = 0; makeNum <= t; k++) {
				lastNum = t - makeNum; //내가 만들어야 하는 수
				
				//a로 나누어 떨어지는 경우, +a 중첩 연산이 필요
				if(lastNum % a == 0) {
					int addC = 0;
					long output = lastNum / a;
					
					for(int i = 0; i < k; i++) {
						long c = output % b;
						output = output / b;
						addC += c; //c들의 합
					}
					
					addC += output; //c들의 합 (최고차항)
					long total = k + addC; //b곱한 횟수도 더함
					answer = Math.min(total, answer);
				}
				
				makeNum *= b;

			}
			
			if(answer == Long.MAX_VALUE) { answer = -1; }
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
}
