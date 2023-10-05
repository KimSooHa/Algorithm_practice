package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Practice2 {
	// 명예의 전당(1)(프로그래머스 lv1)
	
	public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<score.length; i++) {
            q.offer(score[i]);
            if(q.size() <= k)
                answer[i] = q.peek();
            else if(q.size() > k) {
                q.poll();
                answer[i] = q.peek();
            }
        }
            
        return answer;
    }
	
	public static void main(String args[]) {
		
		// ex1
		int k = 3;
		int[] score1 = {10, 100, 20, 150, 1, 100, 200};
		
		int[] result1 = solution(k, score1);
		
		for(int r : result1)
			System.out.println(r);
		
		System.out.println("========");
		
		// ex2
		k = 4;
		int[] score2 = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
		
		int[] result2 = solution(k, score2);
		
		for(int r : result2)
			System.out.println(r);

	}	// end of main	

	
}	// end of class

