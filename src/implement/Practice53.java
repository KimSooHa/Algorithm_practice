package implement;

import java.util.HashSet;
import java.util.Set;

public class Practice53 {
	// 연속 부분 수열 합의 개수(프로그래머스 lv2)
	
	public static int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 1; i <= elements.length; i++) {
			for (int j = 0; j < elements.length; j++) {
				int num = 0;
				for (int k = j; k < j+i; k++) {
					num += elements[k%elements.length];
				}
				set.add(num);
			}
		}
        
        answer = set.size();
        
        return answer;
    }

	public static void main(String[] args) {
		int[] elements = {7,9,1,1,4};
		System.out.println(solution(elements));
	} // end of main

} // end of class
