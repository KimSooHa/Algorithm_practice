package sorting;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Practice1 {
	// 카드 정렬하기(백준 1715)
	public static int n, result;
	
	public static void main(String[] args ) {
		
		Scanner sc = new Scanner(System.in);
		
		// 카드 개수
		n = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++)
			pq.offer(sc.nextInt());	// 10, 20, 30
		
		// 힙에 원소가 1개 남을 때까지
		while(pq.size() != 1) {
			int one = pq.poll();	// 10 / 30
			int two = pq.poll();	// 20 / 40
			
			// 카드 묶음을 합쳐서 다시 삽입
			int summary = one + two;	// 30 / 70
			result += summary;	// 가장 작은 값끼리 합친 값 누적하기
			pq.offer(summary);	// 30 / 70
		}
		
		System.out.println(result);
		
	}	// end of main

}	// end of class
