package implement;

public class Practice49 {
	// 점프와 순간 이동(프로그래머스 lv2)

	public static void main(String[] args) {
		
		int n = 5000;
		System.out.println(solution(n));
		
	} // end of main
	
	public static int solution(int n) {
        
        int cnt = 0;
    
        // 순간이동하는 경우(현재 거리 * 2) 값을 줄일 수 있으므로 짝수가 되는 경우와 홀수가 되는 경우로 나누기!
        while(n > 0) {
        	
        	if(n % 2 != 0) {
        		n -= 1;
        		cnt++;
        	}
        	else
        		n /= 2;
        }

        return cnt;
    }

} // end of class
