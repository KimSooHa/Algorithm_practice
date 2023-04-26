package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice20 {
	// �ð�
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int h = 0; h <= n; h++) {
			for (int m = 0; m < 60; m++) {
				for (int s = 0; s < 60; s++) {
					// �� �ð� �ȿ� '3'�� ���ԵǾ� �ִٸ� ī��Ʈ ����
					if(check(h, m, s)) cnt++;
				}
			}
		}
		System.out.println(cnt);
	}	// end of main

	// Ư���� �ð� �ȿ� '3'�� ���ԵǾ� �ִ����� ����
	public static boolean check(int h, int m, int s) {
		// h�� �ִ밪�� 23�̹Ƿ� 10�� �ڸ����� ���ʿ� ����
		if(h % 10 == 3 || m % 10 == 3 || m / 10 == 3 || s / 10 == 3 || s % 10 == 3)
			return true;
		
		return false;
	}
}	// end of class