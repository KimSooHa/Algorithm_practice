package implement;

import java.util.TreeSet;

public class Practice79 {
	// ������ ���ĺ�(���α׷��ӽ� pccp ���ǰ�� 1ȸ)

	public static String solution(String input_string) {
        String answer = "";
        
        int[] ch = new int[26];
        ch[input_string.charAt(0) - 'a']++;
        TreeSet<Character> set = new TreeSet<>(); // ����Ʈ���� ���ĵǾ� ����Ǵ� set
        
        for(int i=1; i<input_string.length(); i++) {
            char c = input_string.charAt(i);
            if(ch[c - 'a'] != 0 && input_string.charAt(i-1) != c) 
                set.add(c);
            
            ch[c - 'a']++;
        }
        
        if(set.size() == 0)
            return "N";
        
        for(char c : set)
            answer += c;
        
        return answer;
    }
	
	public static void main(String[] args) {
		String input_string = "edeaaabbccd";
		System.out.println(solution(input_string));
		
		input_string = "eeddee";
		System.out.println(solution(input_string));
		
		input_string = "string";
		System.out.println(solution(input_string));
		
		input_string = "zbzbz";
		System.out.println(solution(input_string));

	} // end of main

} // end of class
