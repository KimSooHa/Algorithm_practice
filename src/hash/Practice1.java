package hash;

import java.io.IOException;
import java.util.HashSet;

public class Practice1 {
	// 폰켓몬(프로그래머스 lv1)

	public static int solution(int[] nums) {
		int answer = 0;
        int max = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) 
            set.add(nums[i]);
        
        answer = Math.min(max, set.size());
        
        return answer;
    }
	
	public static void main(String[] args) throws IOException {
		
		int[] nums = {3, 1, 2, 3};
		System.out.println(solution(nums));

	}	// end of main

}	// end of class
