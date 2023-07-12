package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice11 {
	// Ż��(���� 3055)
	// �� �ð����� ����ġ �̵��ؾ� �ϰ� ���� �۶߷����ϴµ� ȿ������ �ɸ��� �ʰ� �Ϸ��� �� ������ ���ÿ� ó���ؾ� �ϴµ� �� �κ��� ����!
	
	static int r, c;
	static StringTokenizer st;
	static int min = Integer.MAX_VALUE;
	
	static char[][] map;
	static Queue<Position> water = new LinkedList<>(); // ����ġ ���� ť
	static Queue<Position> q = new LinkedList<>(); // ����ġ ��ġ ť
	
	// 4������ ��ġ
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static class Position {
		
		private int x;
		private int y;
		private int time;
		
		public Position(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}

		public int getTime() {
			return time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		
		// �׷��� �� �ִ� �Ÿ� ���̺� �ʱ�ȭ
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*')
					water.offer(new Position(i, j, 0));
				
				if(map[i][j] == 'S') 
					q.offer(new Position(i, j, 0));
			}
		}
		
		bfs();
		System.out.println(min == Integer.MAX_VALUE ? "KAKTUS" : min);
	}	// end of main

	public static void bfs() {
		
		while (!q.isEmpty()) {
			// �� �۶߸���
			int length = water.size(); // �� ��ġ ť�� �����ŭ�� ����
			for (int i = 0; i < length; i++) {
				Position pos = water.poll();
				int x = pos.getX();
				int y = pos.getY();
				int t = pos.getTime();
				
				for (int k = 0; k < 4; k++) {
					int nx = dx[k] + x;
					int ny = dy[k] + y;
					
					if(nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] != '.')
						continue;
					
					map[nx][ny] = '*';
					water.add(new Position(nx, ny, t+1));	
				}
			}
		
			// ����ġ �̵�
			length = q.size(); // ����ġ ��ġ ť �����ŭ�� ����
			for (int i = 0; i < length; i++) {
				Position pos = q.poll();
				int x = pos.getX();
				int y = pos.getY();
				int t = pos.getTime();
				
				for (int k = 0; k < 4; k++) {
					int nx = dx[k] + x;
					int ny = dy[k] + y;
					if(nx < 0 || nx >= r || ny < 0 || ny >= c)
						continue;
					
					// ����� ��(D)�� ���� �� �Լ��� return ��Ű�� ����������
					if(map[nx][ny] == 'D') {
						min = Math.min(min, t+1);
						return;
					}
					else if(map[nx][ny] == '.') {
						map[nx][ny] = 'S'; // �̰� ���ϸ� ����ġ�� ��ġ���� ��� üũ�ϱ� ������ �޸� �ʰ����Ƿ� ����
						q.offer(new Position(nx, ny, t+1));
					}
				}
				
			}
		}
		
	}

}	// end of class
