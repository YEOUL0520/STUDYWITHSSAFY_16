import java.util.*;

public class Solution {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = sc.nextInt();
			int[] building = new int[N];
			int answer = 0;
			
			for(int i = 0; i<N; i++) {
				building[i] = sc.nextInt();
			}
			
			for(int p = 2; p<N-2; p+=3) {
				
				int end = Math.min(p+3, N-2); //마지막 칸의 경우 N-2 로 계산되게
				int maxindex = p;
				
				for(int i = p+1; i<end; i++) {
					if(building[i]>building[maxindex]) {
						maxindex = i;
					}
				}
				
				int secondmax = Math.max(Math.max(building[maxindex+1], building[maxindex+2]),Math.max(building[maxindex-1], building[maxindex-2]));
				if(building[maxindex]> secondmax) {
					answer += (building[maxindex]- secondmax);
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}

}
