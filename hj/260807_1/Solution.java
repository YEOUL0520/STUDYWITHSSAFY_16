import java.util.*;
import java.io.*;


public class Solution {
	
	public static boolean isCase(int number) {
		String s = String.valueOf(number);
		for(int i = 0; i<s.length()-1; i++) {
			if(s.charAt(i)> s.charAt(i+1)) {
				return false;
			}
		}
		return true;
	
	}

	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = -1;
			
			for(int i = 0; i<N-1; i++) {
				for(int j = i+1; j<N; j++) {
					int number = arr[i]*arr[j];
					if(isCase(number)) {
						max = Math.max(max, number);
					}
				}
			}
			
			System.out.println("#"+test_case+" "+max);
		}
	}
}
