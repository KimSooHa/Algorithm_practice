package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Practice39 {
	// ����Ʈ ����(���� 1331)
	// �̵� ������ ��ġ���� �Ǻ��ϴ� ���: x�������� 2ĭ y�������� 1ĭ or x�������� 1ĭ y�������� 2ĭ
	// -> ���� x��ǥ�� ���� x��ǥ, ���� y��ǥ�� ���� y��ǥ�� ���� ���밪���� ���� 1,2�Ǵ� 2,1�� ���´ٸ� �̵��� �� �ִ� ��ġ�� �Ǻ�

	static int nowx, nowy, prevx, prevy;

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<String> visit = new ArrayList<>(); // �湮�� ��ǥ�� �����ϱ� ���� ����Ʈ
		String st = br.readLine();
		int startx = st.charAt(0); // ù��° ��ġ ����
		int starty = st.charAt(1);
		prevx = startx;
		prevy = starty;
		
		visit.add(st);
		
		for (int i = 0; i < 35; i++) {
			String s = br.readLine();
			nowx = s.charAt(0);
			nowy = s.charAt(1);
			
			// �湮�� �� �ִ� ���� �� �ٽ� �湮�ϸ� Invalid
			if(visit.contains(s)) {
				System.out.println("Invalid");
				return;
			}
			// ����Ʈ�� ���� ��ġ���� �̵��� �� �ִ� ��ġ�̸� ������ġ�� ������ġ�� ����
			if(Math.abs(nowx - prevx) == 2 && Math.abs(nowy - prevy) == 1 || Math.abs(nowx - prevx) == 1 && Math.abs(nowy - prevy) == 2) {
				visit.add(s);
				prevx = nowx;
				prevy = nowy;
				continue;
			} else { // �׷��� �ʴٸ� Invalid
				System.out.println("Invalid");
				return;				
			}
		}
		
		// ����Ʈ�� ������ ������ġ���� ù���� ��ġ�� �� �� ������ Valid
		if(Math.abs(nowx - startx) == 2 && Math.abs(nowy - starty) == 1 || Math.abs(nowx - startx) == 1 && Math.abs(nowy - starty) == 2) {
			System.out.println("Valid");
			return;
		}
		// ����Ʈ�� ������ ������ġ���� ù��° ��ġ�� �� �� ������ Invalid
		System.out.println("Invalid");
	}

	
}	// end of class