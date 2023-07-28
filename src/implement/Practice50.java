package implement;

public class Practice50 {
	// N개의 최소공배수(프로그래머스 lv2)
	// 유클리드 호재법(두 개의 수가 주어졌을 때, 최대공약수를 구하는 알고리즘) 응용

	public static void main(String[] args) {
		
		int[] arr = {2, 6, 8, 14};
		System.out.println(solution(arr));
		
	} // end of main
	
	public static int solution(int[] arr) {
        int answer = 0;
        
        answer = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
        	answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }

	// 최소공배수
	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	// 최대공약수
	private static int gcd(int a, int b) {
		if(a % b == 0)
			return b;
		
		return gcd(b, a % b); 
	}

} // end of class
