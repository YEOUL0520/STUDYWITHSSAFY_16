import java.util.*;
import java.io.*;

/*
 1257. [S/W 문제해결 응용] 6일차 - K번째 문자열
 */
public class Solution {
	static int K;
	static String s;
	
	static Set<String> substring; //중복 제거
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			K = Integer.parseInt(br.readLine());
			s = br.readLine();
			
			// 1. 부분 문자열 만들기
			// 순서 고정, 넣을래말래 -> substring함수 쓰자.
			substring = new HashSet<>();
			
			for(int i = 0; i< s.length(); i++) {
				for(int j = i+1; j<= s.length(); j++) {
					substring.add(s.substring(i,j));
				}
			}
			
			// 2. 사전 순으로 정렬
			// 정렬 함수 사용 위해 List 로 변환
			List<String> l = new ArrayList<>(substring);
			Collections.sort(l);
			
			String answer;
			
			if (K > l.size()) {
			    answer = "none";
			} else {
			    answer = l.get(K - 1);
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

}
