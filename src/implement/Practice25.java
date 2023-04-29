package implement;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Practice25 {
	// �似Ǫ�� ����0(���� 11866)
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // �ο�
		int k = sc.nextInt(); // ������ �ε���
		
		List<Integer> list = new LinkedList<>();
		
		for(int i=1; i<=n; i++) 
			list.add(i);
		
		int index = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		// n���� ����� ��� ���ŵ� ������ �ݺ�
		while(!list.isEmpty()) {
			index = (index + k-1) % n;
			
			if(list.size() != 1)
				sb.append(list.get(index)).append(", ");
			else
				sb.append(list.get(0));
			
			list.remove(index);
			
			if(index > n)
				index -= n;
			
			n--;
		}
		sb.append(">");
		
		System.out.println(sb.toString());
		
	}	// end of main

}	// end of class