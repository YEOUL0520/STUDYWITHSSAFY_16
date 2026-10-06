/*
영어 소문자로 된 문자열이 있다.
이 문자열의 부분문자열은 문자열의 두 위치를 골라서, 이 사이의 연속한 문자열을 뽑아낸 것이다.
두 위치가 같을 때는 길이가 1인 부분 문자열이 된다.
예를 들어, 문자열 love의 모든 부분 문자열은 l, o, v, e, lo,ov, ve, lov, ove, love이다.
또 다른 예로, 문자열 food의 부분 문자열은 f, o, d, fo, oo,od, foo, ood, food가 있다. 동일한 문자열 o가 두번 나오지만, 중복을 제거한 것에 유의하자.
이 문자열에 대해서 사전 순서로 정렬을 하는 것을 고려해보자.
두 문자열을 왼쪽부터 오른쪽으로 비교해나가면서, 처음으로 다른 글자가 나왔을 때 알파벳 순으로 먼저 나오는 문자가 있는 쪽이 순서가 앞이다.
다른 글자가 나오기 전에 한 문자열이 끝난다면 이 문자열이 순서가 앞이다.
문자열과 정수 K가 주어지고, 이 문자열의 부분 문자열들을 사전 순서대로 나열하였을 때 K번째에 오는 문자열을 출력하는 프로그램을 작성하시오.
*/
import java.io.*;
import java.util.*;

class Solution
{
    static Set<String> set;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            TreeSet<String> set = new TreeSet<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    set.add(s.substring(i, j));
                }
            }
            
            List<String> list = new LinkedList<>(set);
            
            if (k < 0 || k > list.size())
                System.out.println("#" + test_case + " " + "none");
            else
                System.out.println("#" + test_case + " " + list.get(k - 1));
		}
	}
}