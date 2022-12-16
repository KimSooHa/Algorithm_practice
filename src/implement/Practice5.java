package implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice5 {
	// 문자열 재정렬
	
	public static String str;	// 입력받는 문자
	public static ArrayList<Character> result = new ArrayList<>();	// 문자 저장할 리스트 
	public static int value = 0;	// 따로 더하는 숫자
	
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isLetter(str.charAt(i)))	// 알파벳인 경우 리스트에 삽입
				result.add(str.charAt(i));
			else	// 숫자는 따로 더하기
				value += str.charAt(i) - '0';
		}
		
		// 알파벳 차례대로 정렬하기
		Collections.sort(result);
		
		// 알파벳을 차례대로 출력
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i));
		}
		
		// 숫자가 하나라도 존재하는 경우 가장 뒤에 출력 
		if(value != 0)
			System.out.print(value);
	}	// end of main
	
}	// end of class