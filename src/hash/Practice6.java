package hash;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Practice6 {
	// 완주하지 못한 선수(프로그래머스 lv1)

	public static String solution(String[] participant, String[] completion) {

        String answer = "";
        
        Map<String, Integer> completionMap = new HashMap<>();
        
        for(int i=0; i<completion.length; i++) {
        	String key = completion[i];
        	
            // 해당 키(참가자)가 없으면 키와 함께 값 세팅, 있으면(동명이인) 다음 인덱스 값으로 삽입
            completionMap.put(key, completionMap.getOrDefault(key, 0) + 1);
        }
        
        for(String p : participant) {
        	// 완주자에 키값이 존재하지 않는다면 result는 p가 된다.
        	if(!completionMap.containsKey(p)) {
        		answer = p;
        		return answer;
        	}
        	// 완주자에 키값(참가자)이 존재하는 경우는 동명이인의 조건하에 완주자에서 -1을 해준다.
        	else {
        		int currentNum = completionMap.get(p);
        		completionMap.put(p, currentNum-1);
        	}
        }
        
        for(String key : completionMap.keySet()) {
            if(0 != completionMap.get(key))
                answer = key;
        }
        
        return answer;
    }
	
	public static void main(String[] args) throws IOException {
		
		// tc1
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] completion1 = {"eden", "kiki"};
		System.out.println(solution(participant1, completion1)); // leo

		// tc2
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(participant2, completion2)); // vinko
		
		// tc3
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion3 = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant3, completion3)); // mislav

	}	// end of main
}	// end of class
