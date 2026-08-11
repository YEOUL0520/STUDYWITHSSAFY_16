/*
6190. 정곤이의 단조 증가하는 수 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWcPjEuKAFgDFAU4&categoryId=AWcPjEuKAFgDFAU4&categoryType=CODE&problemTitle=6190&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      int[] arr = new int[N];
      int answer = -1;

      st = new StringTokenizer(br.readLine());
      for (int n = 0; n < N; n++) {
        arr[n] = Integer.parseInt(st.nextToken());
      }

      for (int i = 0; i < N - 1; i++) {
        for (int j = i + 1; j < N; j++) {
          int times = arr[i] * arr[j];
          boolean isPossible = true;

          int num = times % 10;
          times /= 10;

          // 뒷자리부터 앞자리쪽으로 순회
          while (times > 0) {
            int placeValue = times % 10;
            
            if (placeValue > num) {
              isPossible = false;
              break;
            }

            num = placeValue;
            times /= 10;
          }

          if (isPossible) {
            answer = Math.max(answer, arr[i] * arr[j]);
          }
        }
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }  
}
