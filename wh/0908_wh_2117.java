/*
N*N 크기의 도시에 홈방범 서비스를 제공하려고 한다.

홈방범 서비스는 운영 상의 이유로 [Fig. 1]의 파란색 부분과 같이 마름모 모양의 영역에서만 제공된다.
또한, 홈방범 서비스를 제공하기 위해서는 운영 비용이 필요하다.

[Fig. 2]와 같이 서비스 영역의 크기 K 가 커질수록 운영 비용이 커진다.

운영 비용은 서비스 영역의 면적과 동일하며, 아래와 같이 구할 수 있다.

운영 비용 = K * K + (K - 1) * (K - 1)

운영 영역의 크기 K 는 1 이상의 정수이다.

 - K = 1 일 때, 운영 비용은 1 이다.

 - K = 2 일 때, 운영 비용은 5 이다.

 - K = 3 일 때, 운영 비용은 13 이다.

 - K = 4 일 때, 운영 비용은 25 이다.

홈방범 서비스를 제공받는 집들은 각각 M의 비용을 지불할 수 있어, 보안회사에서는 손해를 보지 않는 한 최대한 많은 집에 홈방범 서비스를 제공하려고 한다.

도시의 크기 N과 하나의 집이 지불할 수 있는 비용 M, 도시의 정보가 주어진다.

이때, 손해를 보지 않으면서 홈방범 서비스를 가장 많은 집들에 제공하는 서비스 영역을 찾고,

그 때의 홈방범 서비스를 제공 받는 집들의 수를 출력하는 프로그램을 작성하라.
*/

import java.util.*;
import java.io.*;

class Solution
{
    static int[][] map;
    static int count = 0;
    static int N;
    static int M;
    static int result;

    static void calculate(int center_r, int center_c, int k) {
        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int distance = Math.abs(center_r - i) + Math.abs(center_c - j);

                if (distance < k && map[i][j] == 1) {
                    count++;
                }
            }
        }
    }
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 도시 사이즈 N * N
            M = Integer.parseInt(st.nextToken()); // 각 집에서 내는 비용 M

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken()); // 1은 집이 있는 곳, 0은 없는 곳
                }
            }

            result = 0;
            count = 0;
            for (int k = 1; k <= N + 1; k++) {
                int cost = k * k + (k - 1) * (k - 1);
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        calculate(i, j, k);

                        if (count  * M >= cost) {
                            result = Math.max(result, count);
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + result);
		}
	}
}