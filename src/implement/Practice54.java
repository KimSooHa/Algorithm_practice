package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice54 {
	// 주사위 굴리기(백준 14499)

	static int n, m, x, y, k;
	static StringTokenizer st;
	static int[][] map;
	// 주사위 각 면에 대한 값들
	static int[] dice = {0, 0, 0, 0, 0, 0}; // 윗면, 바닥면, 앞면, 뒷면, 왼쪽면, 오른쪽면
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken()); // 주사위 좌표(x)
		y = Integer.parseInt(st.nextToken()); // 주사위 좌표(y)
		k = Integer.parseInt(st.nextToken()); // 명령 갯수
		
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
			
			// 주사위 해당 방향으로 굴리기
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
			// 지도의 값이 0이면 주사위의 바닥면 지도에 복사
			if(map[x][y] == 0) {
				map[x][y] = dice[1];
			} else { // 지도의 값이 0이 아니면 받각면에 지도의 값 복사한 후 지도값을 0으로 변경
				dice[1] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[0]);
		}
		
	} // end of main

	// 주사위 굴림 구현
	public static void right() {
		// 위 -> 오 -> 바닥 -> 왼 -> 위
		int temp = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = temp;
	}
	
	public static void left() {
		// 위 -> 왼 -> 바닥 -> 오 -> 위
		int temp = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = temp;
	}
	
	public static void up() {
		// 위 -> 뒤 -> 바닥 -> 앞 -> 위
		int temp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[3];
		dice[3] = temp;
	}

	public static void down() {
		// 위 -> 앞 -> 바닥 -> 뒤 -> 위
		int temp = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[1];
		dice[1] = dice[2];
		dice[2] = temp;
	}

} // end of class
