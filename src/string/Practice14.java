package string;

public class Practice14 {
	// 크기가 작은 부분문자열 (프로그래머스) 
	    
	public static int solution(String t, String p) {
		int answer = 0;
        
        long n = Long.parseLong(p);
        
        for (int i = 0; i <= t.length()-p.length(); i++) {
        	Long num = Long.parseLong(t.substring(i, i+p.length()));
        					
        	if(num <= n)
        	    answer++;
        }
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		String t = "3141592";
		String p = "271";
		
		System.out.println(solution(t, p));

	}
}