import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		
		/*9280. 진용이네 주차타워*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] r = new int[n];
			int[] w = new int[m];
			
			int earn = 0;
			
			for(int i = 0; i<n; i++) {
				r[i] = Integer.parseInt(br.readLine());
			}
			for(int i = 0; i<m; i++) {
				w[i] = Integer.parseInt(br.readLine());
			}
			
			//
			int[] isFull = new int[n];
			int[] wait = new int[m];
			Queue<Integer> q = new ArrayDeque<Integer>();
			
			for(int i = 0; i<2*m; i++) {
				// 차가 들어오면
				int input = Integer.parseInt(br.readLine());
				if(input>0) {
					boolean parked = false;
					//비어있는 칸이 있는지 확인
					for(int j = 0; j<n; j++) {
						if(isFull[j] == 0) {
							//가장 빠른 빈칸 j에 채움
							isFull[j] = input;
							earn += w[input-1]*r[j];
							parked = true;
							break;
						}
					}
					
					if(!parked) {
						q.add(input);
					}
				}else {
					//차가 나가면
					input = Math.abs(input);
					for(int j = 0; j<n; j++) {
						if(isFull[j] == input) {
							//칸이 비었다고 갱신하고
							isFull[j] = 0;
							break;
						}
					}
					//주차 대기 배열이 있을 경우 하나 빼서 그 칸을 채움
					if(!q.isEmpty()) {
						for(int j = 0; j<n; j++) {
							if(isFull[j] == 0) {
								int newCar = q.poll();
								isFull[j] = newCar;
								earn += w[newCar-1]*r[j];
								break;
							}
						}
					}
				}
			}
			
			System.out.println("#"+test_case+" "+earn);
		}
	}

}
