/*
삼성전자의 서비스 기사인 김대리는 회사에서 출발하여 냉장고 배달을 위해 N명의 고객을 방문하고 자신의 집에 돌아가려한다.

회사와 집의 위치, 그리고 각 고객의 위치는 이차원 정수 좌표 (x, y)로 주어지고 (0 ≤ x ≤ 100, 0 ≤ y ≤ 100)

두 위치 (x1, y1)와 (x2, y2) 사이의 거리는 |x1-x2| + |y1-y2|으로 계산된다.

여기서 |x|는 x의 절대값을 의미하며 |3| = |-3| = 3이다. 회사의 좌표, 집의 좌표, 고객들의 좌표는 모두 다르다.

회사에서 출발하여 N명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것을 찾으려 한다.

회사와 집의 좌표가 주어지고, 2명에서 10명 사이의 고객 좌표가 주어질 때,

회사에서 출발해서 이들을 모두 방문하고 집에 돌아가는 경로 중 총 이동거리가 가장 짧은 경로를 찾는 프로그램을 작성하라.

여러분의 프로그램은 가장 짧은 경로의 이동거리만 밝히면 된다.

이 문제는 가장 짧은 경로를 ‘효율적으로’ 찾는 것이 목적이 아니다.

여러분은 모든 가능한 경로를 살펴서 해를 찾아도 좋다.

모든 경우를 체계적으로 따질 수 있으면 정답을 맞출 수 있다.
*/
import java.io.*;
import java.util.*;

class Solution
{
    static int[][] pos;
    static boolean[] visited;
    static int N;
    static int answer;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 고객 수
            st = new StringTokenizer(br.readLine());
            pos = new int [N + 2][];
            visited = new boolean[N + 2];
            pos[1] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 회사
            pos[0] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 집

            for (int i = 2; i < N + 2; i++) {
                pos[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 고객
            }

            answer = Integer.MAX_VALUE;
            dfs(0, 1, 0);
            System.out.printf("#%d %d%n", test_case, answer);
		}
	}

    static void dfs(int count, int curr, int distance) {
        if (count >= N) {
            answer = Math.min(answer, distance + Math.abs(pos[0][0] - pos[curr][0]) + Math.abs(pos[0][1] - pos[curr][1]));
            return;
        }

        for (int next = 2; next < N + 2; next++) {
            if (visited[next]) {
                continue;
            }

            int move = Math.abs(pos[curr][0] - pos[next][0]) + Math.abs(pos[curr][1] - pos[next][1]);

            visited[next] = true;
            dfs(count + 1, next, distance + move);
            visited[next] = false;
        }
    }
}