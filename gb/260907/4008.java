/*
4008. [모의 SW 역량테스트] 숫자 만들기
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeRZV6kBUDFAVH&categoryId=AWIeRZV6kBUDFAVH&categoryType=CODE&problemTitle=4008&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[] operatorCnt;
  public static int[] number;
  public static HashSet<Integer> result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      
      operatorCnt = new int[4];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < operatorCnt.length; i++) {
        operatorCnt[i] = Integer.parseInt(st.nextToken());
      }

      number = new int[N];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        number[i] = Integer.parseInt(st.nextToken());
      }

      result = new HashSet<>();

      calculate(N, 1, number[0]);

      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;

      for (int num : result) {
        min = Math.min(min, num);
        max = Math.max(max, num);
      }

      bw.write("#" + t + " " + (max - min) + "\n");
    }

    bw.flush();
  }

  public static void calculate(int N, int idx, int prev) {
    if (idx == N) {
      result.add(prev);
      return;
    }

    for (int i = 0; i < operatorCnt.length; i++) {
      if (operatorCnt[i] == 0) {
        continue;
      }

      switch (i) {
        case 0: 
          operatorCnt[i]--;
          calculate(N, idx + 1, prev + number[idx]);
          operatorCnt[i]++;
          break;

        case 1: 
          operatorCnt[i]--;
          calculate(N, idx + 1, prev - number[idx]); 
          operatorCnt[i]++;
          break;

        case 2: 
          operatorCnt[i]--;
          calculate(N, idx + 1, prev * number[idx]); 
          operatorCnt[i]++;
          break;

        case 3: 
          operatorCnt[i]--;
          calculate(N, idx + 1, prev / number[idx]); 
          operatorCnt[i]++;
          break;
      }
    }
  }
}
