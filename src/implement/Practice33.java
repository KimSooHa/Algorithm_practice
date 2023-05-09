package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Practice33 {
	// �κ� û�ұ�(���� 14503)

	static int n, m, r, c, d; // ���� ũ��, �κ� û�ұ� ��ǥ, ��
	static int[][] graph;
	static StringTokenizer st;

	// ȸ�� ����(��, ��, ��, ��)
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Position {
		private int x;
		private int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}
	
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) 
				graph[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(simulate());
				
	}	// end of main


	public static int simulate() {
		int x = r, y = c; // �κ� û�ұ� ��ġ
		graph[x][y] = 2; // ������ġ û��
		int cnt = 1; // û���ϴ� ĭ�� ����
		int direction = d; // �κ� û�ұ� ����
		int index = 0; // ȸ�� Ƚ��
		
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x, y));
		
		while(true) {
			
			Position pos = q.poll();
			x = pos.getX();
			y = pos.getY();
			// �������� û���� ��ġ ã��(�ݽð� ���� 90�� ȸ��)
			for(int i=0; i<4; i++) {
				direction = turn(direction);
				index++;
				int nx = x + dx[direction];
				int ny = y + dy[direction];
				// ���� �����ȿ� �����鼭 û�Ҹ� ���� ĭ(0)�̸� û��
				if(-1<nx && nx<n && -1<ny && ny<m && graph[nx][ny] == 0) {
					graph[nx][ny] = 2;
					q.offer(new Position(nx, ny));
					cnt++;
					index = 0;
					break;
				}
			}
			// ���� ĭ�� �ֺ� 4ĭ �� û�ҵ��� ���� �� ĭ�� ���� ���
			if(index == 4) {
				int nx = x - dx[direction];
				int ny = y - dy[direction];
				// �ٶ󺸴� ������ ���� ĭ�� ���̶� ������ �� ���ٸ� �۵� ����
				if(graph[nx][ny] == 1) break; 

				// ��ĭ ������ �� ������ ���� 
				q.offer(new Position(nx, ny));
				index = 0;
			}
		}
		
		return cnt;
	}


	public static int turn(int d) {
		d = (d == 0) ? 3 : d-1;
		
		return d;
	}

}	// end of class