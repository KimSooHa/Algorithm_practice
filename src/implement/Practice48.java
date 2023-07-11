package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice48 {
	// 가르침(백준 1062)
	static StringTokenizer st;
	static int n, k;
	static int answer = 0;
	static String[] words;
	static boolean[] alphaArr = new boolean[26];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		words = new String[n];
		
        for (int i = 0; i < n; i++) 
        	words[i] = br.readLine();
        
        // k가 5 미만인 경우에는 모든 단어를 완성할 수 없으므로 0 출력
        if(k < 5) {
        	System.out.println(answer);
        	return;
        }
        
        // anta, tica에 들어가는 5개의 알파벳은 항상 사용되므로 true로 처리
        alphaArr['a' - 'a'] = true;
        alphaArr['n' - 'a'] = true;
        alphaArr['t' - 'a'] = true;
        alphaArr['i' - 'a'] = true;
        alphaArr['c' - 'a'] = true;
        
        dfs(0, 0);
        
		System.out.println(answer);
	} // end of main
	
	// 학생들에게 가르칠 k개의 알파벳의 조합 구하기
	public static void dfs(int idx, int cnt) {
		
		// 학생들이 k개의 알파벳을 배웠으므로 읽을 수 있는 단어의 갯수 구하기
		if(cnt + 5 == k) {
			countWord();
			return;
		}
			
		for (int i = idx; i < 26; i++) {
			if(alphaArr[i])
				continue;
			
			alphaArr[i] = true;
			dfs(i+1, cnt+1);
			alphaArr[i] = false;
		}
	}

	// 학생들이 읽을 수 있는 단어의 갯수 구하기
	public static void countWord() {
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			char[] word = words[i].toCharArray();
			boolean flag = true;
			
			for(char c : word) {
				if(!alphaArr[c - 'a']) {
					flag = false;
					break;
				}
			}
			
			if(flag)
				cnt++;
		}
		answer = Math.max(cnt, answer);
		
	}
} // end of class
