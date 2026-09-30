/*
Problem 01 : 균형 잡힌 물류 구역
*/

import java.io.*;
import java.util.*;

class Solution {
	public static int answer;	// 물품 수량 간 차이가 최소일 때, 가장 수량이 적은 물품 수량
	public static int distance;	// 최대 물품 수량와 최소 물품 수량 차의 최소값 저장
	public static int[][] map;
	public static int N;
	public static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스의 총 수 입력 받기
		
		for (int t = 1; t <= T; t++) {
			// 크기 입력 받기
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 물품 수량 입력 받기
			map = new int[N][M];
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			
			// answer, distance 초기화
			answer = 0;
			distance = Integer.MAX_VALUE;
			
			// 가로, 세로 선 2개씩 위치를 이동해가면서 분할할 수 있는 모든 경우 탐색
			for (int h1 = 1; h1 < M; h1++) {
				for (int h2 = h1 + 1; h2 < M; h2++) {
					for (int v1 = 1; v1 < N; v1++) {
						for (int v2 = v1 + 1; v2 < N; v2++) {
							// 물품 수량 구하기
							calc(h1, h2, v1, v2);
						}
					}
				}
			}
			
			// 테스트 케이스 번호, 물품 수량 간 차이가 최소일 때 물품 수량 최소값 출력
			bw.write("#" + t + " " + answer + "\n");
		}
		
		bw.flush();
	}
	
	/* 현재 분할 기준으로 물품 수량 계산 */
	public static void calc(int h1, int h2, int v1, int v2) {
		// 현재 분할 기준 물품 수량 최대값, 최소값 구하기
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		// 가로, 세로 분할 범위 저장
		int[] hRange = { 0, h1, h2, M };
		int[] vRange = { 0, v1, v2, N };
		
		// 물품 수량 구하고 max, min 갱신
		for (int h = 0; h < hRange.length - 1; h++) {
			for (int v = 0; v < vRange.length - 1; v++) {
				int cnt = getCnt(hRange[h], hRange[h + 1], vRange[v], vRange[v + 1]);
				max = Math.max(max, cnt);
				min = Math.min(min, cnt);
			}
		}
		
		// 현재 구한 물품 수량에서 최대 수량과 최소 수량의 차가 distance보다 작으면 갱신
		if (distance > max - min) {
			distance = max - min;
			answer = min;
		}
	}
	
	/* 주어진 범위 내의 물품 수량 구하기 */
	public static int getCnt(int hs, int he, int vs, int ve) {
		int sum = 0;
		
		for (int i = vs; i < ve; i++) {
			for (int j = hs; j < he; j++) {
				sum += map[i][j];
			}
		}
		
		return sum;
	}
}
