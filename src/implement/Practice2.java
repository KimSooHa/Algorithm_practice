package implement;

import java.io.IOException;
import java.util.Scanner;

public class Practice2 {
	// ��Ű ��Ʈ����Ʈ
	// �־��� ������ Ư�� ����(�ڸ����� �������� ���� N�� ������ ������ ���ʺκ��� �� �ڸ����� �� = ������ �κ��� �ڸ����� ��)�� �����ϸ� ��Ű ��Ʈ����Ʈ ��� ��밡��		
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		int result = 0;
		
		for(int i=0; i<input.length()/2; i++) 	
			result += input.charAt(i) - '0';
			
		for(int i=input.length()/2; i<input.length(); i++)
			result -= input.charAt(i) - '0';
		
		// ��Ű ��Ʈ����Ʈ ����(input�� ������ ���� �� �ڸ����� ���� ������ �Ȱ��� ���)
		if(result == 0)
			System.out.println("LUCKY");
		else	// ��Ű ��Ʈ����Ʈ �Ұ���
			System.out.println("READY");
	}	// end of main

}	// end of class

