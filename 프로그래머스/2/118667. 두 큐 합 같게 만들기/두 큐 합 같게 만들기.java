import java.util.*;

class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long answer = -1;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1t = 0;
        long q2t = 0;
        for(int i=0; i<queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            q1t += queue1[i];
            q2t += queue2[i];
        }
        
        int work = 0;
        int cnt = 0;
        while(q1t != q2t) {
            // 두 배열의 길이 합 * 2 => 모든 원소들이 원점으로 돌아옴
            if(cnt >= queue1.length * 2 * 2)
                return answer;
            
            if(q1t > q2t) {
                q2t += q1.peek();
                q1t -= q1.peek();
                q2.offer(q1.poll());
                work++;
            } else {
                q1t += q2.peek();
                q2t -= q2.peek();
                q1.offer(q2.poll());
                work++;
            }
            cnt ++;
        }
        
        answer = work;
        return answer;
    }
}