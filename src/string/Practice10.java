package string;

public class Practice10 {
	// ���ڿ� �ٷ�� �⺻ (���α׷��ӽ�) 
	    
	public static boolean solution(String s) {
        boolean answer = true;
        char[] c = s.toCharArray();
        if(c.length != 4 && c.length != 6) return false;
        
        for(int i=0; i<c.length; i++) {
            if(!(c[i] >= '0' && c[i] <= '9')) return false;
        }
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		String s = "a234";
		System.out.println(solution(s));

	}
}