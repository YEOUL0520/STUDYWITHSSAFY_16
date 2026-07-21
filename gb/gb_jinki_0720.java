package _code_problem.gb;

import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); // 손님 수
      int M = Integer.parseInt(st.nextToken()); // 붕어빵 만드는데 걸리는 시간
      int K = Integer.parseInt(st.nextToken()); // 한 번에 만들 수 있는 붕어빵 개수
      int[] customers = new int[N];             // 손님 도착 시간 배열

      st = new StringTokenizer(br.readLine());

      for (int n = 0; n < N; n++) {
        customers[n] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(customers);

      boolean isPossible = true;
      int time = 0; // 흐른 시간
      int sell = 0; // 현재 시간까지 제공한 붕어빵 개수

      for (int n = 0; n < N; n++) {
        int customer_time = customers[n];
        int cnt = customer_time / M * K - sell; // 현재 남은 붕어빵 개수
        
        // 붕어빵 제공
        if (cnt <= 0) {
          isPossible = false;
          break;
        }

        sell++;
      }

      bw.write("#" + t + " " + (isPossible ? "Possible" : "Impossible") + "\n");
    }

    bw.flush();
  }
}
