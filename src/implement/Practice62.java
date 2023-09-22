package implement;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Practice62 {
	// k진수에서 소수 개수 구하기(프로그래머스 lv2)

	public static int solution(int n, int k) {
        List<String> nums = init(n, k);
        int answer = 0;

        for (String s : nums) {
            // n의 최댓값이 100만이라 k진수로 변환하면 int 범위가 넘어갈 수 있기 때문에 String을 Integer.valueOf()하면 오버플로우 발생함.
        	// => Long으로 받기
            if (isPrime(Long.parseLong(s))) // 소수라면 answer++
                answer++;
        }

        return answer;
    }

    // 소수인지 체크
    private static boolean isPrime(long num) {
        if (num == 1) 
            return false;

        for (int i = 2; i <= (int)Math.sqrt(num); i++) { // 제곱근(루트)까지 했을 때 나눠떨어지면 false
            if (num % i == 0) 
                return false;
        }

        return true;
    }

    // n을 k진수로 변환
    private static String toBinary(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }

        return sb.reverse().toString();
    }

    private static List<String> init(int num, int binary) {
        StringTokenizer st = new StringTokenizer(toBinary(num, binary), "0"); // n을 k진수로 바꾼 문자열에 "0"을 기준으로 분리하기
        List<String> nums = new ArrayList<>();

        while (st.hasMoreTokens()) {
            nums.add(st.nextToken());
        }

        return nums;
    }

	public static void main(String[] args) {

		// ex1
		int n = 437674;
		int k = 3;
		System.out.println(solution(n, k));

		// ex2
		n = 110011;
		k = 10;
		System.out.println(solution(n, k));

	} // end of main

} // end of class
