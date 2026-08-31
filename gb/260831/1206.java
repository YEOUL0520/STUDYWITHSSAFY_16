/*
1206. [S/W 문제해결 기본] 1일차 - View (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh&categoryId=AV134DPqAA8CFAYh&categoryType=CODE&problemTitle=1206&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    for (int t = 1; t <= 10; t++) {
      int N = Integer.parseInt(br.readLine());
      int[] arr = new int[N];
      
      st = new StringTokenizer(br.readLine());
      for (int n = 0; n < N; n++) {
        arr[n] = Integer.parseInt(st.nextToken());
      }

      int answer = 0;

      for (int m = 2; m < N - 2; m++) {
        int middle = arr[m];
        int leftMax = Math.max(arr[m - 2], arr[m - 1]);
        int rightMax = Math.max(arr[m + 2], arr[m + 1]);

        // 내가 제일 높은게 아니면 패스
        if (middle < leftMax || middle < rightMax) {
          continue;
        }

        answer += middle - Math.max(leftMax, rightMax);
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }
}
