package stack_queue;

import java.util.Stack;

public class Practice8 {
	// �ڿ� �ִ� ū �� ã��(���α׷��ӽ� lv2)
	// stack�� �ε����� �־� �����ϴ� ������� ���صα�

	public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        // ��ȸ�ϸ鼭 ���� ���� ���ÿ� �ֻ�� ������ ũ�� �ڿ� �ִ� ū ���� �ش�
        for(int i=1; i<numbers.length; i++) {
        	// ���ÿ� ���� �ְ� ������ �ٶ󺸴� ������ number�� ���� ũ�� �ڿ� �ִ� ū ���� �ش�
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i])
                answer[stack.pop()] = numbers[i];
            
            stack.push(i); // ���� �ε��� push
        }
        
        // ���ÿ� ���� �����ִ� ��� => �ش� �ε����� ������ ū ���� �����Ƿ� -1 ����
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
