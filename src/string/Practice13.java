package string;

public class Practice13 {
	// 시저 암호 (프로그래머스) 
	    
	public static String solution(String s, int n) {
        String answer = "";

        String[] str = s.split("");

        for(int i=0; i<str.length; i++) {
            char c = str[i].charAt(0);
            int idx = (int)('z' - 'a') + 1;
            if(c == ' ')
                answer += c;
            else if(c >= 'a' && c <= 'z')
                answer += (char)('a' + (c + n - 'a') % idx);
            else
                answer += (char)('A' + (c + n - 'A') % idx);

        }

        return answer;
    }
	
	
	public static void main(String[] args) {
		
		
		String s = "a B z";
		int n = 4;
		
		String answer = solution(s, n);
		
		System.out.println(answer);

	}
}