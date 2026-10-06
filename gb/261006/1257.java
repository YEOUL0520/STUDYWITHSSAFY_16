/*
1257. [S/W 문제해결 응용] 6일차 - K번째 문자열 (D6)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18KWf6ItECFAZN&categoryId=AV18KWf6ItECFAZN&categoryType=CODE&problemTitle=1257&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int K = Integer.parseInt(br.readLine());
      String input = br.readLine();
      HashSet<String> set = new HashSet<>();

      for (int s = 0; s < input.length(); s++) {
        for (int e = s; e < input.length(); e++) {
          set.add(input.substring(s, e + 1));
        }
      }

      ArrayList<String> list = new ArrayList<>();

      for (String w : set) {
        list.add(w);
      }

      String answer = "none";

      Collections.sort(list);

      if (list.size() > K) {
        answer = list.get(K - 1);
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }
}
