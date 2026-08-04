/*
2048이라는 추억의 게임을 아는가? 2048은 한 때 유명했던 1인용 게임으로, 격자 위에서 숫자가 적힌
타일들을 밀어서 합치고 최종적으로 2048을 만들어 내는 것이 목표인 게임이다.
한번 타일을 밀 때는 상하좌우를 정해서 밀어야 한다.
방향을 정하면 격자 위에 있는 모든 타일이 그 방향으로 밀린다.
만약 어떤 타일이 밀리는 방향에 다른 타일이 있고, 두 타일에 적힌 숫자가 같다면 두 타일은 합쳐져
새로운 하나의 타일이 되고 이 타일에 적힌 숫자는 합쳐진 숫자들의 합이 된다.
이렇게 합쳐져서 만들어진 새로운 타일은 숫자가 같은 다른 타일이 밀려와도 합쳐져서는 안 된다.
만약 같은 숫자가 적힌 타일이 세 개 이상 있을 때는 헷갈리는 경우를 없애기 위해 빨리 벽에 닿게 될 타일을 먼저 민다고
생각한다.
예를 들어 “2 2 4 2 2 2”가 적힌 타일들이 있을 때, 이 타일들을 왼쪽으로 밀면 결과는 “4 4 4 2 0 0”이 된다.
[입력]
각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N(1≤N≤20)과 하나의 문자열 S가 공백 하나로 구분되어 주어진다.
S는 “left”, “right”, “up”, “down”의 넷 중 하나이며 각각 타일들을 왼쪽, 오른쪽, 위쪽, 아래쪽으로 이동시키겠다는 뜻이다.
다음 N개의 줄의 i번째 줄에는 N개의 정수가 공백 하나로 구분되어 주어진다.
이 정수들은 0이거나 2이상 1024이하의 2의 제곱수들이다.
i번째 줄의 j번째 정수는 격자의 위에서 i번째 줄의 왼쪽에서 j번째에 있는 칸에 있는 타일에 어떤 정수가 적혀 있는지 나타내며,
0이면 이 칸에 타일이 없음을 의미한다.
5 up // 첫 번째 테스트 케이스, N=5
4 8 2 4 0
4 4 2 0 8
8 0 2 4 4
2 2 2 2 8
0 2 2 0 0
[출력]
각 테스트 케이스마다 ‘#t’(t는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 줄을 띄운 후,
N줄에 걸쳐 격자의 어떤 위치에 어떤 숫자가 적힌 타일이 있는지 입력 형식과 같은 형식으로 출력한다.
8 8 4 8 8
8 4 4 2 4
2 4 2 0 8
0 0 0 0 0
0 0 0 0 0
*/
import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            String command = sc.next();
            int[][] grid = new int[N][N];
            int[][] afterGrid = new int[N][N];
            int[][] resultGrid = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            if (command.equals("up")) {
                // 1. 각 열의 0이 아닌 값을 위쪽으로 압축
                for (int j = 0; j < N; j++) {
                    int k = 0;
                    for (int i = 0; i < N; i++) {
                        if (grid[i][j] != 0) {
                            afterGrid[k++][j] = grid[i][j];
                        }
                    }
                }

                // 2. 위에서 아래로 인접한 값들을 합쳐 결과 배열에 저장
                for (int j = 0; j < N; j++) {
                    int resultIndex = 0;
                    int i = 0;

                    while (i < N && afterGrid[i][j] != 0) {
                        if (i + 1 < N
                                && afterGrid[i + 1][j] != 0
                                && afterGrid[i][j] == afterGrid[i + 1][j]) {
                            resultGrid[resultIndex++][j] = afterGrid[i][j] * 2;
                            i += 2;
                        } else {
                            resultGrid[resultIndex++][j] = afterGrid[i][j];
                            i++;
                        }
                    }
                }
            } else if (command.equals("down")) {
                // 1. 각 열의 0이 아닌 값을 아래쪽으로 압축
                for (int j = 0; j < N; j++) {
                    int k = N - 1;
                    for (int i = N - 1; i >= 0; i--) {
                        if (grid[i][j] != 0) {
                            afterGrid[k--][j] = grid[i][j];
                        }
                    }
                }

                // 2. 아래에서 위로 인접한 값들을 합쳐 결과 배열에 저장
                for (int j = 0; j < N; j++) {
                    int resultIndex = N - 1;
                    int i = N - 1;

                    while (i >= 0 && afterGrid[i][j] != 0) {
                        if (i - 1 >= 0
                                && afterGrid[i - 1][j] != 0
                                && afterGrid[i][j] == afterGrid[i - 1][j]) {
                            resultGrid[resultIndex--][j] = afterGrid[i][j] * 2;
                            i -= 2;
                        } else {
                            resultGrid[resultIndex--][j] = afterGrid[i][j];
                            i--;
                        }
                    }
                }
            } else if (command.equals("left")) {
                // 1. 각 행의 0이 아닌 값을 왼쪽으로 압축
                for (int i = 0; i < N; i++) {
                    int k = 0;
                    for (int j = 0; j < N; j++) {
                        if (grid[i][j] != 0) {
                            afterGrid[i][k++] = grid[i][j];
                        }
                    }
                }

                // 2. 왼쪽에서 오른쪽으로 인접한 값들을 합쳐 결과 배열에 저장
                for (int i = 0; i < N; i++) {
                    int resultIndex = 0;
                    int j = 0;

                    while (j < N && afterGrid[i][j] != 0) {
                        if (j + 1 < N
                                && afterGrid[i][j + 1] != 0
                                && afterGrid[i][j] == afterGrid[i][j + 1]) {
                            resultGrid[i][resultIndex++] = afterGrid[i][j] * 2;
                            j += 2;
                        } else {
                            resultGrid[i][resultIndex++] = afterGrid[i][j];
                            j++;
                        }
                    }
                }
            } else if (command.equals("right")) {
                // 1. 각 행의 0이 아닌 값을 오른쪽으로 압축
                for (int i = 0; i < N; i++) {
                    int k = N - 1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (grid[i][j] != 0) {
                            afterGrid[i][k--] = grid[i][j];
                        }
                    }
                }

                // 2. 오른쪽에서 왼쪽으로 인접한 값들을 합쳐 결과 배열에 저장
                for (int i = 0; i < N; i++) {
                    int resultIndex = N - 1;
                    int j = N - 1;

                    while (j >= 0 && afterGrid[i][j] != 0) {
                        if (j - 1 >= 0
                                && afterGrid[i][j - 1] != 0
                                && afterGrid[i][j] == afterGrid[i][j - 1]) {
                            resultGrid[i][resultIndex--] = afterGrid[i][j] * 2;
                            j -= 2;
                        } else {
                            resultGrid[i][resultIndex--] = afterGrid[i][j];
                            j--;
                        }
                    }
                }
            }

            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(" " + resultGrid[i][j]);
                }
                System.out.println();
            }
        }
    }
}
