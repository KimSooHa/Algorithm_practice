package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice83 {
	// 비슷한 단어(백준 2607)

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
			
			// 기준 문자열 길이와 비교 문자열 길이 차이
			// 같은 경우 or 한 글자만 바뀐 경우
			if(str.length() == s.length() && (str.length() == cnt || str.length() - 1 == cnt))
				answer++;
			// 비교 문자열이 더 짧은 경우
			else if(str.length() == s.length() - 1 && s.length() - 1 == cnt)
				answer++;
			// 비교 문자열이 더 긴 경우
			else if(str.length() == s.length() + 1 && s.length() == cnt)
				answer++;
		}
		
		System.out.println(answer);
	} // end of main

} // end of class
