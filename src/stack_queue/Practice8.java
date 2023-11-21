package stack_queue;

import java.util.Stack;

public class Practice8 {
	// 뒤에 있는 큰 수 찾기(프로그래머스 lv2)
	// stack에 인덱스를 넣어 관리하는 방식으로 기준두기

	public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        // 순회하면서 현재 값이 스택에 최상단 값보다 크면 뒤에 있는 큰 수에 해당
        for(int i=1; i<numbers.length; i++) {
        	// 스택에 값이 있고 스택이 바라보는 값보다 number의 값이 크면 뒤에 있는 큰 수에 해당
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i])
                answer[stack.pop()] = numbers[i];
            
            stack.push(i); // 현재 인덱스 push
        }
        
        // 스택에 값이 남아있는 경우 => 해당 인덱스의 값보다 큰 수가 없으므로 -1 대입
        while(!stack.isEmpty())
            answer[stack.pop()] = -1;
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		// ex1
		int[] numbers1 = {2,3,3,5};
		int[] result1 = solution(numbers1);
		
		for(int res : result1)
			System.out.print(res+ " ");
		
		System.out.println();
		System.out.println("----------------");
		
		// ex2
		int[] numbers2 = {9,1,5,3,6,2};
		int[] result2 = solution(numbers2);
		
		for(int res : result2)
			System.out.print(res+ " ");
	} // end of main


} // end of class
