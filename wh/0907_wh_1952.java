/*
김 프로는 수영장을 이용한다.

김 프로는 지출이 너무 많아 내년 1년 동안 각 달의 이용 계획을 수립하고 가장 적은 비용으로 수영장을 이용할 수 있는 방법을 찾고 있다.

수영장에서 판매하고 있는 이용권은 아래와 같이 4 종류이다.

① 1일 이용권 : 1일 이용이 가능하다.

② 1달 이용권 : 1달 동안 이용이 가능하다. 1달 이용권은 매달 1일부터 시작한다.

③ 3달 이용권 : 연속된 3달 동안 이용이 가능하다. 3달 이용권은 매달 1일부터 시작한다.
    (11월, 12월에도 3달 이용권을 사용할 수 있다 / 다음 해의 이용권만을 구매할 수 있기 때문에 3달 이용권은 11월, 12월, 1윌 이나 12월, 1월, 2월 동안 사용하도록 구매할 수는 없다.)

④ 1년 이용권 : 1년 동안 이용이 가능하다. 1년 이용권은 매년 1월 1일부터 시작한다.

이용 계획에 나타나는 숫자는 해당 달에 수영장을 이용할 날의 수를 의미한다.

각 이용권의 요금과 각 달의 이용 계획이 입력으로 주어질 때,

가장 적은 비용으로 수영장을 이용할 수 있는 방법을 찾고 그 비용을 정답으로 출력하는 프로그램을 작성하라.

[제약 사항]

1. 시간 제한 : 최대 50개 테스트 케이스를 모두 통과하는 데 C/C++/Java 모두 3초

2. 모든 종류의 이용권 요금은 10 이상 3,000 이하의 정수이다.

3. 각 달의 이용 계획은 각 달의 마지막 일자보다 크지 않다.

[입력]

입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄부터 T개의 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 1일 이용권의 요금, 1달 이용권의 요금, 3달 이용권의 요금, 1년 이용권의 요금이 순서대로 한 칸씩 띄고 주어진다.

그 다음 줄에는 1월부터 12월까지의 이용 계획이 주어진다.

[출력]

테스트 케이스 개수만큼 T개의 줄에 각각의 테스트 케이스에 대한 답을 출력한다.

각 줄은 "#t"로 시작하고 공백을 하나 둔 다음 정답을 출력한다. (t는 1부터 시작하는 테스트 케이스의 번호이다)

출력해야 할 정답은 이용 계획대로 수영장을 이용하는 경우 중 가장 적게 지출하는 비용이다.
*/
import java.util.*;
import java.io.*;

class Solution
{
	static int[] prices;
	static int[] plans;
	static int searchMinimumPrice(int month, int cost) {
		if (month >= 12) {
			return cost;
		}

		int oneMonth = searchMinimumPrice(month + 1, cost + Math.min(plans[month] * prices[0], prices[1]));

		int ThreeMonth = searchMinimumPrice(month + 3, cost + prices[2]);

		return Math.min(oneMonth, ThreeMonth);
	}
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			prices = new int[4];

			int i = 0;
			while (st.hasMoreTokens()) {
				prices[i++] = Integer.parseInt(st.nextToken());
			}

			plans = new int[12];

			st = new StringTokenizer(br.readLine(), " ");

			i = 0;
			while (st.hasMoreTokens()) {
				plans[i++] = Integer.parseInt(st.nextToken());
			}

			int minimum_price = Math.min(prices[3], searchMinimumPrice(0, 0));

			System.out.println("#" + test_case + " " + minimum_price);
		}
	}
}