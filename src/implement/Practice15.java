package implement;

public class Practice15 {
	// 최대공약수와 최소공배수(프로그래머스) 
	
	public static int[] solution(int n, int m) {
        int min = 0;
        int max = 0;
        
        for(int i=1; i<=n; i++) {
            if(n % i == 0 && m % i == 0)
                min = i;
        }
        
        max = min * (n / min) * (m / min);
        
        int[] answer = {min, max};
        
        return answer;
    }
	
	public static void main(String args[]) {
		
		int n = 3;
		int m = 12;
		int[] answer = solution(n, m);
		System.out.print("[" + answer[0] + ", " + answer[1] + "]");
		
	}	// end of main
}	// end of class