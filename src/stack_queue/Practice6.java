package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Practice6 {
	// 카드 뭉치(프로그래머스 lv1)

	public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        
        for(int i=0; i<cards1.length; i++)
            q1.add(cards1[i]);
        
        for(int i=0; i<cards2.length; i++)
            q2.add(cards2[i]);
        
        for(int i=0; i<goal.length; i++) {
            if(q1.size() != 0 && q1.peek().equals(goal[i])) 
                q1.poll();    
            else if(q2.size() != 0 && q2.peek().equals(goal[i]))
                q2.poll();
            else 
                return "No";            
        }
        
        return "Yes";
    }
	
	public static void main(String[] args) {
		// ex1
		String[] cards1 = {"i", "drink", "water"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};
		System.out.println(solution(cards1, cards2, goal));

		// ex2
		String[] cards3 = {"i", "water", "drink"};
		System.out.println(solution(cards3, cards2, goal));
	} // end of main


} // end of class
