/*
몇 일 후 집에 돌아 갈 수 있을지 알고 싶은 화섭이화섭이는 미생물을 배양하려고 한다.
화섭이에게 초기에 주어진 미생물은 s마리이다.
교수님이 시켰기 때문에 어쩔 수 없이 화섭이는 이 미생물의 수를 t마리로 만들어야 한다.
화섭이는 하루에 한 번 다음 2가지 작업 중 하나의 작업을 할 수 있다.
 1. 미생물들에게 먹이를 주어 그 수를 a만큼 늘린다.
 2. 미생물들에게 배양액을 주어 그 수를 b배만큼 늘린다.
교수님이 화섭이에게 정확히 t마리로 만들기 전에는 집에 가지 말라고 했다.
그래서 화섭이는 미생물 s마리를 최대한 빨리 t마리로 만들어야 한다.
몇 일 후 집에 돌아 갈 수 있을지 알고 싶은 화섭이를 도와주는 프로그램을 작성하라.

[입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 네 개의 정수 s, t, a, b (1 ≤ s, t, a, b ≤ 109) 이 주어진다.
3
10 40 4 2
10 28 4 2
10 99 4 2

[출력]
각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
화섭이에게 s마리를 t마리로 만들기 위해 필요한 최소한의 일 수를 출력한다.
미생물의 수를 t마리로 만드는 것이 불가능하면 -1을 출력한다.
#1 2
#2 2
#3 -1
*/
import java.util.*;
import java.io.*;

class Solution
{
    public static long solve(long s, long t, long a, long b) {
        if (s > t) {
            return -1;
        }

        if (s == t) {
            return 0;
        }

        if (b == 1 ) {
            long diff = t - s;

            if (diff % a != 0) {
                return -1;
            }

            return diff / a;
        }

        long ans = Long.MAX_VALUE;
        long mulStart = s;
        int count = 0;

        while (mulStart <= t) {
            long diff = t - mulStart;

            if (diff % a == 0) {
                long val = diff / a;
                long addCount = 0;
                long remain = val;

                for (int i = 0; i < count; i++) {
                    addCount += remain % b;
                    remain /= b;
                }

                addCount += remain;
                ans = Math.min(ans, addCount + count);
            }

            if (mulStart > t / b) {
                break;
            }

            mulStart *= b;
            count++;
        }
        return ans == Long.MAX_VALUE ? -1 : ans;
    }
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            // System.out.println("S: " + start);
            long target = Long.parseLong(st.nextToken());
            // System.out.println("T: " + target);
            long add = Long.parseLong(st.nextToken());
            // System.out.println("A: " + add);
            long mul = Long.parseLong(st.nextToken());
            // System.out.println("B: " + mul);
            
            System.out.println("#" + test_case + " " + solve(start, target, add, mul));
		}
	}
}