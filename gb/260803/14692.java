/*
14692. 통나무 자르기 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AYJW0g-qlO8DFASv&categoryId=AYJW0g-qlO8DFASv&categoryType=CODE&problemTitle=14692&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      String winner = (N % 2 == 0) ? "Alice" : "Bob"; // 홀수면 Bob, 짝수면 Alice가 이김
      bw.write("#" + t + " " + winner + "\n");
    }

    bw.flush();
  }
}
