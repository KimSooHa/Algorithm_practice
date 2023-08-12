package implement;

public class Practice55 {
	// n^2 �迭 �ڸ���(���α׷��ӽ� lv2)
	
	//(1,1)(1,2)(1,3)
    //(2,1)(2,2)(2,3)
    //(3,1)(3,2)(3,3)
    // ==
    //max(1,1)max(1,2)max(1,3) = 1 2 3
    //max(2,1)max(2,2)max(2,3) = 2 2 3
    //max(3,1)max(3,2)max(3,3) = 3 3 3
    // ==
    //1���� �迭�� ��ȯ
    //idx    = 0 1 2 3 4 5 6 7 8
    //value  = 1 2 3 2 2 3 3 3 3

    // idx / n = 2/3 = 0 + 1 = 1
    // idx % n = 2%3 = 1 + 1 = 2

    //1���� �迭 2�� idx �� 2���� �迭 (1,2)�� ����.
    //(1,2)�� ū ���� 2���� �迭 value �̹Ƿ�, 1���� �迭�� 2�� idx �� 2

    //-> �̷������� left...(right-left) ���� ����
    //(int) ����ȯ�� ������ ������ value ���� ������ n �����̰�, n <= 10,000,000 �̴�.
	
	public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        
        for(int i=0; i<answer.length; i++) {
            int x = (int)(left / n);
            int y = (int)(left % n);
            answer[i] = Math.max(x, y) + 1;
            left++;
        }
        
        return answer;
    }


	public static void main(String[] args) {

		int n = 3;
		long left = 2;
		long right = 5;
		
		int[] result = solution(n, left, right);
		
		for(int arr : result) {
			System.out.println(arr);		
		}
	} // end of main

} // end of class
