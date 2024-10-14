package bfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Practice16 {
	// ���� ��ȯ�ϱ�(���α׷��ӽ� lv2)

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
			int[] tmpArr = queue.poll(); // ���� ���¸� ť���� ����
			int currNum = tmpArr[0]; // ���� ����
			int count = tmpArr[1]; // ���� Ƚ��
			
			// ���� ���ڰ� ��ǥ ���� y�� ���ٸ� Ƚ�� ��ȯ
			if (currNum == y) {
				return count;
			}
			
			// ������ ������ ���� ���ο� ���ڸ� ����ϰ� ť�� �߰�
			if (currNum + n <= y && !visited[currNum + n]) {
				queue.add(new int[] {currNum + n, count+1});
				visited[currNum + n] = true; // �湮 üũ
			}
			if (currNum * 2 <= y && !visited[currNum * 2]) {
				queue.add(new int[] {currNum * 2, count+1});
				visited[currNum * 2] = true; // �湮 üũ
			}
			if (currNum * 3 <= y && !visited[currNum * 3]) {
				queue.add(new int[] {currNum * 3, count+1});
				visited[currNum * 3] = true; // �湮 üũ
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
