/*
1244. [S/W 문제해결 응용] 2일차 - 최대 상금 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15Khn6AN0CFAYD&categoryId=AV15Khn6AN0CFAYD&categoryType=CODE&problemTitle=1244&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1

*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[] arr;
  public static int max;
  public static ArrayList<ArrayList<Integer>> visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      String input = st.nextToken();
      int cnt = Integer.parseInt(st.nextToken());

      arr = new int[input.length()];
      for (int i = 0; i < input.length(); i++) {
        arr[i] = input.charAt(i) - '0';
      }

      max = 0;
      visited = new ArrayList<>();
      for (int i = 0; i <= cnt; i++) {
        visited.add(new ArrayList<>());
      }

      combination(cnt);

      bw.write("#" + t + " " + max + "\n");
    }

    bw.flush();
  }

  public static void combination(int cnt) {
    int result = 0;
    int d = 1;

    for (int i = arr.length - 1; i >= 0; i--) {
      result += arr[i] * d;
      d *= 10;
    }

    // 방문 체크
    if (visited.get(cnt).contains(result)) {
      return;
    }

    visited.get(cnt).add(result);

    // 모든 변경 횟수 썼으면 최대값 갱신하고 종료
    if (cnt == 0) {
      max = Math.max(max, result);
      return;
    }

    // 다음 변경 만들기
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        swap(i, j);
        combination(cnt - 1);
        swap(i, j);
      }
    }
  }

  public static void swap(int n1, int n2) {
    int temp = arr[n1];
    arr[n1] = arr[n2];
    arr[n2] = temp;
  }
}
