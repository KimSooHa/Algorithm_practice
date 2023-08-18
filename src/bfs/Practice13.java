package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice13 {
	// 토마토(백준 7569)
	
	static int m, n, h; // 상자의 크기(m ,n), 상자의 수(h)
	static StringTokenizer st;
	
	static int[][][] map; // 상자
	static Queue<Position> q = new LinkedList<>(); 
	
	// 6방향을 나타내기 위한 배열
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
						q.add(new Position(i, j, k)); // bfs 시작하는 노드 큐에 추가
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
		// 최대값을 구하기 위한 변수
		int result = Integer.MIN_VALUE;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					// 하나라도 익지 않은 토마토가 있다면 -1 반환
					if(map[i][j][k] == 0)
						return -1;
					
					// 토마토가 익는데 걸리는 시간을 구함
					result = Math.max(result, map[i][j][k]);
				}
			}
		}
		// 최대값이 1이라면 원래부터 모두 익었었던 토마토들
		if(result == 1)
			return 0;
		else // 걸린 일수
			return result - 1;
	}
	
	private static boolean checkPosition(int z, int x, int y) {
		// 주어진 범위 밖인지 검사
		if(x < 0 || x >= n || y < 0 || y >= m || z < 0 || z >= h)
			return false;
		
		// 아직 익지 않은 토마토라면 true 반환
		if(map[z][x][y] == 0)
			return true;

		// 이미 익어있거나 빈 자리라면 false 반환
		return false;
	}

}	// end of class
