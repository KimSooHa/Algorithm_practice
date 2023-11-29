package implement;

import java.util.Stack;

public class Practice81 {
	// ������Ģ(���α׷��ӽ� pccp ���ǰ�� 1ȸ - 3��)

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
                    if(pop == 0 || pop == 3) { // ù��° �ڽ��� "RR", �׹�° �ڽ��� "rr"    
                        answer[i] = secGen[pop];
                        break;
                    }
                }
                if(answer[i] == null) 
                    answer[i] = "Rr"; // �������� ���� "Rr"
            }
        }
        return answer;
    }
    
    
    public static void recursive(int n, int p) {
        if(n == 1) // n�� 1, �� ù��° ���밡 �Ǹ� �ױ⸦ �����.
            return;
        
        stack.push(p % 4);
        recursive(n-1, p/4); // n-1 �ڼյ� �߿� p/4��° �ڽ��� �Ǵ� ��.
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
