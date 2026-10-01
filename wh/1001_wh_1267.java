/*
해야 할 V개의 작업이 있다. 이들 중에 어떤 작업은 특정 작업이 끝나야 시작할 수 있으며, 이를 선행 관계라 하자.

이런 작업의 선행 관계를 나타낸 그래프가 주어진다.

이 그래프에서 각 작업은 하나씩의 정점으로 표시되고 선행 관계는 방향성을 가진 간선으로 표현된다.

단, 이 그래프에서 사이클은 존재하지 않는다 (사이클은 한 정점에서 시작해서 같은 정점으로 돌아오는 경로를 말한다).

V개의 작업과 이들 간의 선행 관계가 주어질 때, 일을 끝낼 수 있는 작업 순서를 찾는 프로그램을 작성하라.

가능한 작업 순서가 여러 가지일 경우, 여러분은 이들 중 하나만 제시하면 된다.
*/
import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			List<List<Integer>> graph = new ArrayList<>();
			int[] indegree = new int[V + 1];

			for (int v = 0; v <= V; v++) {
				graph.add(new ArrayList<>());
			}

			st = new StringTokenizer(br.readLine());
			for (int e = 1; e <= E; e++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				indegree[b] += 1;
			}

			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i <= V; i++) {
				if (indegree[i] == 0)
					queue.offer(i);
			}
			StringBuilder result = new StringBuilder();
			result.append("#").append(test_case);
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				result.append(" ").append(curr);

				for (int next : graph.get(curr)) {
					indegree[next]--;
					if (indegree[next] == 0)
						queue.offer(next);
				}
			}

			System.out.println(result);
		}
	}
}