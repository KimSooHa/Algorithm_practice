package implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice67 {
	// [3��]����(���α׷��ӽ� lv2)

	public static int[] solution(String msg) {
        
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        // A~Z���� ������ ���
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

            // ���� ������ ���ٸ� ������ ����ϱ� �׸��� ���� ���� or ���ڿ� �ε��� �� ���,
            // ���� ���� or ���ڿ� ������ ���ڿ��� �ٽ� ����
            if(!map.containsKey(subStr)) {
                map.put(subStr, map.size()+1);
                list.add(map.get(str.substring(0, i)));
                simulation(map, list, str.substring(i));
                break;
            }
            // ���� ���� ���ڰ� �������̶�� ������ ���� �ε��� ����ϱ�
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
