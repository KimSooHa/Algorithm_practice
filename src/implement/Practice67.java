package implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice67 {
	// [3차]압축(프로그래머스 lv2)

	public static int[] solution(String msg) {
        
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        // A~Z까지 사전에 등록
        for(int i=0; i<26; i++) 
            map.put(String.valueOf((char)('A'+i)), i+1);
        
        simulation(map, list, msg);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) 
            answer[i] = list.get(i);
        
        return answer;
    }
    
    private static void simulation(Map<String, Integer> map, List<Integer> list, String str) {
        
        for(int i=0; i<str.length(); i++) {
            String subStr = str.substring(0, i+1);

            // 만약 사전에 없다면 사전에 등록하기 그리고 현재 문자 or 문자열 인덱스 값 출력,
            // 현재 문자 or 문자열 다음의 문자에서 다시 시작
            if(!map.containsKey(subStr)) {
                map.put(subStr, map.size()+1);
                list.add(map.get(str.substring(0, i)));
                simulation(map, list, str.substring(i));
                break;
            }
            // 만약 현재 문자가 마지막이라면 마지막 문자 인덱스 출력하기
            else if(i+1 == str.length())
                list.add(map.get(str.substring(0, i+1)));
        }
    }

	public static void main(String[] args) {

		// ex1
		String msg1 = "KAKAO";
		int[] answer1 = solution(msg1);
		for(int a : answer1)
			System.out.println(a);
		
		System.out.println("=====");
		
		// ex2
		String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
		int[] answer2 = solution(msg2);
		for(int a : answer2)
			System.out.println(a);
		
		System.out.println("=====");
		
		// ex3
		String msg3 = "ABABABABABABABAB";
		int[] answer3 = solution(msg3);
		for(int a : answer3)
			System.out.println(a);

	} // end of main

} // end of class
