package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice83 {
	// ����� �ܾ�(���� 2607)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int[] alphabet = new int[26];
		
		for(int j=0; j<str.length(); j++) 
			alphabet[str.charAt(j)- 'A']++;
		
		for(int i=0; i<n-1; i++) {
			int[] word = alphabet.clone();
			String s = br.readLine();
			int cnt = 0;
			
			for(int j=0; j<s.length(); j++) {
				if(word[s.charAt(j)-'A'] > 0) {
					word[s.charAt(j)-'A']--;
					cnt++;
				}
			}
			
			// ���� ���ڿ� ���̿� �� ���ڿ� ���� ����
			// ���� ��� or �� ���ڸ� �ٲ� ���
			if(str.length() == s.length() && (str.length() == cnt || str.length() - 1 == cnt))
				answer++;
			// �� ���ڿ��� �� ª�� ���
			else if(str.length() == s.length() - 1 && s.length() - 1 == cnt)
				answer++;
			// �� ���ڿ��� �� �� ���
			else if(str.length() == s.length() + 1 && s.length() == cnt)
				answer++;
		}
		
		System.out.println(answer);
	} // end of main

} // end of class
