package binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice1 {
	// ������ ��ġ(���� 2110)

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// ���� ����, ������ ����
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		// ���� ��ǥ
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			arr.add(sc.nextInt());
		
		// ����Ž���� ���� ���� ����
		Collections.sort(arr);
		
		// ����Ž���� ���� �������� ���� ����
		int start = 1;	// ������ �ּҰŸ�
		int end = arr.get(n-1) - arr.get(0);	// ������ �ִ�Ÿ�
		int result = 0;	// ���� ������ ������ ������ �ִ�Ÿ�
		
		// ����Ž�� ����
		while(start <= end) {
			int mid = (start + end) / 2;	// ���� ������ �� ������ ������ �Ÿ�
			
			// ù° ������ ������ �����⸦ ��ġ�Ѵٰ� ����
			int value = arr.get(0);	// ���� ��ġ�� ������ ��
			int cnt = 1;	// ��ġ�� ������ ����
			
			// ������ mid ���� �̿��� ������ ��ġ�ϱ�
			for(int i=1; i<n; i++) {
				// ���� ���� ������ ���ذŸ� �̻� �������ִٸ�
				if(arr.get(i) >= mid + value) {
					value = arr.get(i);	// ������ ��ġ�� �� ����
					cnt++;
				}
			}
			
			// c�� �̻��� �����⸦ ��ġ�� �� �ִ� ���, �Ÿ��� ������Ű��(������ ��ġ ���� ������)
			if(cnt >= c) {
				start = mid + 1;
				result = mid;	// ������ ����� ����
			}
			// c�� �̻��� �����⸦ ��ġ�� �� ���� ���, �Ÿ��� ���ҽ�Ű��(�����⸦ ��ġ�� �� �ִ� ���� ������)
			else 
				end = mid - 1;
			
		}
		
		System.out.println(result);

	}

}
