package implement;

import java.io.IOException;

class Practice47 {
	// 예상 대진표(프로그래머스 2017 팁스타운)
	
	public static void main(String args[]) throws IOException {
		
		int n = 8;
		int a = 4;
		int b = 7;
		System.out.println(solution(n, a, b));
		
	} // end of main

	public static int solution(int n, int a, int b)
    {
        
        int answer = 1;
        
        while(true) {
            // a 참가자와 b 참가자가  2:3이 아닌 1:2 나 5:6처럼 매 라운드마다 큰번호가 짝수로 배정받은 경우 
            if((a + 1 == b || b + 1 == a) && Math.max(a, b) % 2 == 0)
                break;
            
            a = (a % 2 == 0) ? a/2 : (a+1)/2;
            b = (b % 2 == 0) ? b/2 : (b+1)/2;
            
            answer++;
        }

        return answer;
    }
	
}	// end of class