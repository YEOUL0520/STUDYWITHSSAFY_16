/*
이진 트리에서 임의의 두 정점의 가장 가까운 공통 조상을 찾고, 그 정점을 루트로 하는 서브 트리의 크기를 알아내는 프로그램을 작성하라.
예를 들어, 위의 이진 트리에서 정점 8과 13의 공통 조상은 정점 3과 1 두 개가 있다.

이 중 8, 13에 가장 가까운 것은 정점 3이고, 정점 3을 루트로 하는 서브 트리의 크기(서브 트리에 포함된 정점의 수)는 8이다.

[입력]

가장 첫 번째 줄에 테스트케이스의 수가 주어진다.

각 케이스의 첫 번째 줄에는 정점의 개수 V(10 ≤ V ≤ 10000)와 간선의 개수 E, 공통 조상을 찾는 두 개의 정점 번호가 주어진다.

각 케이스의 두 번째 줄에는 E개 간선이 나열된다. 간선은 항상 “부모 자식” 순서로 표기된다.

위에서 예로 든 트리에서 정점 5와 8을 잇는 간선은 “5 8”로 표기된다.

정점의 번호는 1부터 V까지의 정수이며, 루트 정점은 항상 1번이다.

[출력]

각 테스트케이스마다 '#t'(t는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 가장 가까운 공통 조상의 번호와 그것을 루트로 하는 서브 트리의 크기를 공백으로 구분하여 출력하라.
*/

import java.util.*;
import java.io.*;

class Solution
{
    static int[] parent;
    static int[][] children;
    static int[] childrenCount;

    static int commonAncestor(int A, int B, int V) {
        boolean[] ancestor  = new boolean[V + 1];
        int current = A;

        while (current != 0) {
			ancestor[current] = true;
			current = parent[current];
		}

        current = B;

        while (current != 0 && !ancestor[current]) {
            current = parent[current];
        }

        return current;
    }

    static int countSubTree(int root) {
        int count = 0;
        Stack<Integer> nodes = new Stack<>();
        nodes.push(root);

        while (!nodes.isEmpty()) {
			int current = nodes.pop();
			count++;

			for (int i = 0; i < childrenCount[current]; i++) {
				nodes.push(children[current][i]);
			}
		}

        return count;
    }

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            parent = new int[V + 1];
            children = new int[V + 1][2];
            childrenCount = new int[V + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int parentNode = Integer.parseInt(st.nextToken());
                int childNode = Integer.parseInt(st.nextToken());

                parent[childNode] = parentNode;
                children[parentNode][childrenCount[parentNode]] = childNode;
                childrenCount[parentNode]++;
            }

            int common = commonAncestor(A, B, V);
            int sub = countSubTree(common);

            System.out.println("#" + test_case + " " + common + " " + sub);
		}
	}
}