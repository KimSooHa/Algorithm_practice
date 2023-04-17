package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice9 {
	// 단어 공부(백준 1157) 
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[26]; // 영문자 개수 
		char[] chars = br.readLine().toCharArray();

		for(int i=0; i<chars.length; i++) {
			if('A'<=chars[i] && chars[i] <= 'Z') // 대문자 범위 
				arr[chars[i] - 'A']++;	// 해당 인덱스의 값 1 증가 
			else
				arr[chars[i] - 'a']++;	// 소문자 범위 
		}
		
		int max = -1;
		int answer = -2;
		int ascii = 'A';
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				answer = i;
			}
			else if(arr[i] == max)
				answer = '?' - ascii;
		}
		System.out.println((char)(answer+ascii));
		
	}	// end of main
	
}	// end of class