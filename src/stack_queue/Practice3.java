package stack_queue;

import java.util.Stack;

public class Practice3 {
	// 짝지어 제거하기(프로그래머스 lv2)

	public static int solution(String s) {

        Stack<Character> stack = new Stack<>();
        int idx = 0;
        
        if(s.length() == 0)
        	return 0;
        
        stack.push(s.charAt(idx));
        idx++;
        
        while(idx < s.length()) {
           char c = s.charAt(idx);
           
           if(!stack.isEmpty() && stack.peek() == c)
        	   stack.pop();
           else
        	   stack.push(c);
           
           idx++;
        }

        return stack.isEmpty() ? 1 : 0;
    }

	public static void main(String[] args) {
		String s = "baabaa";
		System.out.println(solution(s));
	}	// end of main

}	// end of class
