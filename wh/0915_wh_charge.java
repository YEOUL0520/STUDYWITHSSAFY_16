import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution
{
    static class Home { 
        int x, y, limit;
        Home(int x, int y, int limit) {
            this.x = x;
            this.y = y;
            this.limit = limit;
        }
    }
    static class Charge { 
        int x, y;
        Charge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int distance(Home home, Charge charge) {
        return Math.abs(home.x - charge.x) + Math.abs(home.y - charge.y);
    }
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            Home[] homes = new Home[N];
            boolean[][] isHome = new boolean[31][31];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int limit = Integer.parseInt(st.nextToken());

                homes[i] = new Home(x, y, limit);
                isHome[x + 15][y + 15] = true;
            }

            List<Charge> charges = new ArrayList<>();

            for (int x = -15; x <= 15; x++) {
                for (int y = -15; y <= 15; y++) {
                    if (!isHome[x + 15][y + 15]) {
                        charges.add(new Charge(x, y));
                    }
                }
            }

            int chargeCount = charges.size();

            int[][] distances = new int[chargeCount][N];

            for (int i = 0; i < chargeCount; i++) {
                for (int h = 0; h < N; h++) {
                    distances[i][h] = distance(homes[h], charges.get(i));
                }
            }
            // int result = findOne(homes, distances);
            int result = 0;
            
            // if (result == Integer.MAX_VALUE) {
            //     result = findTwo(homes, distances);
            // }

            // if (result == Integer.MAX_VALUE) {
            //     result = -1;
            // }

            System.out.println("#" + test_case + " " + result);
        }
	}

    // static int findOne(Home[] homes, int[][] distances) {
    //     int answer = Integer.MAX_VALUE;

    //     for (int first = 0; first < distances.length; first++) {
    //         int sum = 0;
    //         boolean possible = true;

    //         for (int h = 0; h < homes.length; h++) {
    //             int d = distances[first][h];

    //             if (d > homes[h].limit) {
    //                 possible = false;
    //                 break;
    //             }

    //             sum += d;
    //         }

    //         if (possible) {
    //             answer = Math.min(answer, sum);
    //         }
    //     }
    //     return answer;
    // }

    // static int findTwo(Home[] homes, int[][] distances) {
    //     int answer = Integer.MAX_VALUE;
    //     int chargeCount = distances.length;

    //     for (int first = 0; first < chargeCount; first++) {
    //         for (int second = first + 1; second < chargeCount; second++) {
    //             int sum = 0;
    //             boolean possible = true;

    //             for (int h = 0; h < homes.length; h++) {
    //                 int nearest = Math.min(distances[first][h], distances[second][h]);

    //                 if (nearest > homes[h].limit) {
    //                     possible = false;
    //                     break;
    //                 }

    //                 sum += nearest;
    //             }

    //             if (possible && sum < answer) {
    //                 answer = sum;
    //             }
    //         }
    //     }

    //     return answer;
    // }
}