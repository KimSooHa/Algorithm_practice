package greedy;

import java.util.Scanner;

public class Practice2 {
	// 곱하기 혹은 더하기
	// 곱하기와 더하기를 넣어서 만들어질 수 있는 가장 큰 수 만들기(연산은 왼쪽에서 순서대로)

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		// 문자열 첫번째 숫자
		long result = str.charAt(0) - '0';
		
		for(int i=1; i<str.length(); i++) {
			// i번째 문자열 숫자로 뽑기
			int num = str.charAt(i) - '0';
			// 숫자가 1이하이거나 현재 result가 0이면
			if(num <= 1 || result == 0)
				result += num;	// 더하기
			else
				result *= num;	// 곱하기
		}

		System.out.println(result);
		
	}	// end of main

}	// end of class
