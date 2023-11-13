package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice21 {
	// ���ڿ� ���� (���� 20437)
	
	static int t, k;
	static String w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
		
			w = br.readLine();
			k = Integer.parseInt(br.readLine());
			// end of input
			
			// k�� 1�̶�� �ִ�, �ּڰ� ��� 1
			if(k == 1) {
				System.out.println("1 1");
				continue;
			}
			
			// ���ĺ� �� ����(K�� ������ ���ڴ� Ž������ �����ϱ� ����)
			int[] alphabet = new int[26];
			for(int i=0; i<w.length(); i++)
				alphabet[w.charAt(i) - 'a']++;
				
			int min = Integer.MAX_VALUE;
			int max = -1;
			
			for (int i = 0; i < w.length(); i++) {
				if(alphabet[w.charAt(i) - 'a'] < k) continue;
				
				int cnt = 1;
				char c = w.charAt(i);
				
				// �� ���ڿ��� ���Ͽ� ���� ������ ������ �����ְ�, ���� ������ ���� k���� �Ǵ� ���� min, max �� ����
				for(int j = i+1; j<w.length(); j++) {
					if(c == w.charAt(j)) cnt++;
					
					if(cnt == k) { 
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1); // max�� ù������ ������ ���ڰ� ���� ���� �� ���� ���ڿ��� �����̹Ƿ� k �̻� �Ǵ� ���� Ž���� �ʿ䰡 ����
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