package implement;

import java.io.IOException;
import java.util.Scanner;

public class Practice2 {
	// 럭키 스트레이트
	// 주어진 점수가 특정 조건(자릿수를 기준으로 점수 N을 반으로 나누어 왼쪽부분의 각 자릿수의 합 = 오른쪽 부분의 자릿수의 합)에 부합하면 럭키 스트레이트 기술 사용가능		
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		int result = 0;
		
		for(int i=0; i<input.length()/2; i++) 	
			result += input.charAt(i) - '0';
			
		for(int i=input.length()/2; i<input.length(); i++)
			result -= input.charAt(i) - '0';
		
		// 럭키 스트레이트 가능(input을 반으로 나눈 각 자릿수의 합이 양쪽이 똑같은 경우)
		if(result == 0)
			System.out.println("LUCKY");
		else	// 럭키 스트레이트 불가능
			System.out.println("READY");
	}	// end of main

}	// end of class

