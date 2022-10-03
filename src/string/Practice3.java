package string;

public class Practice3 {
	// 음양 더하기(프로그래머스 - 월간 코드 챌린지 시즌2)
	
	 public static int solution(int[] absolutes, boolean[] signs) {
	        int answer = 0;
	        
	        for(int i=0; i<absolutes.length; i++) 
	        	answer += signs[i] ? absolutes[i] : -absolutes[i];
	        
	        
	        return answer;
	    }
	
	public static void main(String[] args) {
		
		
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		
		
		System.out.println(solution(absolutes, signs));
		

	}

}
