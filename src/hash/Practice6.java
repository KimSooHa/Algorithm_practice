package hash;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Practice6 {
	// �������� ���� ����(���α׷��ӽ� lv1)

	public static String solution(String[] participant, String[] completion) {

        String answer = "";
        
        Map<String, Integer> completionMap = new HashMap<>();
        
        for(int i=0; i<completion.length; i++) {
        	String key = completion[i];
        	
            // �ش� Ű(������)�� ������ Ű�� �Բ� �� ����, ������(��������) ���� �ε��� ������ ����
            completionMap.put(key, completionMap.getOrDefault(key, 0) + 1);
        }
        
        for(String p : participant) {
        	// �����ڿ� Ű���� �������� �ʴ´ٸ� result�� p�� �ȴ�.
        	if(!completionMap.containsKey(p)) {
        		answer = p;
        		return answer;
        	}
        	// �����ڿ� Ű��(������)�� �����ϴ� ���� ���������� �����Ͽ� �����ڿ��� -1�� ���ش�.
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
