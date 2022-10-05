package sorting;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Practice1 {
	// ī�� �����ϱ�(���� 1715)
	public static int n, result;
	
	public static void main(String[] args ) {
		
		Scanner sc = new Scanner(System.in);
		
		// ī�� ����
		n = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++)
			pq.offer(sc.nextInt());	// 10, 20, 30
		
		// ���� ���Ұ� 1�� ���� ������
		while(pq.size() != 1) {
			int one = pq.poll();	// 10 / 30
			int two = pq.poll();	// 20 / 40
			
			// ī�� ������ ���ļ� �ٽ� ����
			int summary = one + two;	// 30 / 70
			result += summary;	// ���� ���� ������ ��ģ �� �����ϱ�
			pq.offer(summary);	// 30 / 70
		}
		
		System.out.println(result);
		
	}	// end of main

}	// end of class
