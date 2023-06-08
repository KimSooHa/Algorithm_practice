package stack_queue;

import java.util.Stack;

public class Practice1 {
	// ���� ���ڴ� �Ⱦ�(���α׷��ӽ� - ����/ť)
	
	public static int[] solution(int []arr) {
        
        Stack<Integer> stackArr = new Stack<>();
        
        for(int index : arr) {
        	if(stackArr.isEmpty())	// ������ ����ִٸ�
        		stackArr.push(index);	// ���ÿ� �ֱ�
        	else if(stackArr.peek() != index)	// ���ӵ� ���ڰ� �������� �ʴٸ�
        		stackArr.push(index);	// ���ÿ� �ֱ�
        }
        
        int[] answer = new int[stackArr.size()];
        
        // ���� �迭�� ������ ��Ű�� ���� ���ÿ��� �ϳ��� ���� ������ �ε������� ä���
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
