import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			for (int row = 0; row<N; row++) {
				for(int col = 0; col<N; col++) {
					int shape_plus = arr[row][col];
					int shape_x = arr[row][col];
					
					for(int i = 1; i<M; i++) {
						if(row+i<N) shape_plus += arr[row+i][col];
						if(col+i<N) shape_plus += arr[row][col+i];
						if(row-i>=0) shape_plus += arr[row-i][col];
						if(col-i>=0) shape_plus += arr[row][col-i];
						
						if(row-i>=0 && col-i>=0) shape_x += arr[row-i][col-i];
						if(row+i<N && col-i>=0) shape_x += arr[row+i][col-i];
						if(row-i>=0 && col+i<N) shape_x += arr[row-i][col+i];
						if(row+i<N && col+i<N) shape_x += arr[row+i][col+i];
					}
					
					if (shape_plus > max) {
					    max = shape_plus;
					}

					if (shape_x > max) {
					    max = shape_x;
					}
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
	}

}
