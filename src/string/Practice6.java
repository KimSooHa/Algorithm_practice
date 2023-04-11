package string;

public class Practice6 {
	// 문자열 나누기 (프로그래머스 lv1) 
	
	public static int solution(String s) {
        int answer = 0;
        int first = 0;
        int rest = 0;
        char x = s.charAt(0);
        int length = s.length();
        for(int i=0; i<length; i++) {
            
            if(first == rest) {
                answer++;
                x = s.charAt(i);
                first = 0;
                rest = 0;
            }
            
            if(s.charAt(i) == x)
                first++;
            else 
                rest++;
            
        }
        return answer;
    }
	
	public static void main(String[] args) {
		
		
		String s = "abracadabra";
		int answer = solution(s);
		
		System.out.println(answer);

	}

}
