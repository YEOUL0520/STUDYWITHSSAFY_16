import java.util.*;
import java.io.*;

/*
2112. [모의 SW 역량테스트] 보호 필름
*/

public class Solution {
	static int T;
	static int D;
	static int W;
	static int K;
	
	static int[][] cell;
	static int[] changeState;
	
	static int ans;
	
	static boolean checkKcase() {
		
		if(K<=1) {
			return true;
		}
		
		for(int j = 0; j<W; j++) {
			int kcount = 1;
			boolean success = false;
			
			for(int i = 1; i<D; i++) {
				int now;
				int before;
				
				if(changeState[i] == -1) {
					now = cell[i][j];
				}else {
					now = changeState[i];
				}
				if(changeState[i-1] == -1) {
					before = cell[i-1][j];
				}else {
					before = changeState[i-1];
				}
				
				if(now == before) {
					kcount++;
				}else {
					kcount = 1;
				}
				
				if(kcount >= K) {
					success = true;
					break;
				}
			}
			
			if(!success) {
				return false;
			}
		}
		
		return true;
	}
	
	static void solve(int depth, int changeCnt) {
		if(changeCnt >= ans) return;
		if(depth == D) {
			if(checkKcase()) {
				ans = Math.min(ans, changeCnt);
			}
			return;
		}
		
		// 현재 행을 변경하지 않음
        changeState[depth] = -1;
        solve(depth + 1, changeCnt);

        // 현재 행에 A 약품 투입
        changeState[depth] = 0;
        solve(depth + 1, changeCnt + 1);

        // 현재 행에 B 약품 투입
        changeState[depth] = 1;
        solve(depth + 1, changeCnt + 1);

        // 다른 탐색에 영향을 주지 않도록 복구
        changeState[depth] = -1;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			cell = new int[D][W];
			for(int i = 0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<W; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			changeState = new int[D];
			Arrays.fill(changeState, -1);
			
			ans = K;
			
			if(checkKcase()) {
				ans = 0;
			}else {
				solve(0, 0);
			}
			
			System.out.println("#"+test_case+" "+ans);
		}
	}

}
