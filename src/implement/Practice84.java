package implement;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice84 {
	// 숫자 게임(프로그래머스 lv3)
	
	// 풀이 1
	public static int solution1(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int cnt = 0;
        for(int i=0; i<A.length; i++) {
            if(A[cnt] < B[i]) {
                answer++;
                cnt++;
            }
        }
        return answer;
    }
	
	// 풀이 2
	public static int solution2(int[] A, int[] B) {
		int answer = 0;
		PriorityQueue<Integer> pA = new PriorityQueue<>();
		PriorityQueue<Integer> pB = new PriorityQueue<>();
		
		for(int i=0; i<A.length; i++) {
			pA.add(A[i]);
			pB.add(B[i]);
		}
		
		while(!pA.isEmpty() && !pB.isEmpty()) {
			if(pA.peek() < pB.peek()) {
				answer++;
				pA.poll();
			}
			pB.poll();
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		
		int[] A1 = {5, 1, 3, 7};
		int[] B1 = {2, 2, 6, 8};
		
		System.out.println(solution1(A1, B1) == 3);
		System.out.println(solution2(A1, B1) == 3);
		
		int[] A2 = {2, 2, 2, 2};
		int[] B2 = {1, 1, 1, 1};
		
		System.out.println(solution1(A2, B2) == 0);
		System.out.println(solution2(A2, B2) == 0);
		
	} // end of main

} // end of class
