import java.io.*;
import java.util.*;

class Solution
{
	static int N;
    static int M;

	static int emptyCount;
	static int cakeZone;
	static int chocolateZone;

	static int[] longLight;
	static int[] shortLight;
	static int[] suffixLight;

	static int answer;

	static void dfs(int index, int longCandle, int shortCandle, int lightZone) {
		if (answer == 0) {
			return;
		}

		int currMelt = Integer.bitCount(lightZone & chocolateZone);

		if (currMelt >= answer) {
			return;
		}

		if (longCandle == 2 && shortCandle == 5) {
			if ((lightZone & cakeZone) == cakeZone) {
				answer = currMelt;
			}

			return;
		}

		if (index == emptyCount) {
			return;
		}

		int need = (2 - longCandle) + (5 - shortCandle);

		if (emptyCount - index < need) {
			return;
		}

		if (((lightZone | suffixLight[index]) & cakeZone) != cakeZone) {
			return;
		}

		if (longCandle < 2) {
			dfs (index + 1, longCandle + 1, shortCandle, lightZone | longLight[index]);
		}

		if (shortCandle < 5) {
			dfs (index + 1, longCandle, shortCandle + 1, lightZone | shortLight[index]);
		}

		dfs (index + 1, longCandle, shortCandle, lightZone);
	}

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];
			List<Integer> emptyCells = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					int cellNum = i * N + j;
					int bit = 1 << cellNum;

					if (map[i][j] == 0) {
						cakeZone |= bit;
						emptyCells.add(cellNum);
					} else {
						chocolateZone |= bit;
					}
				}
			}

			emptyCount = emptyCells.size();

			if (emptyCount < 7) {
				answer = -1;
			} else {
				answer = Integer.MAX_VALUE;

				suffixLight = new int[emptyCount + 1];

				for (int i = emptyCount - 1; i >= 0; i--) {
					suffixLight[i] = suffixLight[i + 1] | longLight[i];
				}

				dfs(0, 0, 0, 0);

				if (answer == Integer.MAX_VALUE) {
					answer = -1;
				}
			}

            System.out.println("#" + test_case + " " + answer);
		}
	}
}