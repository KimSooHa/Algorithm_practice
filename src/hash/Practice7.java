package hash;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Practice7 {
	// 완주하지 못한 선수(프로그래머스 lv1)

	public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<keymap.length; i++) {
            for(int j=0; j<keymap[i].length(); j++) {
                map.put(keymap[i].charAt(j), Math.min(j+1, map.getOrDefault(keymap[i].charAt(j), j+1)));
            }
        }
        
        for(int i=0; i<targets.length; i++) {
            int num = 0;
            for(int j=0; j<targets[i].length(); j++) {
                if(!map.containsKey(targets[i].charAt(j))) {
                    num = -1;
                    break;
                }
                num += map.get(targets[i].charAt(j));
            }
            answer[i] = num;
        }
        
        return answer;
    }
	
	public static void main(String[] args) throws IOException {
		
		// tc1
		String[] keymap1 = {"ABACD", "BCEFD"};
		String[] targets1 = {"ABCD", "AABB"};
		int[] result1 = solution(keymap1, targets1);
		for(int r : result1) 
			System.out.println(r); // [9, 4]

		System.out.println("--------------");
		// tc2
		String[] keymap2 = {"ABACD", "BCEFD"};
		String[] targets2 = {"ABCD", "DG", "AABB"};
		int[] result2 = solution(keymap2, targets2);
		for(int r : result2) 
			System.out.println(r); // [9, -1, 4]

		System.out.println("--------------");
		
		// tc3
		String[] keymap3 = {"AGZ", "BSSS"};
		String[] targets3 = {"ASA", "BGZ"};
		int[] result3 = solution(keymap3, targets3);
		for(int r : result3) 
			System.out.println(r); // [4, 6]

	}	// end of main
}	// end of class
