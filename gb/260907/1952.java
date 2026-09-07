/*
1952. [모의 SW 역량테스트] 수영장
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq&categoryId=AV5PpFQaAQMDFAUq&categoryType=CODE&problemTitle=1952&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[] price;
  public static int[] month;
  public static int answer;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      price = new int[4];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < price.length; i++) {
        price[i] = Integer.parseInt(st.nextToken());
      }

      month = new int[12];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < month.length; i++) {
        month[i] = Integer.parseInt(st.nextToken());
      }

      answer = price[3]; // 1년 이용권 요금으로 초기화

      calculate(0, 0);

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }

  public static void calculate(int idx, int money) {
    if (idx >= 12) {
      answer = Math.min(answer, money);
      return;
    }

    // 1일 이용권
    calculate(idx + 1, money + (month[idx] * price[0]));

    // 1달 이용권
    calculate(idx + 1, money + price[1]);

    // 3달 이용권
    calculate(idx + 3, money + price[2]);
  }
}
