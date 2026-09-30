/*
Problem 03 : 작업 전환 비용
*/

import java.io.*;
import java.util.*;

class Solution {
	public static int min;	// 전환 비용의 총합 중 최소값
	public static ArrayList<Integer> list;	// 작업 순서를 저장할 리스트
	public static boolean[] used;	// 작업 순서에 사용했는지 여부를 저장할 배열
	public static int N;
	public static int[][] table;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());	// 테스트 케이스의 총 수 입력 받기
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());	// 작업 개수 입력 받기
			
			// 전환 비용 표 입력 받기
			table = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// min, list, used 초기화
			min = Integer.MAX_VALUE;
			list = new ArrayList<>();
			used = new boolean[N];
			
			// 순열을 이용해 모든 경우 탐색
			permutation();
			
			// 테스트 케이스 번호, 전환 비용의 총합 중 최소값 출력
			bw.write("#" + t + " " + min + "\n");
		}
		
		bw.flush();
	}
	
	/* 순열을 이용해 모든 경우 만들기 */
	public static void permutation() {
		// 배치 완료되었으면 전환 비용 총합 계산하고 종료
		if (list.size() == N) {
			calc();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			// 현재 값을 이미 사용했으면 패스
			if (used[i]) {
				continue;
			}
			
			// i를 넣는 경우 방문 체크 및 리스트에 추가
			used[i] = true;
			list.add(i);
			permutation();
			list.remove(list.size() - 1);
			used[i] = false;
		}
	}
	
	/* 현재 배치의 전환 비용 총합 계산하기 */
	public static void calc() {
		int sum = 0;
		
		for (int i = 0; i < list.size() - 1; i++) {
			sum += table[list.get(i)][list.get(i + 1)];
		}
		
		// min 초기화 갱신
		min = Math.min(min, sum);
	}
}
