import java.util.*;
import java.io.*;

public class Solution {
	static int map[][];
	static int N;
	public static void countPoint(int n, int count) {
		int[] line = new int[N];
		for(int i = 0; i<N; i++) {
			if(line[i] == 0) {
				line[i] = n;
				break;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		//1. 가능한 모든 조합 구한 후
		//2. 해당 조합에서의 어색지수 계산
		
		for(int test_case = 1; test_case<=T; test_case++) {
			//StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(br.readLine());
			
			
			map = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} //map[i][j] 는 i와 j의 어색지수가 됨 -i가 앞, j가 뒤. 앞뒤자리따라 어색지수달라짐.
			
			int[] visited = new int[N];
			
			
			countPoint();
			
			int answer = 0; //어색 지수 총합 중 최소값
			
			System.out.println("#"+test_case+" "+answer);
		}
		
	}

}
