package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice11 {
	// 탈출(백준 3055)
	// 매 시간마다 고슴도치 이동해야 하고 물도 퍼뜨려야하는데 효율성에 걸리지 않게 하려면 이 로직을 동시에 처리해야 하는데 그 부분이 관건!
	
	static int r, c;
	static StringTokenizer st;
	static int min = Integer.MAX_VALUE;
	
	static char[][] map;
	static Queue<Position> water = new LinkedList<>(); // 물위치 저장 큐
	static Queue<Position> q = new LinkedList<>(); // 고슴도치 위치 큐
	
	// 4방향의 위치
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
		
		// 그래프 및 최단 거리 테이블 초기화
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
			// 물 퍼뜨리기
			int length = water.size(); // 물 위치 큐의 사이즈만큼만 실행
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
		
			// 고슴도치 이동
			length = q.size(); // 고슴도치 위치 큐 사이즈만큼만 실행
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
					
					// 비버의 굴(D)을 만날 때 함수를 return 시키고 빠져나오기
					if(map[nx][ny] == 'D') {
						min = Math.min(min, t+1);
						return;
					}
					else if(map[nx][ny] == '.') {
						map[nx][ny] = 'S'; // 이걸 안하면 고슴도치의 위치까지 계속 체크하기 때문에 메모리 초과나므로 주의
						q.offer(new Position(nx, ny, t+1));
					}
				}
				
			}
		}
		
	}

}	// end of class
