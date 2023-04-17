package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice8 {
	// 숫자의 개수(백준 2577) 
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		answer = A * B * C;
		
		int length = (int) (Math.log10(answer)+1);	// 자리수 구하기 
		int[] arr = new int[10];
		for(int i=0; i<length; i++) {
			int num = answer % 10;
			arr[num]++;
			answer /= 10;
		}
		
		for(int i=0; i<arr.length; i++) 
			System.out.println(arr[i]);
		
		
	}	// end of main
	
}	// end of class