package implement;

import java.io.IOException;
import java.util.Arrays;

class Practice34 {
	// 예산(프로그래머스 lv1)

	static int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for(int i=0; i<d.length; i++) {
            if(budget - d[i] < 0) break;
            
            budget -= d[i];
            answer++;
        }
        return answer;
    }
	
	
	public static void main(String args[]) throws IOException {
		
		int[] d = {1,3,2,5,4};
		int budget = 9;
		System.out.println(solution(d, budget));
				
	}	// end of main


}	// end of class