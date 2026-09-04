import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{

		/*
		   1234. [S/W 문제해결 기본] 10일차 - 비밀번호
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			String input = st.nextToken();
			Deque<Character> s = new ArrayDeque<>();
			
			for(int i = 0; i<N; i++) {
				char now = input.charAt(i);
				if(!s.isEmpty() && s.peek() == now) {
					s.pop();
				}else {
					s.push(now);
				}
			}
			
			StringBuilder answer = new StringBuilder();
			
			while(!s.isEmpty()) {
				answer.append(s.poll());
			}
			answer.reverse();
			System.out.println("#"+test_case+" "+answer);
		}
	}
}