import java.util.*;
import java.io.*;


public class Solution {
	/*재귀가 밉다~*/
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			int[] cols = new int[N];
			int answer = 0;
			
			answer = nqueens(0,cols);
			
			System.out.println("#"+test_case+" "+answer);

		}
	}
	
	public static int nqueens(int row, int[] cols) {
		
		if (row == N) {
			return 1;
		}
		
		int count = 0;
		
		for(int col = 0; col<N; col++) {
			cols[row] = col;
			if(possible(row, cols)) {
				count += nqueens(row+1, cols);
			}
		}
		
		return count;
		
	}
	
	public static boolean possible(int row, int[] cols) {
		for(int i = 0; i<row; i++) {
			if(cols[i] == cols[row]) return false; //같은 열에 있으면 안됨
			if(Math.abs(row - i) == Math.abs(cols[row] - cols[i])) return false; //같은 대각선에 있음 안됨
			
		}
		return true;
	}
	
}
