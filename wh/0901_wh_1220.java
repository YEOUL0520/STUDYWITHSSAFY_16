/*
테이블 위에 자성체들이 놓여 있다.
자성체들은 성질에 따라 색이 부여되는데, 푸른 자성체의 경우 N극에 이끌리는 성질을 가지고 있고, 붉은 자성체의 경우 S극에 이끌리는 성질이 있다.
아래와 같은 테이블에서 일정 간격을 두고 강한 자기장을 걸었을 때, 시간이 흐른 뒤에 자성체들이 서로 충돌하여 테이블 위에 남아있는 교착 상태의 개수를 구하라.
붉은 자성체의 경우 S극에 이끌리면서 테이블 아래로 떨어지게 된다.
푸른 자성체의 경우 N극에 이끌리면서 테이블 아래로 떨어지게 된다.
나머지 자성체들은 서로 충돌하며, 교착 상태에 빠져 움직이지 않게 된다.
한 쪽 방향으로 움직이는 자성체의 개수가 많더라도 반대 방향으로 움직이는 자성체가 하나라도 있으면 교착 상태에 빠져 움직이지 않는다.
셋 이상의 자성체들이 서로 충돌하여 붙어 있을 경우에도 하나의 교착 상태로 본다.
좌우로 인접하여 있으나 각각 다른 교착 상태로 판단하여 2개의 교착 상태로 본다.
한 줄에 두 개 이상의 교착 상태가 발생할 수도 있다.
위의 예시의 경우 테이블 위에 남아있는 교착상태는 7개이므로 7를 반환한다.

[제약 사항]
자성체는 테이블 앞뒤 쪽에 있는 N극 또는 S극에만 반응하며 자성체끼리는 전혀 반응하지 않는다.
테이블의 크기는 100x100으로 주어진다. (예시에서는 설명을 위해 7x7로 주어졌음에 유의)

[입력]
10개의 테스트 케이스가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 정사각형 테이블의 한 변의 길이가 주어진다. (이 값은 항상 100이다)
그 다음 줄부터 100 x 100크기의 테이블의 초기 모습이 주어진다. 1은 N극 성질을 가지는 자성체를 2는 S극 성질을 가지는 자성체를 의미하며 테이블의 윗부분에 N극이 아래부분에 S극이 위치한다고 가정한다.
(N극 성질을 가지는 자성체는 S극에 이끌리는 성질이 있다.)

[출력]
#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 교착 상태의 개수를 출력한다.
*/

import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            int[][] table = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for (int j = 0; j < N; j++) {
                int selected = 0; // unselected
                for (int i = 0; i < N; i++) {
                    // System.out.println(selected);
                    if(table[i][j] == 1 && selected == 0) {
                        selected = 1;
                    }
                    else if (table[i][j] == 2 && selected == 1) {
                        count++;
                        selected = 0;
                    }
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
	}
}