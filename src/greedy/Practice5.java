package greedy;

import java.util.Scanner;

public class Practice5 {
	// 문자열 뒤집기
	
	public static String str;
	public static int count0 = 0;	// 전부 0으로 바뀌는 경우
	public static int count1 = 0;	// 전부 1로 바뀌는 경우

	public static void main(String[] args) {
		// 1만 뒤집는 경우 / 0만 뒤집는 경우(연속된 숫자만 뒤집을 경우를 1번으로 친다)
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		
		// 첫 번째 원소에 대해서 처리
		if(str.charAt(0) == '1') count0++;
		else count1++;
		
		for(int i=1; i<str.length(); i++) {
			// 앞의 인덱스와 뒤의 인덱스의 숫자가 같지 않을 때
			if(str.charAt(i-1) != str.charAt(i)) {
				// 다음 수에서 1로 바뀌는 경우
				if(str.charAt(i) == '1') count0++;
				// 다음 수에서 0으로 바뀌는 경우
				else count1++;
			}
		}
		
		System.out.println(Math.min(count0,  count1));
	}	// end of main

}	// end of class
