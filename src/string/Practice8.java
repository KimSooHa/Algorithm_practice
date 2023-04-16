package string;

public class Practice8 {
	// 내적 (프로그래머스 - 월간 코드 챌린지 시즌1) 
	    
		public static int solution(int[] a, int[] b) {
	        int answer = 0;
	        for(int i=0; i<a.length; i++) {
	            answer += a[i]*b[i];
	        }
	        return answer;
	    }
	
	
	public static void main(String[] args) {
		
		
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		
		int answer = solution(a, b);
		
		System.out.println(answer);

	}
}