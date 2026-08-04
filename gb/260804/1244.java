/*
1244. [S/W 문제해결 응용] 2일차 - 최대 상금 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15Khn6AN0CFAYD&categoryId=AV15Khn6AN0CFAYD&categoryType=CODE&problemTitle=1244&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[] arr;
  public static int answer;
  public static Set<String> visited = new HashSet<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      String numbers = st.nextToken();
      int cnt = Integer.parseInt(st.nextToken());
      answer = 0;

      arr = new int[numbers.length()];
      for (int i = 0; i < numbers.length(); i++) {
        arr[i] = numbers.charAt(i) - '0'; 
      }

      dfs(cnt);

      bw.write("#" + t + " " + answer + "\n");
    }
    
    bw.flush();
  }

  public static void dfs(int cnt) {
    String key = getArrInt() + "," + cnt;
    
    if (visited.contains(key)) {
      return;
    }

    visited.add(key);

    if (cnt == 0) {
      answer = Math.max(answer, getArrInt());
      return;
    }


    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (i == j) {
          continue;
        }

        swap(i, j);
        dfs(cnt - 1);
        swap(i, j);
      }
    }
  }

  public static void swap(int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static int getArrInt() {
    int money = 0;
    int d = 0;
    for (int i = arr.length - 1; i >= 0; i--) {
      money += arr[i] * Math.pow(10, d++);
    }
    return money;
  }
}
