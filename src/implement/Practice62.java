package implement;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Practice62 {
	// k�������� �Ҽ� ���� ���ϱ�(���α׷��ӽ� lv2)

	public static int solution(int n, int k) {
        List<String> nums = init(n, k);
        int answer = 0;

        for (String s : nums) {
            // n�� �ִ��� 100���̶� k������ ��ȯ�ϸ� int ������ �Ѿ �� �ֱ� ������ String�� Integer.valueOf()�ϸ� �����÷ο� �߻���.
        	// => Long���� �ޱ�
            if (isPrime(Long.parseLong(s))) // �Ҽ���� answer++
                answer++;
        }

        return answer;
    }

    // �Ҽ����� üũ
    private static boolean isPrime(long num) {
        if (num == 1) 
            return false;

        for (int i = 2; i <= (int)Math.sqrt(num); i++) { // ������(��Ʈ)���� ���� �� ������������ false
            if (num % i == 0) 
                return false;
        }

        return true;
    }

    // n�� k������ ��ȯ
    private static String toBinary(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }

        return sb.reverse().toString();
    }

    private static List<String> init(int num, int binary) {
        StringTokenizer st = new StringTokenizer(toBinary(num, binary), "0"); // n�� k������ �ٲ� ���ڿ��� "0"�� �������� �и��ϱ�
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
