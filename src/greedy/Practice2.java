package greedy;

import java.util.Scanner;

public class Practice2 {
	// ���ϱ� Ȥ�� ���ϱ�
	// ���ϱ�� ���ϱ⸦ �־ ������� �� �ִ� ���� ū �� �����(������ ���ʿ��� �������)

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		// ���ڿ� ù��° ����
		long result = str.charAt(0) - '0';
		
		for(int i=1; i<str.length(); i++) {
			// i��° ���ڿ� ���ڷ� �̱�
			int num = str.charAt(i) - '0';
			// ���ڰ� 1�����̰ų� ���� result�� 0�̸�
			if(num <= 1 || result == 0)
				result += num;	// ���ϱ�
			else
				result *= num;	// ���ϱ�
		}

		System.out.println(result);
		
	}	// end of main

}	// end of class
