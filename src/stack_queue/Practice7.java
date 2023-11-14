package stack_queue;

import java.util.Stack;

public class Practice7 {
	// 주식가격(프로그래머스 lv2)

	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>(); // 주식가격 변화에 대한 시간 체크스택

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) { // 스택 비어있지 않음 && 주식 가격 떨어짐
                answer[stack.peek()] = i - stack.peek(); // 주식가격 유지한 시간 기록
                stack.pop();  // 답을 구했기 때문에 stack에서 제거
            }
            stack.push(i); // 가격이 떨어지지 않은 경우에는 해당 인덱스 push
        }

        while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            answer[stack.peek()] = prices.length - stack.peek() - 1; // 전체 시간 - 해당 인덱스 - 1
            stack.pop(); // 시간 구한 가격은 스택에서 빼기
        }

        return answer;
    }
	
	
	public static void main(String[] args) {
		// ex1
		int[] prices = {1, 2, 3, 2, 3};
		int[] answer = solution(prices);
		
		for(int ans : answer)
			System.out.print(ans + " ");
	} // end of main


} // end of class
