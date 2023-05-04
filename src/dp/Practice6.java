package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice6 {
	// �ϳ��� ž �̵�����(���� 11729)
	static StringBuilder sb = new StringBuilder();
		

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int N = Integer.parseInt(br.readLine());
		
		sb.append((int)(Math.pow(2, N)-1)).append('\n');
		
		Hanoi(N, 1, 2, 3);
		System.out.println(sb);
	
	}	// end of main
	
	/*
	  N: ������ ����
	  start: �����
	  mid : �ű�� ���� �̵��ؾ� �ϴ� ���
	  to: ������
	 */
	public static void Hanoi(int N, int start, int mid, int to) {
		// �̵��� ������ ���� 1�����?
		if(N == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		// A -> C�� �ű�ٰ� ������ ��,
		// STEP 1 : N-1���� A���� B�� �̵�(= start ������ N-1���� ������ mid �������� �ű��.)
		Hanoi(N-1, start, to, mid);
		
		//STEP 2 : 1���� A���� C�� �̵�(=start ������ N��° ������ to�������� �ű��.)
		sb.append(start + " " + to + "\n");
		
		// STEP3 : N-1���� B���� C�� �̵�(mid ������ N-1���� ������ to �������� �ű��.)
		Hanoi(N-1, mid, start, to);
	}

}	// end of class
