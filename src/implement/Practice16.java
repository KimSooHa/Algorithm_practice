package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice16 {
	// �м�ã��(���� 1193) 
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		// T = �и� + ����(¦���� ���� ���ʾƷ����� ������ �� ���� / Ȧ���� ���� ������ ������ ���� �Ʒ� �������� ����)
		// crossCnt(�밢�� ���� = T-1), prevCntSum(���� �밢�������� �� ����)
		int crossCnt = 1, prevCntSum = 0;
		
		while (true) {
			// ���� �밢�� ������ + �ش� �밢�� ���� �̿��� ���� �Ǻ�
			if (x <= prevCntSum + crossCnt) {
				
				if (crossCnt % 2 == 1) { // �밢���� ������ Ȧ�����(T�� ¦�����)
					// ���ڰ� ū ������ ����
					// ���� = �밢���� ���� ���� - (X ��° - ���� �밢�������� �� ����) + 1 => �밢���� ���� ���� - �и� + 1(�밢���� ����(crossCnt)�� �и�+������ ��(T)�� ���� 1)
					// �и� = X ��° - ���� �밢�������� �� ����
					System.out.print((crossCnt - (x - prevCntSum) + 1) + "/" + (x - prevCntSum));
					break;
				}
				
				else {	// �밢���� ������ ¦����� (T�� Ȧ�����)
					// Ȧ���� ���� ����� �ݴ�� 
					System.out.print((x - prevCntSum) + "/" + (crossCnt - (x - prevCntSum) + 1));
					break;
				}
 
			} else {
				prevCntSum += crossCnt;
				crossCnt++;
			}
		}
		
	}	// end of main
	
}	// end of class