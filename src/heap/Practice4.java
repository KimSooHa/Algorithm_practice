package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Practice4 {
	// 야근 지수(프로그래머스 lv3)

	public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
        for(int work : works)
            pq.add(work);
        
        for(int i=0; i<n; i++) {
            int work = pq.poll();
            if(work == 0) return 0;
            pq.add(work-1);
        }
        
        while(!pq.isEmpty()) 
            answer += Math.pow(pq.poll(), 2);
        
        return answer;
    }
	
	public static void main(String[] args) {
		// tc1
		int[] works1 = {4,3,3};
		int n = 4;
		System.out.println(solution(n, works1));
		
		// tc2
		int[] works2 = {2,1,2};
		n = 1;
		System.out.println(solution(n, works2));
		
		// tc3
		int[] works3 = {1,1};
		n = 3;
		System.out.println(solution(n, works3));

	} // end of main

} // end of class
