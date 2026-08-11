/*
https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
2차 세계 대전에서 연합군과 독일군의 전투가 점점 치열해지고 있다.
전투가 진행중인 지역은 대규모 폭격과 시가전 등으로 인해 도로 곳곳이 파손된 상태이다.
전투에서 승리하기 위해서는 기갑사단과 보급부대가 신속하게 이동하기 위한 도로가 있어야 한다.
공병대는 출발지(S) 에서 도착지(G)까지 가기 위한 도로 복구 작업을 빠른 시간 내에 수행하려고 한다.
도로가 파여진 깊이에 비례해서 복구 시간은 증가한다.
출발지에서 도착지까지 가는 경로 중에 복구 시간이 가장 짧은 경로에 대한 총 복구 시간을 구하시오.
깊이가 1이라면 복구에 드는 시간이 1이라고 가정한다.
출발지는 좌상단의 칸(S)이고 도착지는 우하단의 칸(G)가 된다.
이동 경로는 상하좌우 방향으로 진행할 수 있으며, 한 칸씩 움직일 수 있다.
지도 정보에는 각 칸마다 파여진 도로의 깊이가 주어진다. 현재 위치한 칸의 도로를 복구해야만 다른 곳으로 이동할 수 있다.
이동하는 시간에 비해 복구하는데 필요한 시간은 매우 크다고 가정한다.
따라서, 출발지에서 도착지까지 거리에 대해서는 고려할 필요가 없다.
출발지(S)와 도착지(G)는 좌상단과 우하단이 되고 입력 데이터에서는 0으로 표시된다.
출발지와 도착지를 제외한 곳이 0인 것은 복구 작업이 불필요한 곳이다.
[입력]
가장 첫 줄은 전체 테스트케이스의 수이다.
각 테스트 케이스마다 지도의 크기(N x N)가 주어진다. 지도의 크기는 최대 100 x 100이다.
그 다음줄 부터 지도의 크기만큼 2차원 배열 형태의 지도 정보가 주어진다.
10
4
0100
1110
1011
1010
6
011001
010100
010011
101001
010101
111010
[출력]  
각 테스트 케이스의 답을 순서대로 출력하며, 각 케이스마다 줄의 시작에 “#C”를 출력하여야 한다.
이때 C는 케이스의 번호이다.
같은 줄에 빈 칸을 하나 두고, 주어진 입력에서 출발지에서 도착지까지 가는 경로 중에 복구 작업에 드는 시간이 가장 작은 경로의 복구 시간을 출력하시오.
#1 2
#2 2
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
    static int findRoute(int[][] grid, int N) {
        int[][] dist = new int[N][N];

        for (int[]row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0];
            int col = curr[1];
            int cost = curr[2];

            if (cost > dist[row][col]) {
                continue;
            }

            if (row == N - 1 && col == N - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                int newCost = cost + grid[nr][nc];

                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.offer(new int[]{nr, nc, newCost});
                }
            }
        }
        return dist[N - 1][N - 1];
    }
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int grid[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    grid[i][j] = line.charAt(j) - '0';
                }
            }

            System.out.println("#" + test_case + " " + findRoute(grid, N));
		}
	}
}