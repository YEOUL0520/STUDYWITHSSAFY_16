/*
창용 마을에는 N명의 사람이 살고 있다.

사람은 편의상 1번부터 N번 사람까지 번호가 붙어져 있다고 가정한다.

두 사람은 서로를 알고 있는 관계일 수 있고, 아닐 수 있다.

두 사람이 서로 아는 관계이거나 몇 사람을 거쳐서 알 수 있는 관계라면,

이러한 사람들을 모두 다 묶어서 하나의 무리라고 한다.

창용 마을에 몇 개의 무리가 존재하는지 계산하는 프로그램을 작성하라.
*/
import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 사람의 수
			int M = Integer.parseInt(st.nextToken()); // 서로 알고있는 사람의 관계 수
			
			List<List<Integer>> graph = new ArrayList<>();
			
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}

			boolean[] visited = new boolean[N + 1];
			int count = 0;

			for (int person = 1; person <= N; person++) {
				if (visited[person])
					continue;

				count++;
				Queue<Integer> queue = new ArrayDeque<>();
				queue.offer(person);
				visited[person] = true;

				while (!queue.isEmpty()) {
					int curr = queue.poll();

					for (int next : graph.get(curr)) {
						if (visited[next]) {
							continue;
						}

						visited[next] = true;
						queue.offer(next);
					}
				}
			}	

			System.out.println("#" + test_case + " " + count);
		}
	}
}