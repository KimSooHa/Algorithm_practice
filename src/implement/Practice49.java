package implement;

public class Practice49 {
	// ������ ���� �̵�(���α׷��ӽ� lv2)

	public static void main(String[] args) {
		
		int n = 5000;
		System.out.println(solution(n));
		
	} // end of main
	
	public static int solution(int n) {
        
        int cnt = 0;
    
        // �����̵��ϴ� ���(���� �Ÿ� * 2) ���� ���� �� �����Ƿ� ¦���� �Ǵ� ���� Ȧ���� �Ǵ� ���� ������!
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
