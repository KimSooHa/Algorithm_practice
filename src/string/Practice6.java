package string;

public class Practice6 {
	// 가운데 글자 가져오기 (프로그래머스) 
	
    public static String solution(String s) {
        
        String answer = "";
        int length = s.length();
        answer = length % 2 == 0 ? s.substring(length/2 - 1, length/2 + 1) : s.substring(length/2, length/2 + 1);
        
        return answer;
    }
		
	public static void main(String[] args) {
		String s = "abcde";
		String answer = solution(s);
		System.out.println(answer);
	}

}
