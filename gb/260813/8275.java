/*
8275. 햄스터 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWxQ310aOlQDFAWL&categoryId=AWxQ310aOlQDFAWL&categoryType=CODE&problemTitle=8275&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int N;
  public static int X;
  public static int[] cages;
  public static Record[] records;
  public static int[] answer;
  public static boolean hasAnswer;

  public static class Record {
    int start;
    int end;
    int cnt;

    public Record(int start, int end, int cnt) {
      this.start = start;
      this.end = end;
      this.cnt = cnt;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken()); // 햄스터 우리 개수
      X = Integer.parseInt(st.nextToken()); // 하나의 우리에 들어가는 햄스터 최대 값
      int M = Integer.parseInt(st.nextToken()); // 기록 개수

      cages = new int[N + 1];  // 1번부터 N번 우리
      records = new Record[M];
      answer = new int[N + 1];

      for (int m = 0; m < M; m++) { // l번부터 r번 우리까지의 햄스터 수 s마리
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        records[m] = new Record(l, r, s);
      }

      hasAnswer = false;
      setHamster(1);

      // 가능한 배치가 없으면 -1 출력
      bw.write("#" + t + " ");

      if (!hasAnswer) {
        bw.write("-1");
      } else {
        for (int i = 1; i <= N; i++) {
          bw.write(answer[i] + " ");
        }
      }

      bw.write("\n");
    }

    bw.flush();
  }

  /* 햄스터 배치 */
  public static void setHamster(int idx) {
    if (idx > N) {  // 마지막 우리까지 햄스터를 채웠으면 검사
      if (isCorrect() && isUpdate()) {  // 기록 만족하고 정답 갱신해야하면 갱신
        hasAnswer = true;
        answer = cages.clone();
      }
      return;
    }
    
    for (int x = X; x >= 0; x--) {
      cages[idx] = x;
      setHamster(idx + 1);
    }
  }

  /* 현재 배치가 기록을 만족하는지 검사 */
  public static boolean isCorrect() {
    for (int m = 0; m < records.length; m++) {
      int sum = 0;  // 기록 구간 내 햄스터 총합

      for (int i = records[m].start; i <= records[m].end; i++) {
        sum += cages[i];
      }

      if (sum != records[m].cnt) {
        return false;
      }
    }

    return true;
  }

  /* 현재 배치로 정답을 갱신할지 검사 (우선순위: 총합 많은 순, 오름차순 배열 순) */
  public static boolean isUpdate() {
    // 처음으로 찾은 배치면 바로 넣기
    if (!hasAnswer) {
      return true;
    }

    // 총합 많은지 확인
    int originSum = 0;
    int newSum = 0;
    
    for (int i = 1; i <= N; i++) {
      originSum += answer[i];
      newSum += cages[i];
    }

    if (originSum > newSum) {
      return false;
    }

    // 오름차순에서 더 빠른 순서인지 확인 (값이 더 작아야 더 빠른 순서임)
    for (int i = 1; i <= N; i++) {
      if (answer[i] != cages[i]) {
        return answer[i] > cages[i];
      }
    }

    return false;
  }
}
