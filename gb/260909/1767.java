/*
1767. [SW Test 샘플문제] 프로세서 연결하기
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf&categoryId=AV4suNtaXFEDFAUf&categoryType=CODE&problemTitle=1767&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

import java.io.*;
import java.util.*;

class Solution {
	public static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static ArrayList<int[]> cores;
	public static boolean[][] visited;
	public static int N;
	public static int maxCore;
	public static int lengthSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			cores = new ArrayList<>();	// 코어 위치 저장 리스트
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						cores.add(new int[] { i, j });
						visited[i][j] = true;
					}
				}
			}
			
			maxCore = 0;
			lengthSum = 0;
			
			connect(0, 0, 0);
			
			bw.write("#" + t + " " + lengthSum + "\n");
		}
		
		bw.flush();
	}
	
	public static void connect(int idx, int core, int length) {
		/* 모든 인덱스를 봤으면 최대 코어, 최대 전선 길이 갱신하고 종료 */
		if (idx == cores.size()) {
			if (maxCore < core) {	// 연결된 코어 수가 더 많으면 그 값으로 갱신
				maxCore = core;
				lengthSum = length;
			} else if (maxCore == core && lengthSum > length) {	// 연결된 코어 수가 같으면 전선 길이가 더 작은 걸로 갱신
				lengthSum = length;
			}
			return;
		}
		
		int[] curCore = cores.get(idx);	// 현재 인덱스의 코어 위치 가져오기
		
		/* 1. 이미 가장자리에 있는 코어인 경우, 코어 수 1 증가하고 다음으로 넘어가기 */
		if (curCore[0] == 0 || curCore[1] == 0 || curCore[0] == N - 1 || curCore[1] == N - 1) {
			connect(idx + 1, core + 1, length);
			return;
		}
		
		/* 2. 현재 코어의 연결을 포기하는 경우 */
		connect(idx + 1, core, length);
		
		/* 3. 현재 코어 상하좌우로 연결 시도하는 경우 */
		for (int[] d : directions) {
			/* 연결 가능한지 검사 */
			int r = curCore[0];
			int c = curCore[1];
			boolean isPossible = true;
			
			while (true) {
				r += d[0];
				c += d[1];
				
				// 연결 불가하면 false로 바꾸고 종료
				if (visited[r][c] == true) {
					isPossible = false;
					break;
				}
				
				if (r == 0 || c == 0 || r == N - 1 || c == N - 1) {
					break;
				}
			}
			
			// 연결 불가하면 패스
			if (!isPossible) {
				continue;
			}
			
			/* 전선 위치 방문 체크 */
			int vtr = curCore[0];	// visited true r
			int vtc = curCore[1];
			int add = 0;
			
			while (true) {
				vtr += d[0];
				vtc += d[1];
				add++;
				
				if (vtr == 0 || vtc == 0 || vtr == N - 1 || vtc == N - 1) {
					break;
				}
				
				visited[vtr][vtc] = true;
			}
			
			connect(idx + 1, core + 1, length + add);
			
			/* 전선 위치 방문 체크 해제 */
			int vfr = curCore[0];	// visited false r
			int vfc = curCore[1];
			
			while (true) {
				vfr += d[0];
				vfc += d[1];
				
				// 가장자리 도착하면 종료 
				if (vfr == 0 || vfc == 0 || vfr == N - 1 || vfc == N - 1) {
					break;
				}
				
				// 방문 체크 해제
				visited[vfr][vfc] = false;
			}
		}
	}
}
