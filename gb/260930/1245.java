/*
1245. [S/W 문제해결 응용] 2일차 - 균형점 (D5)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15MeBKAOgCFAYD&categoryId=AV15MeBKAOgCFAYD&categoryType=CODE&problemTitle=1245&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int N;
  public static int[] position;
  public static int[] mass;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      
      position = new int[N];
      mass = new int[N];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        position[i] = Integer.parseInt(st.nextToken());
      }
      for (int i = 0; i < N; i++) {
        mass[i] = Integer.parseInt(st.nextToken());
      }

      double[] answer = new double[N - 1];

      for (int i = 0; i < N - 1; i++) {
        answer[i] = find(position[i], position[i + 1]);
      }

      bw.write("#" + t);
      for (double a : answer) {
        bw.write(" " + String.format("%.10f", a));
      }
      bw.write("\n");
    }

    bw.flush();
  }

  public static double find(int startP, int endP) {
    double start = startP;
    double end = endP;

    while (true) {
      double mid = (start + end) / 2.0;

      double leftF = 0;
      double rightF = 0;

      for (int i = 0; i < N; i++) {
        double d = mid - position[i];
        double force = mass[i] / (d * d);

        // 왼쪽에 있음
        if (position[i] < mid) {
          leftF += force;
        } 
        // 오른쪽에 있음
        else {
          rightF += force;
        }
      }

      // 왼쪽 힘이 더 셈
      if (leftF > rightF) {
        start = mid;
      } 
      // 오른쪽 힘이 더 셈
      else {
        end = mid;
      }

      // 좌표값의 오차가 1e-12보다 작으면 리턴
      if (end - start < 1e-12) {
        return mid;
      }
    }
  }
}
