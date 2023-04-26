package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice21 {
	// �ս��� ����Ʈ
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pos = br.readLine();
		int col = pos.charAt(0) - 'a' + 1;	// ���ڸ� ����(1���� ����)�� ����
		int row = pos.charAt(1) - '0';	// ���ڸ� ���ڷ� ����
		
		//����Ʈ�� �̵��� �� �ִ� 8���� ���� ����
		int[] dx = {-2, -1, 1, 2, 1, 2, -1, -2};
		int[] dy = {-1, -2, -2, -1, 2, 1, 2, 1};
		
		int cnt = 0;
		// 8���� ���⿡ ���Ͽ� �� ��ġ�� �̵��� �������� Ȯ��
		for (int i = 0; i < 8; i++) {
			// ���� �Է°����� �� ����� ���� ���� ��
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];
			// ���� ���� 8x8 �������� ������� Ȯ��
			if(nextRow < 1 || nextRow > 8 || nextCol < 1 || nextCol > 8) continue;
			
			cnt++;
		}
		System.out.println(cnt);
	}	// end of main
}	// end of class