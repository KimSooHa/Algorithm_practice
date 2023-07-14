package greedy;

class Practice12 {
	// ū �� �����(���α׷��ӽ�)
	// �� �ڸ����� �ְ�� ���� ���� ������ ��츦 �����ϱ�
	public static String solution(String number, int k) {
        String answer = "";
        char[] arr = number.toCharArray();
        int length = arr.length - k;
        // ���� �񱳸� �����ϴ� �ε���
        int idx = 0;
        StringBuilder sb = new StringBuilder(); // �׳� ���ڿ� ���ϸ� �ð��ʰ���
        
        for (int i = 0; i < length; i++) {
        	char max = '0';
			for (int j = idx; j <= i + k; j++) {
				// ���� ū ���� ��� �� ���� �ε����� �����ε����� ����
				if(arr[j] > max) {
					max = arr[j];
					idx = j+1;
				}
			}
			sb.append(max);
		}
        
        answer = sb.toString();
        
        return answer;
    }

	
	public static void main(String args[]) {
		
		String number = "1924";
		int k = 2;
		
		System.out.println(solution(number, k));
				
	} // end of main

}	// end of class