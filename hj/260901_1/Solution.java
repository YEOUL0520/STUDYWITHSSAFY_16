import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//교착 상태가 아닌경우
			//1. 한 줄에 1만 있거나 2만 있을때
			//2. 한 줄에 있는 1의 가장 큰 좌표가 2의 가장 큰 좌표보다 클때
			//아;; 문제잘못읽음
			//한 줄에 교착 상태가 몇 개 나오나? 1 -> 2 나오면 교착
			
			int answer = 0;
			
			for(int j = 0; j<N; j++) {
				
//				int countN = 0;
//				int countS = 0;
//				
//				int maxNidx = 0;
//				int maxSidx = 0;
				
				boolean checkN = false;
				
				for(int i = 0; i<N; i++) {
					if(arr[i][j] == 1) {
						checkN = true;
					}
					
					else if(checkN && arr[i][j] == 2) {
						answer++;
						checkN = false;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
}
