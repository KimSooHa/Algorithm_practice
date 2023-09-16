package implement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Practice59 {
	// 뉴스 클러스터링(프로그래머스 lv2)

	public static int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> map1 = new HashMap<>(); //str1
        Map<String, Integer> map2 = new HashMap<>(); //str2
        Set<String> set = new HashSet<>(); // 합집합
        int answer = 0;
        int total = 0;
        
        // str1
        for(int i=0; i<str1.length()-1; i++) {
            String temp = str1.substring(i, i+2);
            if(Character.isAlphabetic(temp.charAt(0)) && Character.isAlphabetic(temp.charAt(1))) { // 알파벳이면 추가
                set.add(temp);
                map1.put(temp, map1.getOrDefault(temp, 0) + 1);
            }
        }
        
        // str2
        for(int i=0; i<str2.length()-1; i++) {
            String temp = str2.substring(i, i+2);
            if(Character.isAlphabetic(temp.charAt(0)) && Character.isAlphabetic(temp.charAt(1))) {  // 알파벳이면 추가
                set.add(temp);
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
            }
        }
        
        for(String s : set) //합집합 구하기
            total += Math.max(map1.getOrDefault(s, 0) , map2.getOrDefault(s, 0));

        for(String s : map2.keySet()) //공집합 구하기
            if(map1.containsKey(s))
                answer += Math.min(map1.get(s), map2.get(s));
        
        if(total == 0)
            return 65536;
                
        return answer * 65536 / total;
    }
	
	public static void main(String[] args) {
		
		// ex1
		String str1 = "FRANCE";
		String str2 = "french";
		System.out.println(solution(str1, str2));

		// ex2
		str1 = "handshake";
		str2 = "shake hands";
		System.out.println(solution(str1, str2));
		
		// ex3
		str1 = "aa1+aa2";
		str2 = "AAAA12";
		System.out.println(solution(str1, str2));
		
		// ex4
		str1 = "E=M*C^2";
		str2 = "e=m*c^2";
		System.out.println(solution(str1, str2));
	} // end of main

} // end of class
