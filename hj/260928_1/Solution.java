import java.util.*;

public class Solution {

    static int[][] sum;

    static int countPerson(int r1, int c1, int r2, int c2) {
        return sum[r2][c2]- sum[r1 - 1][c2]- sum[r2][c1 - 1]+ sum[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++) {
        	int N = sc.nextInt();
            int M = sc.nextInt();

            sum = new int[N+1][M+1];

            for (int r = 1; r<= N; r++) {
                for (int c = 1; c<= M; c++) {
                	int population = sc.nextInt();
                    sum[r][c] = population + sum[r-1][c]+ sum[r][c-1]- sum[r-1][c-1];
                }
            }

            int answer = Integer.MIN_VALUE;

            for (int r1 = 1; r1<N-1; r1++) {
                for (int r2 = r1+1; r2<N; r2++) {

                    for (int c1 = 1; c1< M-1; c1++) {
                        for (int c2 = c1+1; c2< M; c2++) {

                        	int minPerson = Integer.MAX_VALUE;

                            for (int section = 0; section<3; section++) {
                                int startRow;
                                int endRow;

                                if (section == 0) {
                                    startRow = 1;
                                    endRow = r1;
                                } else if (section == 1) {
                                    startRow = r1 + 1;
                                    endRow = r2;
                                } else {
                                    startRow = r2 + 1;
                                    endRow = N;
                                }

                                int left = countPerson(startRow, 1, endRow, c1);
                                int middle = countPerson(startRow, c1 + 1, endRow, c2);
                                int right = countPerson(startRow, c2 + 1, endRow, M);

                                minPerson = Math.min(minPerson, left);
                                minPerson = Math.min(minPerson, middle);
                                minPerson = Math.min(minPerson, right);
                            }

                            answer = Math.max(answer, minPerson);
                        }
                    }
                }
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}