package implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice5 {
	// ���ڿ� ������
	
	public static String str;	// �Է¹޴� ����
	public static ArrayList<Character> result = new ArrayList<>();	// ���� ������ ����Ʈ 
	public static int value = 0;	// ���� ���ϴ� ����
	
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isLetter(str.charAt(i)))	// ���ĺ��� ��� ����Ʈ�� ����
				result.add(str.charAt(i));
			else	// ���ڴ� ���� ���ϱ�
				value += str.charAt(i) - '0';
		}
		
		// ���ĺ� ���ʴ�� �����ϱ�
		Collections.sort(result);
		
		// ���ĺ��� ���ʴ�� ���
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i));
		}
		
		// ���ڰ� �ϳ��� �����ϴ� ��� ���� �ڿ� ��� 
		if(value != 0)
			System.out.print(value);
	}	// end of main
	
}	// end of class