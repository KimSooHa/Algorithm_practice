package shortestPath;

import java.util.PriorityQueue;


public class Practice3 {
	// 더 맵게(프로그래머스)

	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
        	pq.offer(scoville[i]);
        }
        
        
        while(pq.peek()<K) {
        	
        	if(pq.size() == 1)
        		return -1;
        	
        	int sum = pq.poll() + (pq.poll()*2);
        	pq.offer(sum);
        	answer++;
        }
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 7;
		
		System.out.println(solution(scoville, k));

	}

}	// end of class
