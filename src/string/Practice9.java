package string;

import java.util.Arrays;

public class Practice9 {
	// ���ڿ� ������������ ��ġ�ϱ� (���α׷��ӽ�) 
	    
	public static String solution(String s) {
        String answer = "";
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // ���������ϸ� �ƽ�Ű�ڵ� ���� �빮�ڰ� ���� ���� �ȴ�.
        
        answer = new StringBuilder(new String(chars)).reverse().toString();
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		
		String s = "Zbcdefg";
		
		String answer = solution(s);
		
		System.out.println(answer);

	}
}