package string;

import java.util.HashMap;
import java.util.Map;

public class Practice15 {
	// 숫자 문자열과 영단어 (프로그래머스) 
	    
	public static int solution(String s) {
        
		int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        String str = "";
        String n = "";
        
        for (int i = 0; i < s.length(); i++) {
        	if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
        		n += s.charAt(i);
        		continue;
        	}
        		
        	str += s.charAt(i);
			if(map.containsKey(str)) {
				n += map.get(str);
				str = "";
			}
		}
        
        answer = Integer.parseInt(n);
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		String s = "one4seveneight";
		
		System.out.println(solution(s));

	}
}