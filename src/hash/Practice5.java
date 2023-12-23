package hash;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Practice5 {
	// 롤케이크 자르기(프로그래머스 lv2)

	public static int solution(int[] topping) {
        int answer = 0;
        
        if(topping.length == 1)
            return answer;
        
        Set<Integer> old = new HashSet<>();
        Set<Integer> young = new HashSet<>();
        
        int idx = 1;
        old.add(topping[0]);
        
        for(int i=idx; i<topping.length; i++) 
            young.add(topping[i]);
        
        while(idx < topping.length-1) {
            if(old.size() == young.size())
                answer++;
            
            int num = topping[idx];
            old.add(num);
            idx++;
            
            boolean isContain = false;
            for(int i=idx; i<topping.length; i++) {
                if(topping[i] == num) {
                    isContain = true;
                    break;
                }
            }
            
            if(!isContain)
                young.remove(num);
        }
        
        return answer;
    }
	
	public static void main(String[] args) throws IOException {
		
		// tc1
		int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
		System.out.println(solution(topping1));

		// tc2
		int[] topping2 = {1, 2, 3, 1, 4};
		System.out.println(solution(topping2));

	}	// end of main

}	// end of class
