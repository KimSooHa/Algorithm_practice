package implement;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Practice25 {
	// 요세푸스 문제0(백준 11866)
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 인원
		int k = sc.nextInt(); // 제거할 인덱스
		
		List<Integer> list = new LinkedList<>();
		
		for(int i=1; i<=n; i++) 
			list.add(i);
		
		int index = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		// n명의 사람이 모두 제거될 때까지 반복
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