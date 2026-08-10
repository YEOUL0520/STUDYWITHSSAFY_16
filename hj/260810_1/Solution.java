import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String args[]) throws IOException
	{
		/*
		   1251. [S/W 문제해결 응용] 4일차 - 하나로
		   	인도네시아 내의 모든 섬들을 연결, L^2가 최소가 되도록 -> 비용 최소 모든 점 연결
		   	
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{	
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] x_arr = new int[N];
			int[] y_arr = new int[N];
			
			for(int i = 0; i<N; i++) {
				x_arr[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				y_arr[i] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			
			//모든 섬 연결, 비용 최소 -> MST
			boolean[] visited = new boolean[N];
			long[] minDist = new long[N];
			
			Arrays.fill(minDist, Long.MAX_VALUE);
			minDist[0] = 0; //0에서 시작 - 거리 0으로 변경
			
			long total = 0;
			
			
			
			for(int i = 0; i<N; i++) {
				long min = Long.MAX_VALUE;
				int minIdx = 0;
				
				for(int j = 0; j<N; j++) {
					if(!visited[j] && minDist[j] < min) {
						min = minDist[j];
						minIdx = j;
					}
				}
				
				visited[minIdx] = true;
				total += minDist[minIdx];
				
				//새로 추가된  minIdx 이용해  최소연결비용 갱신
				for(int j = 0; j<N; j++) {
					if(visited[j]) continue;
					
					long dx = (long) x_arr[minIdx] - x_arr[j];
					long dy = (long) y_arr[minIdx] - y_arr[j];
					long cost = dx*dx + dy*dy;
					
					if(cost<minDist[j]) {
						minDist[j] = cost;
					}
				}
			}
			
			long answer = Math.round(E * total); //소수 n번째 자리에서 반올림 ㅎ 몰라서 찾아봄
			System.out.println("#"+test_case+" "+answer);

		}
	}

}
