package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice75 {
	// ���ڿ� ��ȯ(���� 1522)

	// �־��� ���ڿ� 0��° �ε������� ���ڿ� ������ ������, �� ��ġ���� a�� ���̱��� ���캸�鼭 b�� ���� ��� b�� a�� ��ȯ
	// ��ȯȽ���� �ּڰ� = b�� a�� ���� ��ȯ x. b�� �ִٸ� b�� ī������ ���ְ� �ּڰ� ���ϱ�

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch = br.readLine().toCharArray();
		int aCnt = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<ch.length; i++) {
			if(ch[i] == 'a')
				aCnt++;
		}
		
		for(int i=0; i<ch.length; i++) {
			int bCnt = 0;
			// 0 �ε������� �� �ε������� ���캸�鼭 b�� ���� ī����.
			for(int j=i; j<aCnt+i; j++) {
				if(ch[j%ch.length] == 'b') // ���ڿ��� �������� �̾��������Ƿ� ������ �����ڸ� ���ؼ� �־��� ���ڿ��� ������ �Ѿ�� �ٽ� 0��°���� ���캸��!
					bCnt++;
			}
			// b�� �ּڰ� = �ּ��� ��ȯȽ��
			min = Math.min(min, bCnt);
		}
		System.out.println(min);
	} // end of main
} // end of class
