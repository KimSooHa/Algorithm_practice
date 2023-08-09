package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice54 {
	// �ֻ��� ������(���� 14499)

	static int n, m, x, y, k;
	static StringTokenizer st;
	static int[][] map;
	// �ֻ��� �� �鿡 ���� ����
	static int[] dice = {0, 0, 0, 0, 0, 0}; // ����, �ٴڸ�, �ո�, �޸�, ���ʸ�, �����ʸ�
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken()); // �ֻ��� ��ǥ(x)
		y = Integer.parseInt(st.nextToken()); // �ֻ��� ��ǥ(y)
		k = Integer.parseInt(st.nextToken()); // ��� ����
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int move = Integer.parseInt(st.nextToken()) - 1;
			int nx = x + dx[move];
			int ny = y + dy[move];
			
			if(0 > nx || nx >= n || 0 > ny || ny >= m) continue;
			
			x = nx;
			y = ny;
			
			// �ֻ��� �ش� �������� ������
			switch(move) {
			case 0:
				right();
				break;
			case 1:
				left();
				break;
			case 2:
				up();
				break;
			case 3:
				down();
				break;
			}
			// ������ ���� 0�̸� �ֻ����� �ٴڸ� ������ ����
			if(map[x][y] == 0) {
				map[x][y] = dice[1];
			} else { // ������ ���� 0�� �ƴϸ� �ް��鿡 ������ �� ������ �� �������� 0���� ����
				dice[1] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[0]);
		}
		
	} // end of main

	// �ֻ��� ���� ����
	public static void right() {
		// �� -> �� -> �ٴ� -> �� -> ��
		int temp = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = temp;
	}
	
	public static void left() {
		// �� -> �� -> �ٴ� -> �� -> ��
		int temp = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = temp;
	}
	
	public static void up() {
		// �� -> �� -> �ٴ� -> �� -> ��
		int temp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[3];
		dice[3] = temp;
	}

	public static void down() {
		// �� -> �� -> �ٴ� -> �� -> ��
		int temp = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[1];
		dice[1] = dice[2];
		dice[2] = temp;
	}

} // end of class
