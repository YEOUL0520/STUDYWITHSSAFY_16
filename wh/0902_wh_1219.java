/*
그림과 같이 도식화한 지도에서 A도시에서 출발하여 B도시로 가는 길이 존재하는지 조사하려고 한다.
길 중간 중간에는 최대 2개의 갈림길이 존재하고, 모든 길은 일방 통행으로 되돌아오는 것이 불가능하다.
다음과 같이 길이 주어질 때, A도시에서 B도시로 가는 길이 존재하는지 알아내는 프로그램을 작성하여라.
- A와 B는 숫자 0과 99으로 고정된다.
- 모든 길은 순서쌍으로 나타내어진다. 위 예시에서 2번에서 출발 할 수 있는 길의 표현은 (2, 5), (2, 9)로 나타낼 수 있다.
- 가는 길의 개수와 상관없이 한가지 길이라도 존재한다면 길이 존재하는 것이다.
- 단 화살표 방향을 거슬러 돌아갈 수는 없다.

[제약 사항]
출발점은 0, 도착점은 99으로 표현된다.
정점(분기점)의 개수는 98개(출발점과 도착점 제외)를 넘어가지 않으며, 한 개의 정점에서 선택할 수 있는 길의 개수도 2개를 넘어가지 않는다.
아래 제시된 가이드 라인은 제안사항일 뿐 강제사항은 아니다.

[데이터 저장 가이드]
정점(분기점)의 개수가 최대 100개 이기 때문에, size [100]의 정적 배열 2개을 선언하여, 각 정점의 번호를 주소로 사용하고, 저장되는 데이터는 각 정점에서 도착하는 정점의 번호를 저장한다.
위 그림을 저장하였을 때 결과는 다음과 같다.

[입력]
총 10개의 테스트 케이스가 주어진다.
각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호와 길의 총 개수가 공백으로 분리되어 주어진다.
그 다음 줄에는 순서쌍이 주어진다. 순서쌍의 경우, 별도로 나누어 표현되는 것이 아니라 숫자의 나열이며, 나열된 순서대로 순서쌍을 이룬다.
1 16
0 1 0 2 1 4 1 3 4 8 4 3 2 9 2 5 5 6 5 7 7 99 7 9 9 8 9 10 6 10 3 7

[출력]
#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답(가능 여부)을 출력한다.
가능할 경우 1, 불가능할 경우 0을 출력한다.
#1 1
*/

import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int tc = Integer.parseInt(st.nextToken()); // 테스트 케이스
            int N = Integer.parseInt(st.nextToken()); // 길의 총 개수

            int[] graph_one = new int[100];
            int[] graph_two = new int[100];
            
            Arrays.fill(graph_one, -1);
            Arrays.fill(graph_two, -1);

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < N; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if (graph_one[from] == -1) {
                    graph_one[from] = to;
                } else {
                    graph_two[from] = to;
                }
            }

            Boolean[] visited = new Boolean[100];
            Arrays.fill(visited, false);
            Stack<Integer> route = new Stack<Integer>();

            route.push(0);
            visited[0] = true;
            int ans = 0;

            while(!route.isEmpty()) {
                int curr = route.pop();

                if (curr == 99) {
                    ans = 1;
                    break;
                }

                int next_one = graph_one[curr];
                if (next_one != -1 && !visited[next_one])
                    route.push(next_one);

                int next_two = graph_two[curr];
                if (next_two != -1 && !visited[next_two])
                    route.push(next_two);
            }

            System.out.println("#" + tc + " " + ans);
		}
	}
}