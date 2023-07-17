package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice12 {
	// 양(백준 3184)
	
	static int r, c;
	static StringTokenizer st;
	static int totalSheep = 0, totalWolf = 0;
	
	static char[][] map; // 마당
	static boolean[][] visited;  // 방문 여부
	static Queue<Position> q = new LinkedList<>(); 
	
	// 4방향의 위치
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static class Position {
		
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i=0; i<r; i++) 
			map[i] = br.readLine().toCharArray();
			
		for(int i=0; i<r; i++) {	
			for(int j=0; j<c; j++) {
				if(!visited[i][j] && (map[i][j] == 'o' || map[i][j] == 'v'))
					bfs(i, j);
			}
		}
		
		System.out.println(totalSheep + " " + totalWolf);
	}	// end of main

	public static void bfs(int i, int j) {
		
		q.offer(new Position(i, j));
		visited[i][j] = true;
		
		int wolf = 0;
		int sheep = 0;
		while (!q.isEmpty()) {
			
			Position pos = q.poll();
			int x = pos.getX();
			int y = pos.getY();
			
			if(map[x][y] == 'v')
				wolf++;
			if(map[x][y] == 'o')
				sheep++;
			
			for (int k = 0; k < 4; k++) {
				int nx = dx[k] + x;
				int ny = dy[k] + y;
				
				if(nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny] || map[nx][ny] == '#')
					continue;
				
				q.offer(new Position(nx, ny));	
				visited[nx][ny] = true;
			}
			
		}
		if(wolf < sheep)
			totalSheep += sheep;
		else
			totalWolf += wolf;
	}

}	// end of class
