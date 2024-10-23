import java.io.*;
import java.util.*;
public class Main {
	static int n, k, p, x; // n: 층수, k: 자리수, p: 반전가능 갯수, x: 현재 층수
	static int[][] display = { // 각 숫자를 디스플레이로 표현
								{1, 1, 1, 0, 1, 1, 1}, // 0
								{0, 0, 1, 0, 0, 0, 1}, // 1
								{0, 1, 1, 1, 1, 1, 0}, // 2
								{0, 1, 1, 1, 0, 1, 1}, // 3
								{1, 0, 1, 1, 0, 0, 1}, // 4
								{1, 1, 0, 1, 0, 1, 1}, // 5
								{1, 1, 0, 1, 1, 1, 1}, // 6
								{0, 1, 1, 0, 0, 0, 1}, // 7
								{1, 1, 1, 1, 1, 1, 1}, // 8
								{1, 1, 1, 1, 0, 1, 1} // 9
							};
	
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		// 현재 층수를 디스플레이 정보로 변환
		int[] digit = getDigit(x);
		check(digit);
		System.out.println(cnt);
	} // end of main

	// 각 층수를 늘려가면서 반전가능한 숫자인지 체크하고 갯수 세기
	public static void check(int[] digit) {
		for(int i=1; i<=n; i++) {
			if(i == x) // 현재 층수는 제외
				continue;
			if(canReverse(i, digit)) 
				cnt++;
		}
	}

	public static boolean canReverse(int target, int[] digit) {
		int[] targetDigit = getDigit(target);
		
		int cnt = 0;
		for(int i=0; i<k; i++) { // k : 자리수
			for(int j=0; j<7; j++) { // LED 갯수만큼 인덱스 반복
				// 현재 층수와 비교하는 층수 led 비교
				if(display[digit[i]][j] != display[targetDigit[i]][j]) // led가 일치하지 않으면 cnt++ 
					cnt++;
				if(cnt > p) // 반전가능 갯수를 넘으면 false 반환
					return false;
			}
		}
		
		return true;
	}

	public static int[] getDigit(int x) {
		int[] digit = new int[k];
		for(int i=k-1; i>=0; i--) {
			digit[i] = x % 10;
			x /= 10;
		}
		return digit;
	}
} // end of class