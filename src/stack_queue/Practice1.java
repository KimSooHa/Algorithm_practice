package stack_queue;

import java.util.Stack;

public class Practice1 {
	// 같은 숫자는 싫어(프로그래머스 - 스택/큐)
	
	public static int[] solution(int []arr) {
        
        Stack<Integer> stackArr = new Stack<>();
        
        for(int index : arr) {
        	if(stackArr.isEmpty())	// 스택이 비어있다면
        		stackArr.push(index);	// 스택에 넣기
        	else if(stackArr.peek() != index)	// 연속된 숫자가 동일하지 않다면
        		stackArr.push(index);	// 스택에 넣기
        }
        
        int[] answer = new int[stackArr.size()];
        
        // 이전 배열의 순서를 지키기 위해 스택에서 하나씩 빼서 마지막 인덱스부터 채우기
        for(int i=stackArr.size()-1; i>=0; i--)
        	answer[i] = stackArr.pop();

        return answer;
    }

	public static void main(String[] args) {
		
		int[] arr = {1,1,3,3,0,1,1};
		
		int[] answer = solution(arr);
		
		System.out.print("[");
		
		for(int i=0; i<answer.length; i++) {
			if(i == answer.length-1)
				System.out.print(answer[i]);
			else
				System.out.print(answer[i] + ", ");	// 1, 3, 0, 1
		}
		

		System.out.print("]");
	}	// end of main

}	// end of class
