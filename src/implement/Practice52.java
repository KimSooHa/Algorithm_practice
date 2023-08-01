package implement;

import java.util.Stack;

public class Practice52 {
	// ��ȣ ȸ���ϱ�(���α׷��ӽ� lv2)
	
	public static int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	answer += (check(s)) ? 1 : 0;
        	s = s.substring(1, s.length()) + s.substring(0, 1);
        }
        
        return answer;
    }

	// �ùٸ� ��ȣ ���ڿ����� üũ
	public static boolean check(String s) {
		Stack<Character> ch = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
				ch.push(s.charAt(i));
			else { // ������ ������� �ʴٸ�
				if(!ch.isEmpty()) {
					char c = ch.pop();
					char str = s.charAt(i);
					
					// �ùٸ� ��ȣ�� ¦�� �´��� Ȯ��(���� �ֱٿ� ���� ��ȣ�� ���� ��ȣ�� ���ƾ� ��)
					if(c == '(' && str == ')') continue;
					else if(c == '{' && str == '}') continue;
					else if(c == '[' && str == ']') continue;
					else return false;
				}
				return false;
			}
		}
		// ������ ����ִٸ� �ùٸ� ��ȣ
		if(ch.isEmpty()) return true;
		
		return false;		
	}

	public static void main(String[] args) {
		String s = "[](){}";
		System.out.println(solution(s));
	} // end of main

} // end of class
