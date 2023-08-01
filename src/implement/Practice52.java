package implement;

import java.util.Stack;

public class Practice52 {
	// 괄호 회전하기(프로그래머스 lv2)
	
	public static int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	answer += (check(s)) ? 1 : 0;
        	s = s.substring(1, s.length()) + s.substring(0, 1);
        }
        
        return answer;
    }

	// 올바른 괄호 문자열인지 체크
	public static boolean check(String s) {
		Stack<Character> ch = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
				ch.push(s.charAt(i));
			else { // 스택이 비어있지 않다면
				if(!ch.isEmpty()) {
					char c = ch.pop();
					char str = s.charAt(i);
					
					// 올바른 괄호로 짝이 맞는지 확인(가장 최근에 넣은 괄호와 현재 괄호가 같아야 함)
					if(c == '(' && str == ')') continue;
					else if(c == '{' && str == '}') continue;
					else if(c == '[' && str == ']') continue;
					else return false;
				}
				return false;
			}
		}
		// 스택이 비어있다면 올바른 괄호
		if(ch.isEmpty()) return true;
		
		return false;		
	}

	public static void main(String[] args) {
		String s = "[](){}";
		System.out.println(solution(s));
	} // end of main

} // end of class
