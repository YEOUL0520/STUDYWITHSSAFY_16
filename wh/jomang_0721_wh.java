/* 
*  강변에 빌딩들이 옆으로 빽빽하게 밀집한 지역이 있다.
*  이곳에서는 빌딩들이 너무 좌우로 밀집하여, 강에 대한 조망은 모든 세대에서 좋지만 왼쪽 또는 오른쪽 창문을 열었을 때 바로 앞에 옆 건물이 보이는 경우가 허다하였다.
*  그래서 이 지역에서는 왼쪽과 오른쪽으로 창문을 열었을 때, 양쪽 모두 거리 2 이상의 공간이 확보될 때 조망권이 확보된다고 말한다.
*  빌딩들에 대한 정보가 주어질 때, 조망권이 확보된 세대의 수를 반환하는 프로그램을 작성하시오.
*  아래와 같이 강변에 8채의 빌딩이 있을 때, 연두색으로 색칠된 여섯 세대에서는 좌우로 2칸 이상의 공백이 존재하므로 조망권이 확보된다. 따라서 답은 6이 된다.
*  총 10개의 테스트케이스가 주어진다.
*  각 테스트케이스의 첫 번째 줄에는 건물의 개수 N이 주어진다. (4 ≤ N ≤ 1000)
*  그 다음 줄에는 N개의 건물의 높이가 주어진다. (0 ≤ 각 건물의 높이 ≤ 255)
*  맨 왼쪽 두 칸과 맨 오른쪽 두 칸에 있는 건물은 항상 높이가 0이다. (예시에서 빨간색 땅 부분)
*/

import java.util.Scanner;

class Solution
{
	@SafeVarargs
	private static <T extends Comparable<? super T>> T max(T first, T... rest)
	{
		T maxValue = first;

		for (T value : rest)
		{
			if (value.compareTo(maxValue) > 0)
			{
				maxValue = value;
			}
		}

		return maxValue;
	}

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[] buildings = new int[N + 4];

            // 맨 처음 2개의 건물과 맨 끝 2개의 건물은 높이가 0
            for (int i = 0; i < N ; i++) {
                buildings[i] = sc.nextInt();
            }

            int count = 0;
            
            for (int i = 2; i < N + 2; i++) {
                // 현재 기준이 되는 건물의 양 옆 2칸의 건물 중 가장 높은 높이를 계산, 이를 현재 선택된 건물의 높이와 비교한다.
                int highestNear = max(
                    buildings[i - 2],
                    buildings[i - 1],
                    buildings[i + 1],
                    buildings[i + 2]
                );

                if (buildings[i] > highestNear) {
                    count += buildings[i] - highestNear;
                }
            }

            System.out.println("#" + test_case + " " + count);
		}
	}
}
