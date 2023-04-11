package string;

import java.util.Arrays;

public class Practice6 {
	// ���� ����� ���� ����(���α׷��ӽ�) 
	
	public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Arrays.fill(answer, -1);
        
        for(int i=1; i<s.length(); i++) {
        	for(int j=0; j<i; j++) {
        		if(s.charAt(i) == s.charAt(j))
        			answer[i] = i-j;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		
		String s = "foobar";
		int[] answer = solution(s);
		
		for(int i=0; i<answer.length; i++)
			System.out.print(answer[i] + " ");
		

	}

}
