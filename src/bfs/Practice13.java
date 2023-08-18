package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice13 {
	// �丶��(���� 7569)
	
	static int m, n, h; // ������ ũ��(m ,n), ������ ��(h)
	static StringTokenizer st;
	
	static int[][][] map; // ����
	static Queue<Position> q = new LinkedList<>(); 
	
	// 6������ ��Ÿ���� ���� �迭
	public static int[] dx = {-1, 0, 1, 0, 0, 0};
	public static int[] dy = {0, 1, 0, -1, 0, 0};
	public static int[] dz = {0, 0, 0, 0, 1, -1};
	
	public static class Position {
		int z;
		int x;
		int y;
		
		public Position(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][n][m];
		
		for(int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < m; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) 
						q.add(new Position(i, j, k)); // bfs �����ϴ� ��� ť�� �߰�
				}
			}
		}
			
		System.out.println(bfs());
		
	}	// end of main

	public static int bfs() {
		
		while (!q.isEmpty()) {
			Position pos = q.poll();
			int x = pos.x;
			int y = pos.y;
			int z = pos.z;
			
			for (int k = 0; k < 6; k++) {
				int nz = dz[k] + z;
				int nx = dx[k] + x;
				int ny = dy[k] + y;
				
				if(!checkPosition(nz, nx, ny))
					continue;
				
				q.offer(new Position(nz, nx, ny));			
				
				map[nz][nx][ny] = map[z][x][y] + 1;
			}	
		}
		// �ִ밪�� ���ϱ� ���� ����
		int result = Integer.MIN_VALUE;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					// �ϳ��� ���� ���� �丶�䰡 �ִٸ� -1 ��ȯ
					if(map[i][j][k] == 0)
						return -1;
					
					// �丶�䰡 �ʹµ� �ɸ��� �ð��� ����
					result = Math.max(result, map[i][j][k]);
				}
			}
		}
		// �ִ밪�� 1�̶�� �������� ��� �;����� �丶���
		if(result == 1)
			return 0;
		else // �ɸ� �ϼ�
			return result - 1;
	}
	
	private static boolean checkPosition(int z, int x, int y) {
		// �־��� ���� ������ �˻�
		if(x < 0 || x >= n || y < 0 || y >= m || z < 0 || z >= h)
			return false;
		
		// ���� ���� ���� �丶���� true ��ȯ
		if(map[z][x][y] == 0)
			return true;

		// �̹� �;��ְų� �� �ڸ���� false ��ȯ
		return false;
	}

}	// end of class
