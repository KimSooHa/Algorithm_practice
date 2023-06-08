package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Practice7 {
	// 보물섬(백준 2589)
	// 하나의 연결된 육지에서 가장 멀리 떨어져 있는 두 곳 찾기
	
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
	// 북, 동, 남, 서
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
		
		// 육지: L, 바다: W로 표시되어 있음
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 'L') {
					// 육지인 경우 방문배열 초기화(해당 위치의 보물과 다음에 찾을 보물 위치와 새로 비교하기 위해서)
					visit = new boolean[n][m];
					int value = solution(i, j); // 특정 위치의 보물 기준으로 가장 긴 거리 찾기
					result = Math.max(value, result); // 각 보물 위치간의 최단거리를 기준으로 가장 최단거리인 보물위치의 거리로 갱신 
				}
			}
		}
		System.out.println(result);
	} // end of main


	static int solution(int x, int y) {
		Queue<Position> q = new LinkedList<>();
		int val = 0;
		visit[x][y] = true; // 방문처리
		q.add(new Position(x, y, 0));
		while(!q.isEmpty()) {
			Position pos = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = pos.getX() + dx[i];
				int ny = pos.getY() + dy[i];
				// 다음 위치가 육지이면서 방문하지 않은 곳이면
				if(0 > nx || nx >= n || 0 > ny || ny >= m || visit[nx][ny] || map[nx][ny] == 'W') 
					continue;
				
				visit[nx][ny] = true; // 방문처리
				q.add(new Position(nx, ny, pos.getCnt()+1));
				val = Math.max(val, pos.getCnt()+1); // 긴 시간이 걸리는 보물간의 위치로 갱신					
			}
		}
		
		return val;
	}

}	// end of class