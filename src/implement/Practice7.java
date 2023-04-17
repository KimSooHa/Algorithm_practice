package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice7 {
	// 검증수(백준 2475) 
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		int[] arr = new int[5];
		
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<5; i++) {
			answer += arr[i] * arr[i];
		}
		
		answer = answer % 10;
		System.out.println(answer);
	}	// end of main
	
}	// end of class