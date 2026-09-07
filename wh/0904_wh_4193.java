/*
예선전에서 승리한 삼성이는 결승전 까지 진출하게 되었다.

결승전인 만큼 수영장이 아닌 바다에서 진행되었다.

바다 전체를 사용 할 수 없기에 가로 N 세로 N만큼의 공간만 사용하여 진행하도록 하였다.

이 공간을 벗어나면 실격처리가 되므로 공간안에서 가장 빠른 길을 찾아야 한다.

이 공간에는 섬과 같은 지나갈 수 없는 장애물과, 주기적으로 사라졌다 나타나는 소용돌이 같은 장애물이 존재한다.

( 섬과 같은 장애물은 지도에서 1로 표시, 소용돌이 같은 장애물은 2로 표시 )

소용돌이는 생성되고 2초동안 유지되다가 1초동안 잠잠해진다.

예를들어, 0초에 생성된 소용돌이는 0초, 1초까지 유지되고 2초에 사라지게된다. 또한 3초, 4초에는 생성되고 5초에 사라진다.

(단 ,한번 통과한 소용돌이 위에서는 머물러 있을 수 있다 )

이런 바다에서 삼성이를 우승시키려면 어떤 경로로 보내야 될까?

똑똑한 여러분들은 한번에 그 경로를 찾을 수 있었다. 해당 경로로 수영을 했을때 삼성이는 몇초만에 골인 할 수 있을까?

입력 


첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 수영장의 크기 N  ( 2<=N<=15 )

다음 N개의 줄의 i번째 줄에는 수영장의 모양이 공백으로 구분되어 주어진다. ( 0 : 지나갈 수 있는 곳 , 1 : 장애물 , 2: 주기가 2초인 소용돌이)

다음으로 시작위치 A,B가 주어지고 ( 0<=A,B<=N-1)

마지막 줄에 도착위치 C, D가 주어진다 ( 0 <=C,D<=N-1) ( 도착점과 시작점은 소용돌이가 아니다 )


출력

각 테스트 케이스마다 테스트 케이스의 번호와 이동시간을 공백을 두고 표시한다 

도착 할 수 없다면 -1을 출력한다.

(Ex) #1 4
*/

import java.util.*;
import java.io.*;

class Solution {
    static private class Node {
        int x;
        int y;
        int sec = 0;

        Node(int x, int y, int sec) {
            this.x = x;
            this.y = y;
            this.sec = sec;
        }
    }

    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<Node> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            st = new StringTokenizer(br.readLine());
            Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            queue.offer(start);
            visited[start.x][start.y] = true;

            int ans = -1;

            while (!queue.isEmpty()) {
                Node curr = queue.poll();

                if (curr.x == end.x && curr.y == end.y) {
                    ans = curr.sec;
                    break;
                }

                boolean wait = false;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = curr.x + dx[dir];
                    int ny = curr.y + dy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    if (map[nx][ny] == 1 || visited[nx][ny]) {
                        continue;
                    }

                    if (map[nx][ny] == 2 && curr.sec % 3 != 2) {
                        wait = true;
                        continue;
                    }

                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, curr.sec + 1));
                }

                if (wait) {
                    queue.offer(new Node(curr.x, curr.y, curr.sec + 1));
                }
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}