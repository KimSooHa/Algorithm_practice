package implement;

import java.util.Stack;

public class Practice81 {
	// 유전법칙(프로그래머스 pccp 모의고사 1회 - 3번)

    static String[] secGen = {"RR", "Rr", "Rr", "rr"};
    static Stack<Integer> stack;
    public static String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        
        for(int i=0; i<queries.length; i++) {
            int n = queries[i][0];
            int p = queries[i][1]-1;
            if(n == 1)
                answer[i] = "Rr";
            else {
                stack = new Stack<>();                
                recursive(n, p);
                while(!stack.isEmpty()) {
                    int pop = stack.pop();
                    if(pop == 0 || pop == 3) { // 첫번째 자식은 "RR", 네번째 자식은 "rr"    
                        answer[i] = secGen[pop];
                        break;
                    }
                }
                if(answer[i] == null) 
                    answer[i] = "Rr"; // 나머지의 경우는 "Rr"
            }
        }
        return answer;
    }
    
    
    public static void recursive(int n, int p) {
        if(n == 1) // n이 1, 즉 첫번째 세대가 되면 쌓기를 멈춘다.
            return;
        
        stack.push(p % 4);
        recursive(n-1, p/4); // n-1 자손들 중에 p/4번째 자식이 되는 것.
    }

	public static void main(String[] args) {
		// tc1.
		int[][] queries1 = {{3,5}};
		String[] result1 = solution(queries1);
		for(String str : result1)
			System.out.println(str);
		
		System.out.println("-----");
		
		// tc2.
		int[][] queries2 = {{3,8},{2,2}};
		String[] result2 = solution(queries2);
		for(String str : result2)
			System.out.println(str);
		
		System.out.println("-----");
		
		// tc3.
		int[][] queries3 = {{3,1},{2,3},{3,9}};
		String[] result3 = solution(queries3);
		for(String str : result3)
			System.out.println(str);
		
		System.out.println("-----");
		
		// tc4.
		int[][] queries4 = {{4,26}};
		String[] result4 = solution(queries4);
		for(String str : result4)
			System.out.println(str);
		
	} // end of main

} // end of class
