import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[][] visited = new int[n][n];
		int x = 0;
		int y = 0;
		for (int i = 0; i < q; i++) {
			char direction = sc.next().charAt(0);
			int l = sc.nextInt();
			
			
			for(int j = 0; j<l; j++) {
				int newx = 0;
				int newy = 0;
				
				if(direction == 'N'){
					newx = x-1;
					newy = y;
				}else if(direction == 'S') {
					newx = x+1;
					newy = y;
				}else if(direction == 'E') {
					newx = x;
					newy = y+1;
				}else if(direction == 'W') {
					newx = x;
					newy = y-1;
				}
				
				if(newx< 0 || newy < 0 || newx >= n || newy >= n) { continue; }
				visited[newx][newy]++;
				x = newx;
				y = newy;
			}
		}
		
		int count = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(visited[i][j] >= 2){ count++; }
			}
		}
		System.out.println(count);
	}
}