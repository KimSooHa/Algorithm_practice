package implement;

import java.io.IOException;
import java.util.Scanner;

public class Practice24 {
	// 3진법 뒤집기(프로그래머스 - 월간코드 챌린지 시즌1)
	
	public static int solution(int n) {
        //10진법 -> 3진법
        String ternary = Integer.toString(n, 3);
        StringBuffer sb = new StringBuffer(ternary);
        // 앞뒤로 뒤집기
        ternary = sb.reverse().toString();
        // 뒤집은 값을 다시 10진법으로 변환
        return Integer.parseInt(ternary, 3);
    }	
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));	
	}	// end of main

}	// end of class