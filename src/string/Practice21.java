package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice21 {
	// 문자열 게임 (백준 20437)
	
	static int t, k;
	static String w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
		
			w = br.readLine();
			k = Integer.parseInt(br.readLine());
			// end of input
			
			// k가 1이라면 최댓값, 최솟값 모두 1
			if(k == 1) {
				System.out.println("1 1");
				continue;
			}
			
			// 알파벳 별 개수(K개 이하인 문자는 탐색에서 제외하기 위함)
			int[] alphabet = new int[26];
			for(int i=0; i<w.length(); i++)
				alphabet[w.charAt(i) - 'a']++;
				
			int min = Integer.MAX_VALUE;
			int max = -1;
			
			for (int i = 0; i < w.length(); i++) {
				if(alphabet[w.charAt(i) - 'a'] < k) continue;
				
				int cnt = 1;
				char c = w.charAt(i);
				
				// 뒷 문자열과 비교하여 같은 문자의 개수를 세어주고, 같은 문자의 수가 k개가 되는 순간 min, max 값 갱신
				for(int j = i+1; j<w.length(); j++) {
					if(c == w.charAt(j)) cnt++;
					
					if(cnt == k) { 
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1); // max는 첫번쨰와 마지막 글자가 같은 가장 긴 연속 문자열의 길이이므로 k 이상 되는 순간 탐색할 필요가 없음
						break;
					}			
				}			
			}
		
			if(min == Integer.MAX_VALUE || max == -1) System.out.println(-1);
			else 
				System.out.println(min + " " + max);
		}
	} // end of main
} // end of class