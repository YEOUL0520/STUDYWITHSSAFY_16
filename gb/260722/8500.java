/*
8500. 극장 좌석 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWz5yIfq74QDFARQ&categoryId=AWz5yIfq74QDFARQ&categoryType=CODE&problemTitle=8500&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int T = Integer.parseInt(br.readLine());
    
    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      int[] arr = new int[N];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int n = 0; n < N; n++) {
        arr[n] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(arr);

      int answer = N + arr[N - 1];

      for (int i = 0; i < N; i++) {
        answer += arr[i];
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }
}