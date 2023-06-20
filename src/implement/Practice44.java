package implement;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class Practice44 {
	// 영어 끝말잇기(프로그래머스 lv2)
	
	public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();
        int[] arr = new int[words.length];
        for(int i=0; i<words.length; i++) {
            arr[i] = i % n + 1;
            
            if(i != 0) {
                int length = words[i-1].length();
                if(set.contains(words[i]) || words[i-1].charAt(length-1) != words[i].charAt(0)) {
                    answer[0] = arr[i];
                    answer[1] = (i+1) % n != 0 ? (i+1) / n + 1 : (i+1) / n;
                    return answer;
                }    
            }
            
            set.add(words[i]);
        }

        return answer;
    }
	
	public static void main(String args[]) throws IOException {
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] result = solution(n, words);
		System.out.print("[");
		System.out.print(result[0] + ", ");
		System.out.print(result[1]);			
		System.out.print("]");
		
	} // end of main

}	// end of class