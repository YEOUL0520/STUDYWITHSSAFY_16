/*
주어지는 영어 문장에서 특정한 문자열의 개수를 반환하는 프로그램을 작성하여라.
Starteatingwellwiththeseeighttipsforhealthyeating,whichcoverthebasicsofahealthydietandgoodnutrition.
위 문장에서 ti 를 검색하면, 답은 4이다.
[제약 사항]
총 10개의 테스트 케이스가 주어진다.
문장의 길이는 1000자를 넘어가지 않는다.
한 문장에서 검색하는 문자열의 길이는 최대 10을 넘지 않는다.
한 문장에서는 하나의 문자열만 검색한다.
[입력]
각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄에는 찾을 문자열, 그 다음 줄에는 검색할 문장이 주어진다.
1
ti
Starteatingwellwiththeseeighttipsforhealthyeating,whichcoverthebasics ...
2
ing
Thedoublehelixformsthestructuralbasisofsemi-conservativeDNAreplication.1,2Less ...
[출력]
#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 답을 출력한다.
#1 4
#2 2
*/

/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String target = br.readLine();
            // System.out.println("Target: " + target);
            String base = br.readLine();
            // System.out.println("Base: " + base);

            int count = 0;
            int index = 0;

            while ((index = base.indexOf(target, index)) != -1) {
                count++;
                index++;
            }

            System.out.println("#" + test_case + " " + count);
		}
	}
}