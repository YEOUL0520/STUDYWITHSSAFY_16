import java.util.*;
import java.io.*;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
         
        //시간 최적화를 위해 BufferedReader 사용법 익힐것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
         
            //이거 이케까지 번거로워지는거 맞나..? 쩝..
            String input2 = br.readLine();
            StringTokenizer st = new StringTokenizer(input2);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
             
            String input3 = br.readLine();
            StringTokenizer st3 = new StringTokenizer(input3);
             
            int[] people = new int[N];
            String answer = "Possible";
             
            for(int i = 0; i<N; i++) {
                people[i] = Integer.parseInt(st3.nextToken());
            }
             
            Arrays.sort(people);
             
            for(int i = 0; i<N; i++) {
                int made = (people[i] /M) * K; //이거 계산하는 걸 어떤 식으로 해야할지 고민했음.. 머리가 안돌아갔다
                if(made < i+1) {
                    answer = "Impossible";
                    break;
                }
            }
             
            System.out.println("#" + test_case + " " + answer);
 
        }
 
    }
 
}