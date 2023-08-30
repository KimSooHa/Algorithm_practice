package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Practice5 {
	// 제로(백준 10773)

	static int k, answer; // 정수 갯수, 적어낸 수의 합
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0)
				stack.pop();
			else
				stack.push(num);
		}
		
		for (int i = 0; i < stack.size(); i++) {
			answer += stack.get(i);
		}
		
		System.out.println(answer);
	} // end of main


} // end of class
