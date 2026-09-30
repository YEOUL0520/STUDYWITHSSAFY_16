/*
Problem 02 : 오염 구역의 개수
*/

import java.io.*;
import java.util.*;

class Solution {
	public static int cnt;	// 오염 구역의 개수
	public static int max;	// 오염 구역 넓이 최대값
	public static int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};	// 상하좌우, 대각선 총 8방향
	public static int[][] map;
	public static int N;
	public static int M;
	public static int curCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());	// 테스트 케이스의 총 수 입력 받기
		
		for (int t = 1; t <= TC; t++) {
			// 배열의 크기 입력 받기 
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];	// NxM 배열 생성
			
			// NxM 배열의 원소 입력 받기
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 오염 구역의 개수, 오염 구역 넓이 최대값 초기화
			cnt = 0;
			max = 0;
			
			// 오염된 곳(1)을 발견하면 dfs로 해당 오염 구역의 넓이 찾기
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (map[n][m] == 1) {
						cnt++;	// 오염 구역을 찾았으니 cnt 1 증가
						curCnt = 1;
						dfs(n, m);
					}
				}
			}
			
			// 테스트 케이스 번호, 오염 구역의 개수, 오염 구역 넓이 최대값 출력
			bw.write("#" + t + " " + cnt + " " + max + "\n");
		}
		
		bw.flush();
	}
	
	/* dfs로 해당 오염 구역을 찾는 함수 */
	public static void dfs(int r, int c) {
		map[r][c] = 0;	// 방문 체크
		max = Math.max(max, curCnt);	// max 최대값 갱신
		
		for (int[] d : directions) {
			// 현재 방향에 따른 다음 위치 계산 
			int nextR = r + d[0];
			int nextC = c + d[1];
			
			// 범위 체크: 범위 벗어나면 패스
			if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) {
				continue;
			}
			
			// 방문 체크: 방문했었으면 패스
			if (map[nextR][nextC] == 0) {
				continue;
			}
			
			// 다음 위치로 이동
			curCnt++;
			dfs(nextR, nextC);
		}
	}
}
