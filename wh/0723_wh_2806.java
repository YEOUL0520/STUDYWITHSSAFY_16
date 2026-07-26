import java.util.*;
import java.io.FileInputStream;

class Solution
{
    /*  
    8 * 8 체스보드에 8개의 퀸을 서로 공격하지 못하게 놓는 문제는 잘 알려져 있는 문제이다.
    퀸은 같은 행, 열, 또는 대각선 위에 있는 말을 공격할 수 있다. 이 문제의 한가지 정답은 아래 그림과 같다.
    이 문제의 조금 더 일반화된 문제는 Franz Nauck이 1850년에 제기했다.
    N*N 보드에 N개의 퀸을 서로 다른 두 퀸이 공격하지 못하게 놓는 경우의 수는 몇가지가 있을까?
    N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
    각 테스트 케이스의 첫 번째 줄에는 하나의 자연수 N(1 ≤ N ≤ 10)이 주어진다.
    [출력]
    각 테스트 케이스마다 ‘#x ’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
     */
    static int N;
    static int count;
    static int[] queenColumn;

    static boolean canPlace(int row, int col) {
        // 퀸을 놓을 수 있는지 검사
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queenColumn[prevRow];
            
            if (prevCol == col) {
                return false;
            }

            if (Math.abs(col - prevCol) == Math.abs(row - prevRow))
                return false;
        }


        return true;
    }

    static void DFS(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!canPlace(row, col)) {
                continue;
            }
            queenColumn[row] = col;
            DFS(row + 1);
        }

    }

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt(); // number of queens & rows

            DFS(0);

            System.out.println("#" + test_case + " " + count);
		}

        sc.close();
	}
}