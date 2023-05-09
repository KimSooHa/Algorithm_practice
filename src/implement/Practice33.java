package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Practice33 {
	// 로봇 청소기(백준 14503)

	static int n, m, r, c, d; // 방의 크기, 로봇 청소기 좌표, 방
	static int[][] graph;
	static StringTokenizer st;

	// 회전 방향(북, 동, 남, 서)
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
		int x = r, y = c; // 로봇 청소기 위치
		graph[x][y] = 2; // 현재위치 청소
		int cnt = 1; // 청소하는 칸의 개수
		int direction = d; // 로봇 청소기 방향
		int index = 0; // 회전 횟수
		
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x, y));
		
		while(true) {
			
			Position pos = q.poll();
			x = pos.getX();
			y = pos.getY();
			// 방향으로 청소할 위치 찾기(반시계 방향 90도 회전)
			for(int i=0; i<4; i++) {
				direction = turn(direction);
				index++;
				int nx = x + dx[direction];
				int ny = y + dy[direction];
				// 방의 영역안에 있으면서 청소를 안한 칸(0)이면 청소
				if(-1<nx && nx<n && -1<ny && ny<m && graph[nx][ny] == 0) {
					graph[nx][ny] = 2;
					q.offer(new Position(nx, ny));
					cnt++;
					index = 0;
					break;
				}
			}
			// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			if(index == 4) {
				int nx = x - dx[direction];
				int ny = y - dy[direction];
				// 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동 멈추
				if(graph[nx][ny] == 1) break; 

				// 한칸 후진할 수 있으면 후진 
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