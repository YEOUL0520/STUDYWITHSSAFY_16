import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String args[]) throws Exception
	{
		/*
		   1213. [S/W 문제해결 기본] 3일차 - String
		   주어지는 영어 문장에서 특정한 문자열의 개수를 반환하는 프로그램 작성하기
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			Integer.parseInt(br.readLine());
			
			int answer = 0;
			int index = 0;
			String findString = br.readLine();
			String originString = br.readLine();
			
			while(true) {
				index = originString.indexOf(findString, index);
				if (index == -1) {
					break;
				}else {
					answer++;
					index = index + findString.length();
				}
			}
			System.out.println("#"+test_case+" "+answer);

		}
	}

}
