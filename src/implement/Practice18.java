package implement;

import java.io.IOException;

public class Practice18 {
	// 숫자의 표현(프로그래머스 lv2) 
	
	public static int solution(int n) {
        int count = 0;
        
        for(int i=1; i<=n; i++) {
            int num = 0;
            for(int j=i; j<=n; j++) {
                num += j;

                if(num == n) {
                    count++;
                    break;
                }
                else if(num > n) break;
            }
        }
        return count;
    }
	
	public static void main(String args[]) throws IOException {
		
		int n = 15;
		System.out.println(solution(n));
		
	}	// end of main
}	// end of class