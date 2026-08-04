import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] block = new int[N];
			int distance;
			int max = 0;
			int min = 0;
			for(int i =0; i<N; i++) {
				block[i] = Integer.parseInt(st.nextToken());
				if(i>0) {
					distance = block[i-1]-block[i];
					if(distance>=0 && distance>=max) { max = distance; }
					if(distance<=0 && distance<=min) { min = distance; }
				}
			}
			System.out.println("#"+test_case+" "+(-min)+" "+max);
		}
	}

}
