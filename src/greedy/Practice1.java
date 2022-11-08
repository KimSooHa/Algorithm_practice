package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice1 {
	// ���谡 ��� => ���� �Է°�(������)�� ���� ������ �����ϴ� ���� �߿�

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			arrayList.add(sc.nextInt());
		
		Collections.sort(arrayList);
		
		int result = 0;	// ���� �� �ִ� �� �׷��� ��
		int cnt = 0;	// ���� �׷쿡 ���Ե� ���谡�� ��
		
		for(int i=0; i<n; i++) {	// �������� ���� �ͺ��� �ϳ��� Ȯ���ϸ�
			
			cnt += 1;
			
			if(cnt >= arrayList.get(i)) {	// ���� �׷쿡 ���Ե� ���谡�� ���� ������ ������ �̻��̶��, �׷� �Ἲ
				result += 1;	// �� �׷��� �� ������Ű��	
				cnt = 0;	// ���� �׷쿡 ���Ե� ���谡�� �� �ʱ�ȭ
			}
		}

		System.out.println(result);
		
	}	// end of main

}	// end of class
