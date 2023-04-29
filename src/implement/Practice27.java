package implement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Practice27 {
	// 문자열 재정렬
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int num = 0;
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < n.length(); i++) {
			if(n.charAt(i) >= '0' && n.charAt(i) <= '9') 
				num += n.charAt(i) - '0';
			else
				list.add(n.charAt(i));
		}
		
		Collections.sort(list);
		String answer = "";
		for (Character character : list)
			answer += character;
		
		System.out.println(answer + num);
		
	}	// end of main

}	// end of class