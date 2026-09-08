/*
[문제 설명]
숫자가 적힌 N개의 블록이 일렬로 나란히 놓여 있다.

플레이어에게는 해머와 N번의 타격 기회가 주어진다. 한 번 타격할 때마다 블록 하나를 깰 수 있다. 블록이 동시에 2개 이상 깨지는 경우는 없다.

점수 계산 규칙은 다음과 같다.

- 점수는 0점에서 시작한다.
- 블록이 깨지면, 좌와 우로 이웃한 블록에 적힌 두 숫자의 곱만큼 점수를 얻는다.
- 좌와 우 중 한쪽에만 이웃 블록이 있는 경우, 이웃한 블록에 적힌 숫자만큼 점수를 얻는다.
- 이웃 블록이 하나도 없는 경우 (마지막 남은 블록), 해당 블록에 적힌 숫자만큼 점수를 얻는다.
블록 하나가 깨지면, 남은 블록들이 빈 자리 없이 양 옆으로 붙어 새로운 배치를 형성한다.

N개의 블록에 적힌 숫자가 주어질 때, 모든 블록을 깨서 얻을 수 있는 최대 점수를 구하는 프로그램을 작성하라.
[제약 사항]
- 블록의 개수 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)
- 각 블록에 적힌 숫자 K_i는 1 이상 1,000 이하의 정수이다. (1 ≤ K_i ≤ 1000)
- 블록이 동시에 2개 이상 깨지는 경우는 없다.
[입력]
- 첫째 줄에 테스트 케이스의 개수 T가 주어진다. (1 ≤ T ≤ 50)
- 각 테스트 케이스의 첫째 줄에 블록의 개수 N이 주어진다.
- 둘째 줄에 블록에 적힌 숫자 K_1, K_2, …, K_N이 공백으로 구분되어 주어진다.

[출력]
각 테스트 케이스마다 #T 최대점수 형식으로 출력한다. (T는 테스트 케이스 번호)
*/
import java.util.*;
import java.io.*;

class Solution
{
    static int N;
    static LinkedList<Integer> list;
    static int result;
    static boolean[] visited;

    static void calculate(int count, int value, int index) {
        if (count == N) {
            result = Math.max(result, value);
            return;
        }

        for (int i = 0; i < list.size(); i ++) {
            if (visited[index])
                continue;

            if (index > 1 && index < N - 2) {
                value += list.get(index - 1) * list.get(index + 1);
                list.remove(index);
                visited[index] = true;
                calculate(count + 1, value, i);
                visited[index] = false;
            }
            else if (index == 0) {
                value += list.get(index + 1);
                list.remove(index);
                visited[index] = true;
                calculate(count + 1, value, i);
                visited[index] = false;
            }
            else if (index == N - 1) {
                value += list.get(index);
                visited[index] = true;
                calculate(count + 1, value, i);
                visited[index] = false;
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
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            
            int[] blocks = new int[N];
            list = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                blocks[i] = Integer.parseInt(st.nextToken());
                list.add(blocks[i]);
            }
            
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                visited[i] = true;
                calculate(0, 0, i);
                visited[i] = false;
            }

            System.out.println("#" + test_case + " " + result);
		}
	}
}