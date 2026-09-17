/*
27668. 소피 제르멩 소수 (D3)
https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AaCIoRiqBxzHBIPI&categoryId=AaCIoRiqBxzHBIPI&categoryType=CODE
*/

import java.util.Scanner;

class Solution {
  public static final int MAX_NUM = 1000000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int t = 1; t <= T; t++) {
      int L = sc.nextInt();
      int R = sc.nextInt();
      int cnt = 0;

      for (int n = L; n <= R; n++) {
        if (n == 1) {
          continue;
        }

        if (!isPrime(n)) {
          continue;
        }

        if (isPrime(2 * n + 1)) {
          cnt++;
        }
      }

      System.out.println("#" + t + " " + cnt);
    }
  }

  public static boolean isPrime(int num) {
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}
