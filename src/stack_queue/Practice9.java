package stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Practice9 {
	// 택배상자(프로그래머스 lv2)

	public static int solution(int[] order) {
        int answer = 0;
        Queue<Integer> seq = new LinkedList<>();
        Stack<Integer> assist = new Stack<>();
        
        for(int i=0; i<order.length; i++) {
            seq.add(order[i]);
        }
        
        int i=0;
        while(!seq.isEmpty()) {
            if(i >= order.length)
                break;
                
            i++;
            assist.push(i);
            
            while(seq.peek().intValue() == assist.peek().intValue()) {
                seq.remove();
                assist.pop();
                answer++;
                if(assist.isEmpty())
                    break;
            }
        }
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		// ex1
		int[] order1 = {4, 3, 1, 2, 5};
		int result1 = solution(order1);
		
		System.out.println(result1 == 2);
		
		System.out.println();
		System.out.println("----------------");
		
		// ex2
		int[] order2 = {5, 4, 3, 2, 1};
		int result2 = solution(order2);
		
		System.out.println(result2 == 5);
	} // end of main


} // end of class
