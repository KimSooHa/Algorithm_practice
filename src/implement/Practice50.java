package implement;

public class Practice50 {
	// N���� �ּҰ����(���α׷��ӽ� lv2)
	// ��Ŭ���� ȣ���(�� ���� ���� �־����� ��, �ִ������� ���ϴ� �˰���) ����

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

	// �ּҰ����
	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	// �ִ�����
	private static int gcd(int a, int b) {
		if(a % b == 0)
			return b;
		
		return gcd(b, a % b); 
	}

} // end of class
