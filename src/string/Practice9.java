package string;

import java.util.Arrays;

public class Practice9 {
	// 문자열 내림차순으로 배치하기 (프로그래머스) 
	    
	public static String solution(String s) {
        String answer = "";
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // 오름차순하면 아스키코드 기준 대문자가 먼저 오게 된다.
        
        answer = new StringBuilder(new String(chars)).reverse().toString();
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		
		String s = "Zbcdefg";
		
		String answer = solution(s);
		
		System.out.println(answer);

	}
}