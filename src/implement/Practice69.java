package implement;

public class Practice69 {
	// 기사단원의 무기(프로그래머스 lv1)

	public static int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++) {
            int cnt = 0;
            for(int j=1; j<=Math.sqrt(i); j++) {
                if(i % j == 0) {
                    cnt++;
                    if(i/j != j)
                        cnt++;    
                }
            }
            answer += cnt > limit ? power : cnt;
        }
        
        return answer;
    }

	public static void main(String[] args) {

		// ex1
		int number = 5, limit = 3, power = 2;
		System.out.println(solution(number, limit, power));
		
		// ex2
		number = 10;
		limit = 3;
		power = 2;
		System.out.println(solution(number, limit, power));


	} // end of main

} // end of class
