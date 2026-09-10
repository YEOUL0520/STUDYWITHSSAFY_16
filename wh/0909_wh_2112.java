
import java.util.*;
import java.io.*;

class Solution
{
    static int[][] map;
    static int D;
    static int W;
    static int K;
    static int result;

    static boolean check_columns() {
        for (int j = 0; j < W; j++) {
            int column_count = 1;
            boolean pass = (K == 1);
            for (int i = 1; i < D; i++) {
                if (map[i][j] == map[i - 1][j]) {
                    column_count++;
                } else {
                    column_count = 1;
                }

                if (column_count >= K) {
                    pass = true;
                    break;
                }
            }

            if (!pass) {
                return false;
            }
        }

        return true;
    }

    static void calculate(int r, int count) {
        if (count >= result) {
            return;
        }

        if (check_columns()) {
            result = count;
            return;
        }

        if (row == D) {
            return;
        }

        calculate(row + 1, count);

        int[] original = map[r].clone();

        Arrays.fill(map[row], 0);
        calculate(row + 1, count + 1);

        Arrays.fill(map[row], 1);
        calculate(row + 1, count + 1);

        map[row] = original;
    }
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = K;
            calculate(0, 0);

            System.out.println("#" + test_case + " ");
		}
	}
}