import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()); //이거 외우기가 쉽잖네
			
			int[] seatSpace = new int[N];
			
			for(int i = 0 ; i<N; i++) {
				seatSpace[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(seatSpace);
			
			int count = 0;
			
			for(int i = 0; i<N; i++) {
				count += (seatSpace[i]+1);
				if(i == N-1)
					count += seatSpace[i];
			}
			
			System.out.println("#"+test_case+" "+count);
			
		}

	}

}
