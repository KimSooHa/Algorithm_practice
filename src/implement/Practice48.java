package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice48 {
	// ����ħ(���� 1062)
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
        
        // k�� 5 �̸��� ��쿡�� ��� �ܾ �ϼ��� �� �����Ƿ� 0 ���
        if(k < 5) {
        	System.out.println(answer);
        	return;
        }
        
        // anta, tica�� ���� 5���� ���ĺ��� �׻� ���ǹǷ� true�� ó��
        alphaArr['a' - 'a'] = true;
        alphaArr['n' - 'a'] = true;
        alphaArr['t' - 'a'] = true;
        alphaArr['i' - 'a'] = true;
        alphaArr['c' - 'a'] = true;
        
        dfs(0, 0);
        
		System.out.println(answer);
	} // end of main
	
	// �л��鿡�� ����ĥ k���� ���ĺ��� ���� ���ϱ�
	public static void dfs(int idx, int cnt) {
		
		// �л����� k���� ���ĺ��� ������Ƿ� ���� �� �ִ� �ܾ��� ���� ���ϱ�
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

	// �л����� ���� �� �ִ� �ܾ��� ���� ���ϱ�
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
