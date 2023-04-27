package implement;

import java.io.IOException;
import java.util.Scanner;

public class Practice22 {
	// 다음 큰 숫자(프로그래머스 lv2)
	static int cnt = 0;
    public static int solution(int n) {
        int answer = 0;
        cnt = Integer.bitCount(n);
        
        while(true) {
            n++;
            if(checkLength(n)) {
                answer = n;
                break;
            }
        }
        return answer;
    }
    public static boolean checkLength(int n) {
        int bitCnt = Integer.bitCount(n);
        
        if(bitCnt == cnt)
            return true;
        
        return false;
    }
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));
	}	// end of main
}	// end of class