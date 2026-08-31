import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int testNum = Integer.parseInt(br.readLine());
			int[] arr = new int[1000];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<1000; i++) {
				int input = Integer.parseInt(st.nextToken());
				arr[input]++;
			}
			
			int maxCount = 0;
			int maxNum = 0;
			
			for(int i = 0; i<1000; i++) {
				if(arr[i] > maxCount) {
					maxCount = arr[i];
					maxNum = i;
				}
				else if(arr[i] == maxCount) {
					if(maxNum < i) {
						maxNum = i;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+maxNum);
		}
		
	}

}
