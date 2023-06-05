package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Practice41 {
	// �ɱ�(���� 14620)
	static int n;
	static int[][] board;
	static boolean[][] visit;
	static StringTokenizer st;
	static int answer = Integer.MAX_VALUE;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		board = new int[n][n];
		visit = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) 
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		solution(0, 0);
		System.out.println(answer);
	} // end of main

	public static void solution(int count, int sum) {
		
		if(count == 3) // ã�� ���� 3���� �Ǵ� ��� �뿩��� �ּҰ� ����
			answer = Math.min(answer, sum);
		 else {
			 for (int i = 1; i < board.length-1; i++) {
				for (int j = 1; j < board.length-1; j++) {
					if(!visit[i][j] && check(i, j)) {
						visit[i][j] = true;
						int num = sum(i, j);
						solution(count+1, sum + num);
						visitClear(i, j);
					}
				}
			}
		 }
	}

	// �湮�ߴ� �� �湮 ��� ó��
	public static void visitClear(int x, int y) {
		
		visit[x][y] = false;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			visit[nx][ny] = false;
		}
	}
	// ȭ�� �뿩��� ���ϱ�
	public static int sum(int x, int y) {
		int num = board[x][y];
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			visit[nx][ny] = true;
			num += board[nx][ny];
		}
		
		return num;
	}

	public static boolean check(int x, int y) {
		// ������ �ִ��� üũ
		for (int i = 0; i < 4; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(visit[nx][ny])
				return false;
		}
		
		return true;
	}

	
}	// end of class