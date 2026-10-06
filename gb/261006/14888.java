/*
14888. 연산자 끼워넣기
https://github.com/YEOUL0520/STUDYWITHSSAFY_16/discussions/223
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int max;
  public static int min;
  public static int N;
  public static int[] num;
  public static int[] cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
  
    N = Integer.parseInt(br.readLine());
    num = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    cnt = new int[4]; // +, -, *, /

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < cnt.length; i++) {
      cnt[i] = Integer.parseInt(st.nextToken());
    }

    max = Integer.MIN_VALUE;
    min = Integer.MAX_VALUE;

    permutation(1, num[0]);

    bw.write(max + "\n" + min);
    bw.flush();
  }

  public static void permutation(int idx, int result) {
    if (idx == N) {
      max = Math.max(max, result);
      min = Math.min(min, result);
      return;
    }

    for (int i = 0; i < cnt.length; i++) {
      if (cnt[i] == 0) {
        continue;
      }

      cnt[i]--;
      switch (i) {
        case 0: permutation(idx + 1, result + num[idx]); break;
        case 1: permutation(idx + 1, result - num[idx]); break;
        case 2: permutation(idx + 1, result * num[idx]); break;
        case 3: permutation(idx + 1, result / num[idx]); break;
      }
      cnt[i]++;
    }
  }
}
