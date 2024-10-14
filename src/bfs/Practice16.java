package bfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Practice16 {
	// 숫자 변환하기(프로그래머스 lv2)

	public static int solution(int x , int y, int n) {
		int answer = 0;
		answer = getCnt(x, y, n);
		return answer;
	}
	
	public static int getCnt(int x, int y, int n) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, 0});
		
		boolean[] visited = new boolean[y+1];
		
		while(!queue.isEmpty()) {
			int[] tmpArr = queue.poll(); // 현재 상태를 큐에서 꺼냄
			int currNum = tmpArr[0]; // 현재 숫자
			int count = tmpArr[1]; // 연산 횟수
			
			// 현재 숫자가 목표 숫자 y와 같다면 횟수 반환
			if (currNum == y) {
				return count;
			}
			
			// 가능한 연산을 통해 새로운 숫자를 계산하고 큐에 추가
			if (currNum + n <= y && !visited[currNum + n]) {
				queue.add(new int[] {currNum + n, count+1});
				visited[currNum + n] = true; // 방문 체크
			}
			if (currNum * 2 <= y && !visited[currNum * 2]) {
				queue.add(new int[] {currNum * 2, count+1});
				visited[currNum * 2] = true; // 방문 체크
			}
			if (currNum * 3 <= y && !visited[currNum * 3]) {
				queue.add(new int[] {currNum * 3, count+1});
				visited[currNum * 3] = true; // 방문 체크
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {
		
		// ex:1
		int x = 10, y = 40, n = 5;
		int result = solution(x, y, n);
		System.out.println(result == 2);
		
		System.out.println();
		System.out.println("------");
		System.out.println();
		
		// ex:2
		x = 10;
		y = 40;
		n = 30;
		result = solution(x, y, n);
		System.out.println(result == 1);
		
		System.out.println();
		System.out.println("------");
		System.out.println();
		
		// ex:3
		x = 2;
		y = 5;
		n = 4;
		result = solution(x, y, n);
		System.out.println(result == -1);
	} // end of main


} // end of class
