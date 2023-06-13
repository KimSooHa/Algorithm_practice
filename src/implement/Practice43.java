package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Practice43 {
	// �����̾� ��Ʈ ���� �κ�(���� 20055)
	static int n, k;
	
	static StringTokenizer st;
	static int A[];
	static boolean robot[];
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		A = new int[2 * n];
		robot = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n * 2; i++) 
			A[i] = Integer.parseInt(st.nextToken()); 
		
		System.out.println(simulation(0));
				
	} // end of main


	// �κ��� �Բ� �� ĭ ȸ��
	// ��Ʈ�� ȸ���ϴ� �������� ��ĭ �̵��� �� ������ �̵�, �ƴϸ� ������ ��
	// �̵��Ϸ��� ĭ�� �κ��� ������, �� ĭ�� �������� 1 �̻� ���� �־�� ��
	// �������� 0�� ĭ�� ������ k�� �̻��̸� ���� ����
	public static int simulation(int cnt) {
		
		while(isOk()) {
			// ��Ʈ �� ĭ ȸ��
			int temp = A[A.length-1]; 
			for (int i = A.length-1; i > 0; i--) // �ڿ������� �� �ε��� �� �ڷ� �ű�� 
				A[i] = A[i - 1];
			
			A[0] = temp; // �� ���� �ε����� �� ������ ��ġ
			
			for (int i = robot.length-1; i > 0; i--) // �κ��� ��Ʈ�� ���� ȸ�� 
				robot[i] = robot[i-1];
			
			robot[0] = false; // �κ� ù��° ��ġ ���
				
			robot[n-1] = false; // ������ ��ġ�� �κ� ������
			
			for(int i = n-1; i > 0; i--) { // �κ� �̵������ϸ� �̵�
				if(robot[i-1] && !robot[i] && A[i] >= 1) {
					robot[i] = true;
					robot[i-1] = false;
					A[i]--;
				}
			}
			
			if(A[0] > 0) { // �ö󰡴� ��ġ�� �κ� �ø���
				robot[0] = true;
				A[0]--;
			}
			
			cnt++; // ���� �ܰ� �ø���
		}
		
		return cnt;
	}


	// �������� 0�� ĭ�� ������ k�� �̻����� üũ
	public static boolean isOk() {
		
		int cnt = 0;
		
		for (int i = 0; i < A.length; i++) {
			
			if(A[i] == 0)
				cnt++;
			
			if(cnt >= k)
				return false;
		}
		return true;
	}

}	// end of class