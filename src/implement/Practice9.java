package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice9 {
	// �ܾ� ����(���� 1157) 
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[26]; // ������ ���� 
		char[] chars = br.readLine().toCharArray();

		for(int i=0; i<chars.length; i++) {
			if('A'<=chars[i] && chars[i] <= 'Z') // �빮�� ���� 
				arr[chars[i] - 'A']++;	// �ش� �ε����� �� 1 ���� 
			else
				arr[chars[i] - 'a']++;	// �ҹ��� ���� 
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