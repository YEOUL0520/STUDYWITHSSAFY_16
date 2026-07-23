import java.util.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
 
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            sc.nextInt();
 
            int answer = 0;
 
            int value = 0;  // 얘 없애고
            int[] rowSum = new int[100];
            int[] colSum = new int[100];
            int diagSum1 = 0;
            int diagSum2 = 0;
 
            int maxRow = 0;
            int maxCol = 0;
 
            for(int i = 0; i<100; i++){
                for(int j = 0; j<100; j++){
                    value = sc.nextInt();   // 여기서 그냥 int로 받아도 되겟는데
                    rowSum[i] += value;
                    colSum[j] += value;
                    if(i == j){
                        diagSum1 += value;
                    }else if(i+j == 99){
                        diagSum2 += value;
                    }
                }
                if (rowSum[i]> maxRow) maxRow = rowSum[i];
            }
 
            for(int i = 0; i<100; i++){
                if (colSum[i]> maxCol) maxCol = colSum[i];
            }
 
            if(maxCol >= maxRow){
                answer = maxCol;
            }
            else if(maxRow > maxCol){
                answer = maxRow;
            }
 
            if(diagSum1 >= diagSum2){
                if(diagSum1 >= answer) answer = diagSum1;
            }
            else if(diagSum2 > diagSum1){
                if(diagSum2 >= answer) answer = diagSum2;
            }
             
            System.out.println("#" + test_case + " " + answer);
 
        }
    }
}