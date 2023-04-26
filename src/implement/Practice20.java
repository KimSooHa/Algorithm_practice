package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice20 {
	// 시각
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int h = 0; h <= n; h++) {
			for (int m = 0; m < 60; m++) {
				for (int s = 0; s < 60; s++) {
					// 매 시각 안에 '3'이 포함되어 있다면 카운트 증가
					if(check(h, m, s)) cnt++;
				}
			}
		}
		System.out.println(cnt);
	}	// end of main

	// 특정한 시각 안에 '3'이 포함되어 있는지의 여부
	public static boolean check(int h, int m, int s) {
		// h은 최대값이 23이므로 10의 자리수는 알필요 없음
		if(h % 10 == 3 || m % 10 == 3 || m / 10 == 3 || s / 10 == 3 || s % 10 == 3)
			return true;
		
		return false;
	}
}	// end of class