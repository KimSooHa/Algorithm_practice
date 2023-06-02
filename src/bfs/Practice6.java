package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice6 {
	// ����(���� 2251)

	static class AB {
		int a;
		int b;
		
		public AB(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}


	static boolean[][] visited;
	static StringTokenizer st;
	static int[] sender = {0,0,1,1,2,2};
	static int[] receiver = {1,2,0,2,0,1};
	static boolean[] answer;
	static int[] now = new int[3];
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		now[0] = Integer.parseInt(st.nextToken());
		now[1] = Integer.parseInt(st.nextToken());
		now[2] = Integer.parseInt(st.nextToken());
		
		visited = new boolean[201][201];
		answer = new boolean[201];
		bfs();
		
		for (int i = 0; i < answer.length; i++) 
			if(answer[i]) System.out.print(i + " ");
		

	}	// end of main


	public static void bfs() {
		Queue<AB> q = new LinkedList<>();
		q.add(new AB(0, 0));
		visited[0][0] = true;
		answer[now[2]] = true;
		
		while(!q.isEmpty()) {
			AB p = q.poll();
			int a = p.a;
			int b = p.b;
			int c = now[2] - a - b;
			
			for (int i = 0; i < 6; i++) {
				int[] next = {a,b,c}; // ���� ���
				next[receiver[i]] += next[sender[i]]; // ������ ������ ��� �뷮�� �޴� ���뿡 ����
				next[sender[i]] = 0;
				// �޴� ������ ��ĥ ���
				if(next[receiver[i]] > now[receiver[i]]) {
					next[sender[i]] = next[receiver[i]] - now[receiver[i]]; // �ʰ��ϴ� ����ŭ ������ ���뿡 �����
					next[receiver[i]] = now[receiver[i]]; // �޴� �뷮���� ��ġġ �ʰ� ä���
				} // A,B,C ���԰� ������ ��忡 �湮�� �̷��� ���ٸ� �湮ó�� �� ť�� �߰�
				if(!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					q.add(new AB(next[0], next[1]));
					if(next[0] == 0) // 1��° ������ ���԰� 0�� �� 3��° ������ ���� ���� �迭�� �߰�
						answer[next[2]] = true;
				}
			}
		}
	}


}	// end of class
