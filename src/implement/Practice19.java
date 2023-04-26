package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice19 {
	// �����¿�
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] plans = br.readLine().split(" ");
		int x = 1, y = 1;
		
		// L, R, U ,D�� ���� �̵�����
		int dx[] = {0, 0, -1, 1};
		int dy[] = {-1, 1, 0, 0};
		
		char[] moveTypes = {'L', 'R', 'U', 'D'};
		
		// �̵� ��ȹ�� �ϳ��� Ȯ��
		for (int i = 0; i < plans.length; i++) {
			char plan = plans[i].charAt(0);
			
			// �̵� �� ��ǥ ���ϱ�
			int nx = 0, ny = 0;
			
			// 4���� �߿� �Է¹��⿡ �ش��ϴ� ����� ���� ����ŭ ���� ��ǥ���� �̵��ϱ�
			for (int j = 0; j < 4; j++) {
				if(plan == moveTypes[j]) {
					nx = x + dx[j];
					ny = y + dy[j];
				}
			}
			
			// ������ ����� ��� ����
			if(nx < 1 || ny < 1 || nx > n || ny > n) continue;
				
			x = nx;
			y = ny;
		}
		
		System.out.println(x + " " + y);
	}	// end of main
}	// end of class