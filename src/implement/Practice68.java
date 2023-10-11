package implement;

public class Practice68 {
	// 소수 찾기(프로그래머스 lv1)

	public static int solution(int n) {
        int answer = 1;
        
        for(int i=3; i<=n; i++) {
            boolean isPrime = true;
            for(int j=2; j<=Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;           
                }
            }
            if(isPrime) answer++;
        }
            
        return answer;
    }

	public static void main(String[] args) {

		// ex1
		int n = 10;
		System.out.println(solution(n));
		
		// ex2
		n = 5;
		System.out.println(solution(n));


	} // end of main

} // end of class
