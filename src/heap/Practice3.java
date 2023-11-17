package heap;

import java.util.PriorityQueue;

public class Practice3 {
	// 이중우선순위큐(프로그래머스 lv3)
	
	public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(); // 최소힙
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2) -> { // 최대힙(음수여도 절대값으로 큰값이 우선순위에 가기 때문에 음수인 경우도 비교해서 정렬되도록 하기)
            if(o1 > o2) return -1;
            return 1;
        });
        
        for(int i=0; i<operations.length; i++) {
            String[] str = operations[i].split(" ");
            
            // I인 경우에는 숫자 큐에 삽입
            if(str[0].equals("I")) {
                pqMin.offer(Integer.parseInt(str[1]));
                pqMax.offer(Integer.parseInt(str[1]));
            // D인 경우에는 -1이면 최소값 삭제, 1이면 최댓값 삭제
            } else if(str[0].equals("D") && !pqMin.isEmpty() || !pqMax.isEmpty()) {
                if(str[1].equals("-1")) { // 최소값 삭제(-1)해야 하는 경우에는 최소힙의 우선순위 가장 높은 값 확인 후 최대힙에서 삭제하기
                    int num = pqMin.poll();
                    pqMax.remove(num);
                } else if(str[1].equals("1")) { // 최대값 삭제(1)해야 하는 경우에는 최대힙의 우선순위 가장 높은 값 확인 후 최소힙에서 삭제하기
                    int num = pqMax.poll();
                    pqMin.remove(num);
                }
            }
        }
        // 힙에 들어있는 숫자가 없으면 [0, 0] 반환
        if(pqMin.isEmpty() && pqMax.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else { // 힙에 숫자가 들어있다면[최댓값, 최솟값] 반환
            answer[0] = pqMax.peek();
            answer[1] = pqMin.peek();
        }   
        return answer;
    }
	
	public static void main(String args[]) {
		// ex1
		String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		int[] result1 = solution(operations1);
		System.out.println(result1[0] + ", " + result1[1]);
		
		System.out.println("========");
		
		// ex2
		String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int[] result2 = solution(operations2);
		System.out.println(result2[0] + ", " + result2[1]);
	}	// end of main	
}	// end of class

