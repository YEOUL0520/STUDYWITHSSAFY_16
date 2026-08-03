import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) throws IOException
	{
		/*
      14692. 통나무 자르기
		   Alice와 Bob은 길이 N미터의 통나무를 자르는 게임을 한다. 게임은 Alice가 먼저 시작하며 그 이후 둘이 번갈아가면서 턴을 가진다. 
       각 턴을 맡은 사람은, 통나무를 두 조각으로 나누는데, 이 때 잘린 통나무가 모두 자연수(1 이상의 정수) 미터 길이를 가지도록 잘라야 한다. 
       더 이상 자를 수 없게 되는 사람이 진다. 누가 이기는가?
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			String answer = "Bob";
			if(N>0 && (N%2) == 0) { answer = "Alice"; }
			System.out.println("#"+test_case+" "+answer);

		}
	}
}
