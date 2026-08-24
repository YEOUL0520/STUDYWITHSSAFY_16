import java.util.*;
import java.io.*;

public class Solution
{
	public static void main(String args[]) throws IOException
	{
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String input = br.readLine();
			int count = 0;
			if(input.charAt(0) == '1'){ count++; };

			//중요한건 앞선 글자랑 다를 때마다 change 일어남. 맨 첫 번째 글자가 1인 경우만 1을 더해주자.
			for(int i = 0; i<input.length(); i++){
				for(int j = i+1; j<input.length(); j++) {
					if(input.charAt(i) != input.charAt(j)) {
						count++;
			            i = j-1;
			            break;
					}
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}