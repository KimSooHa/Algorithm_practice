package implement;

import java.io.IOException;

public class Practice10 {
	// ����� ������ ����(���α׷��ӽ� ���� �ڵ� ç���� ����2) 
	
	public static int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
            int cnt = 0;
            
            for(int j=1; j<=i; j++) {
                if(i%j == 0) {
                    cnt+=1;
                }
            }
            if(cnt %2 == 0)
                answer += i;
            else
                answer -= i;
        }
        return answer;
    }
	
	public static void main(String args[]) throws IOException {
		
		int left = 13;
		int right = 17;
		
		System.out.println(solution(left, right));
		
	}	// end of main
	
}	// end of class