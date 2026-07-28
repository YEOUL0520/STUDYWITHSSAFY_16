import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   극장에서 영화를 봐요
		 */


		BufferedReader br = new BufferedReader(new InputStreamReader(system.in));
    int T = Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++)
		{
      int N = Integer.parseInt(br.readLine()); //극장에 앉아있는 사람수
			/* 주의! 좌석이 일렬로 (ㅋㅋ) */
			// 차지하는 공간 -> 자신 & 자신양옆 2*3(Ai) = area 가 나오면 이게 사람 수만큼 존재
			// 근데 이제 빈칸은 서로 겹칠 수 있으니까 그 부분에 대한 로직이 문제일듯?
      
		}
	}
}