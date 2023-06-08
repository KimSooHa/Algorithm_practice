package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Practice7 {
	// ������(���� 2589)
	// �ϳ��� ����� �������� ���� �ָ� ������ �ִ� �� �� ã��
	
	static class Position {
		private int x;
		private int y;
		private int cnt;
		
		public Position(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getCnt() {
			return cnt;
		}
	}
	
	static int n, m;
	static char[][] map;
	static boolean[][] visit;
	static StringTokenizer st;
	static int result = 0;
	// ��, ��, ��, ��
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// ����: L, �ٴ�: W�� ǥ�õǾ� ����
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 'L') {
					// ������ ��� �湮�迭 �ʱ�ȭ(�ش� ��ġ�� ������ ������ ã�� ���� ��ġ�� ���� ���ϱ� ���ؼ�)
					visit = new boolean[n][m];
					int value = solution(i, j); // Ư�� ��ġ�� ���� �������� ���� �� �Ÿ� ã��
					result = Math.max(value, result); // �� ���� ��ġ���� �ִܰŸ��� �������� ���� �ִܰŸ��� ������ġ�� �Ÿ��� ���� 
				}
			}
		}
		System.out.println(result);
	} // end of main


	static int solution(int x, int y) {
		Queue<Position> q = new LinkedList<>();
		int val = 0;
		visit[x][y] = true; // �湮ó��
		q.add(new Position(x, y, 0));
		while(!q.isEmpty()) {
			Position pos = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = pos.getX() + dx[i];
				int ny = pos.getY() + dy[i];
				// ���� ��ġ�� �����̸鼭 �湮���� ���� ���̸�
				if(0 > nx || nx >= n || 0 > ny || ny >= m || visit[nx][ny] || map[nx][ny] == 'W') 
					continue;
				
				visit[nx][ny] = true; // �湮ó��
				q.add(new Position(nx, ny, pos.getCnt()+1));
				val = Math.max(val, pos.getCnt()+1); // �� �ð��� �ɸ��� �������� ��ġ�� ����					
			}
		}
		
		return val;
	}

}	// end of class