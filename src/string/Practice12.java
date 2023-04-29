package string;

public class Practice12 {
	// 이상한 문자 만들기 (프로그래머스 lv1) 
	    
	public static String solution(String s) {
        String answer = "";

        for(int i=0, cnt = 0; i<s.length(); i++) {
            if(i != 0 && s.charAt(i-1) == ' ') 
                cnt = 0;

            answer += cnt % 2 == 0 ? Character.toUpperCase(s.charAt(i)) : Character.toLowerCase(s.charAt(i));

            cnt++;
        }
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		String s = "try hello world";
		System.out.println(solution(s));
	}
}