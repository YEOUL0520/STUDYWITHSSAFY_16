import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int dump = sc.nextInt();
			int[] arr = new int[100];
			
			for(int i = 0; i< 100; i++) {
				arr[i] = sc.nextInt();
			}
			
			int maxIdx = 0;
			int minIdx = 0;
			
			for(int d = 0; d<dump; d++) {
				
				maxIdx = 0;
				minIdx = 0;
				
				for(int i = 0; i<100; i++) {
					if(arr[i]< arr[minIdx]) { minIdx = i; }
					if(arr[i]> arr[maxIdx]) { maxIdx = i; }
				}
				
				arr[maxIdx]--;
				arr[minIdx]++;
			}
			
			maxIdx = 0;
			minIdx = 0;

			for(int i = 0; i < 100; i++) {
			    if(arr[i] < arr[minIdx]) minIdx = i;
			    if(arr[i] > arr[maxIdx]) maxIdx = i;
			}
			
			System.out.println("#"+test_case+" "+(arr[maxIdx] - arr[minIdx]));
		}
	}

}
