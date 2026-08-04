/*
퀴즈 대회에 참가해서 우승을 하게 되면 보너스 상금을 획득할 수 있는 기회를 부여받는다.
우승자는 주어진 숫자판들 중에 두 개를 선택에서 정해진 횟수만큼 서로의 자리를 위치를 교환할 수 있다.
예를 들어, 다음 그림과 3, 2, 8, 8, 8 의 5개의 숫자판들이 주어지고 교환 횟수는 2회라고 하자.
[3] [2] [8] [8] [8]
처음에는 첫번째 숫자판의 3과 네 번째 숫자판의 8을 교환해서 8, 2, 8, 3, 8이 되었다.
[8] [2] [8] [3] [8]
다음으로, 두 번째 숫자판 2와 마지막에 있는 8을 교환해서 8, 8, 8, 3, 2이 되었다.
[8] [8] [8] [3] [2]
정해진 횟수만큼 교환이 끝나면 숫자판의 위치에 부여된 가중치에 의해 상금이 계산된다.
숫자판의 오른쪽 끝에서부터 1원이고 왼쪽으로 한자리씩 갈수록 10의 배수만큼 커진다.
위의 예에서와 같이 최종적으로 숫자판들이 8,8,8,3,2의 순서가 되면 88832원의 보너스 상금을 획득한다.
여기서 주의할 것은 반드시 횟수만큼 교환이 이루어져야 하고 동일한 위치의 교환이 중복되어도 된다.
다음과 같은 경우 1회의 교환 횟수가 주어졌을 때 반드시 1회 교환을 수행하므로 결과값은 49가 된다.
[9] [4] -> [4] [9]
94의 경우 2회 교환하게 되면 원래의 94가 된다.
정해진 횟수만큼 숫자판을 교환했을 때 받을 수 있는 가장 큰 금액을 계산해보자.
최대 자릿수는 6자리이며, 최대 교환 횟수는 10번이다.
[입력]
3
123 1
2737 1
32888 2
[출력]
출력
#1 321
#2 7732
#3 88832
*/

import java.util.*;

class Solution
{
    static int bestScore = 0;
    static String numString;
    static Vector<String> visitedVec;

    public static void DFS(int count, int  best, String num, Vector<String> visited) {
        if (count == 0) {
            bestScore = Math.max(best, Integer.parseInt(num));
            return;
        }
        
        if (visitedVec.contains(num)) {
            return;
        }

        visited.add(num);
        visitedVec = visited;
        for (int i = 0; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                char[] digits = num.toCharArray();
                char temp = digits[i];
                digits[i] = digits[j];
                digits[j] = temp;
                numString = new String(digits);
                DFS(count - 1, bestScore, numString, visitedVec);
                temp = digits[i];
                digits[i] = digits[j];
                digits[j] = temp;
                numString = new String(digits);
            }
        }
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int num = sc.nextInt();
            int count = sc.nextInt();

            bestScore = 0;
            numString = Integer.toString(num);
            visitedVec = new Vector<>(count + 1);
            DFS(count, bestScore, numString, visitedVec);

            System.out.println("#"
                + test_case
                + " "
                + bestScore
            );
		}

        sc.close();
	}
}