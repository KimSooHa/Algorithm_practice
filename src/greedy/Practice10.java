package greedy;

class Practice10 {
	// �ְ��� ����(���α׷��ӽ� ��������)
	// ������ ���� �� ������ ���̰� ���� ���� ���̽��� ���� �̷���
	
	public static int[] solution(int n, int s) {
        int[] answer;
        
		
		if(s < n) {
			answer = new int[] {-1};
			return answer;
		}
		
		int init = s / n; // ��
		int mod = s % n; // ������
		
		answer = new int[n];
		
		// �迭�� ��� ���� ������ �ʱ�ȭ
		for (int i = 0; i < n; i++) 
			answer[i] = init;
		
		// ������ ��ŭ �ڿ�������(�������� ������ �ǰ�) 1�� ������
		int idx = n - 1;
		for (int i = 0; i < mod; i++) {
			answer[idx]++;
			idx--;
		}
        
        return answer;
    }

	
	public static void main(String args[]) {
		
		int n = 2;
		int s = 9;
		
		int[] answer = solution(n, s);
		
		for (int i = 0; i < n; i++) 
			System.out.println(answer[i]);
		
				
	} // end of main

}	// end of class