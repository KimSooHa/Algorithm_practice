package implement;

import java.io.IOException;

class Practice47 {
	// ���� ����ǥ(���α׷��ӽ� 2017 ����Ÿ��)
	
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
            // a �����ڿ� b �����ڰ�  2:3�� �ƴ� 1:2 �� 5:6ó�� �� ���帶�� ū��ȣ�� ¦���� �������� ��� 
            if((a + 1 == b || b + 1 == a) && Math.max(a, b) % 2 == 0)
                break;
            
            a = (a % 2 == 0) ? a/2 : (a+1)/2;
            b = (b % 2 == 0) ? b/2 : (b+1)/2;
            
            answer++;
        }

        return answer;
    }
	
}	// end of class