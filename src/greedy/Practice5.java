package greedy;

import java.util.Scanner;

public class Practice5 {
	// ���ڿ� ������
	
	public static String str;
	public static int count0 = 0;	// ���� 0���� �ٲ�� ���
	public static int count1 = 0;	// ���� 1�� �ٲ�� ���

	public static void main(String[] args) {
		// 1�� ������ ��� / 0�� ������ ���(���ӵ� ���ڸ� ������ ��츦 1������ ģ��)
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		
		// ù ��° ���ҿ� ���ؼ� ó��
		if(str.charAt(0) == '1') count0++;
		else count1++;
		
		for(int i=1; i<str.length(); i++) {
			// ���� �ε����� ���� �ε����� ���ڰ� ���� ���� ��
			if(str.charAt(i-1) != str.charAt(i)) {
				// ���� ������ 1�� �ٲ�� ���
				if(str.charAt(i) == '1') count0++;
				// ���� ������ 0���� �ٲ�� ���
				else count1++;
			}
		}
		
		System.out.println(Math.min(count0,  count1));
	}	// end of main

}	// end of class
