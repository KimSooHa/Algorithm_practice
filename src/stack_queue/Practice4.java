package stack_queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Practice4 {
	// 프로세스(프로그래머스 lv2)

	public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 숫자 높을 수록 우선순위 높음
        
        for(int i=0; i<priorities.length; i++) 
            pq.offer(priorities[i]);
        
        while(!pq.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                if(pq.peek() == priorities[i]) {
                    if(i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;       
                }
            }   
        }
        return answer;
    }


	public static void main(String[] args) {
		// case 1
		int[] priorities1 = {2, 1, 3, 2};
		int location = 2;
		System.out.println(solution(priorities1, location));
		
		// case 2
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		location = 0;
		System.out.println(solution(priorities2, location));
	}	// end of main

}	// end of class
