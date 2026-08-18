/*
7194. 화섭이의 미생물 배양 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWksRe4KARQDFAVE&categoryId=AWksRe4KARQDFAVE&categoryType=CODE&problemTitle=7194&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int s;
  public static int a;
  public static int b;
  public static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    
    for (int test = 1; test <= T; test++) {
      st = new StringTokenizer(br.readLine());
      s = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      a = Integer.parseInt(st.nextToken());  // +a
      b = Integer.parseInt(st.nextToken());  // *b

      answer = Integer.MAX_VALUE;

      dfs(t, 0);

      bw.write("#" + test + " " + (answer != Integer.MAX_VALUE ? answer : "-1") + "\n");
    }

    bw.flush();
  }

  public static void dfs(int num, int cnt) {
    if (num < s || cnt >= answer) {
      return;
    }
    
    if (num == s) {
      answer = Math.min(answer, cnt);
      return;
    }

    // a로 나누어 떨어지면 -a만 사용
    if ((num - s) % a == 0) {
      answer = Math.min(answer, cnt + ((num - s) / a));
    }

    // b가 1이면 곱해도 아무 변화 없음
    if (b == 1) {
      return;
    }

    // num에서 -a를 해서 b의 배수가 되면 들어가기
    int remainder = num % b;  // b 나누기 하고 남은 값
    int need = 0;             // b의 배수가 되기 위해 num에서 빼야 하는 값

    if (remainder != 0) {
      need = b - remainder;
    }

    // 빼야 하는 값이 a의 배수가 아니면 불가능
    if (need % a != 0) {
      return;
    }

    int aCnt = need / a;
    int next = num - aCnt * a;  // a를 빼서 b의 배수로 만든 결과값

    // a를 뺀 후 b로 나눌 수 있으면 다음 단계로 이동
    if (next >= s && next % b == 0) {
      dfs(next / b, cnt + aCnt + 1);
    }
  }
}