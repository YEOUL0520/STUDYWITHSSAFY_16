/*
9280. 진용이네 주차타워 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW9j74FacD0DFAUY&categoryId=AW9j74FacD0DFAUY&categoryType=CODE&problemTitle=9280&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int[] R = new int[N]; // 주차 공간의 단위 무게당 요금
      int[] W = new int[M]; // 차량의 무게
      
      for (int n = 0; n < N; n++) {
        R[n] = Integer.parseInt(br.readLine());
      }

      for (int m = 0; m < M; m++) {
        W[m] = Integer.parseInt(br.readLine());
      }

      int answer = 0;
      int[] park = new int[N];
      ArrayDeque<Integer> waiting = new ArrayDeque<>();

      for (int i = 0; i < 2 * M; i++) {
        int carNum = Integer.parseInt(br.readLine());

        if (carNum < 0) {
          carNum = Math.abs(carNum);

          // 돈 계산
          for (int n = 0; n < N; n++) {
            if (park[n] == carNum) {
              answer += W[carNum - 1] * R[n];

              // 대기 있으면 빠진 자리에 바로 넣기
              if (!waiting.isEmpty()) {
                park[n] = waiting.pollFirst();
              } else {
                park[n] = 0;
              }

              break;
            }
          }
        } else {
          boolean successPark = false;

          // 번호가 가장 작은 공간에 주차
          for (int n = 0; n < N; n++) {
            if (park[n] == 0) {
              park[n] = carNum;
              successPark = true;
              break;
            }
          }

          // 주차 공간 없으면 대기
          if (!successPark) {
            waiting.addLast(carNum);
          }
        }
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }
}