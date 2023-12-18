package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Practice5 {
	// 최소 힙(백준 1927)
	
	static int n; // 연산의 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		n = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) 
				sb.append(pq.size() == 0 ? 0 : pq.poll()).append("\n");
			else
				pq.add(x);
		}
		
		System.out.println(sb);

	} // end of main

} // end of class
