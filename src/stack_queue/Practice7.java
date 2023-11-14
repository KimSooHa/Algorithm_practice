package stack_queue;

import java.util.Stack;

public class Practice7 {
	// �ֽİ���(���α׷��ӽ� lv2)

	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>(); // �ֽİ��� ��ȭ�� ���� �ð� üũ����

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) { // ���� ������� ���� && �ֽ� ���� ������
                answer[stack.peek()] = i - stack.peek(); // �ֽİ��� ������ �ð� ���
                stack.pop();  // ���� ���߱� ������ stack���� ����
            }
            stack.push(i); // ������ �������� ���� ��쿡�� �ش� �ε��� push
        }

        while (!stack.isEmpty()) { // ���� ������ ���� index == ������ ������ �������� ���� �ֽ�
            answer[stack.peek()] = prices.length - stack.peek() - 1; // ��ü �ð� - �ش� �ε��� - 1
            stack.pop(); // �ð� ���� ������ ���ÿ��� ����
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
