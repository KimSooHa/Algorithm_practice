package implement;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Practice26 {
	// 럭키 스트레이트
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = 0;
		int length = (int)(Math.log10(n))+1;
		for(int i=0; i<length; i++) {
			if(i >= length/2)
				num -= n % 10;
			else
				num += n % 10;
			
			n /= 10;
		}
		
		if(num == 0)
			System.out.println("LUCKY");
		else
			System.out.println("READY");
		
	}	// end of main

}	// end of class