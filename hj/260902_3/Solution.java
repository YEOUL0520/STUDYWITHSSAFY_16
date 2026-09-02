import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		/*
		   1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			Deque<Character> s = new ArrayDeque<>();
			
			int answer = 1;
			
			String input = br.readLine();
			
			for(int i = 0; i<N; i++) {
				
				if(input.charAt(i) == '{' || input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '<') {
					s.push(input.charAt(i));
				}else if(input.charAt(i) == '}') {
					if(s.isEmpty()|| s.pop()!= '{') {
						answer = 0;
					}
				}else if(input.charAt(i) == ')') {
					if(s.isEmpty() || s.pop()!= '(') {
						answer = 0;
					}
				}else if(input.charAt(i) == ']') {
					if(s.isEmpty() || s.pop()!= '[') {
						answer = 0;
					}
				}else if(input.charAt(i) == '>') {
					if(s.isEmpty() || s.pop()!= '<') {
						answer = 0;
					}
				}
			}
			
			if(!s.isEmpty()) { answer = 0;}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
}