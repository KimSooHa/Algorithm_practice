package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice15 {
	// 섬의 개수(백준 4963)

	static int w, h; // 지도의 너비(w), 높이(h)
	static int[][] graph;
	static StringTokenizer st;
	static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
	static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
	static boolean[][] isVisited;
	static int island;

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
		StringBuffer sb = new StringBuffer();
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			island = 0;
			graph = new int[h][w];
			isVisited = new boolean[h][w]; 

			if (w == 0 && h == 0) 
				break;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (graph[i][j] == 1 && !isVisited[i][j]) 
						dfs(i, j);	
				}
			}
			sb.append(island).append("\n");
		}

		System.out.println(sb);

	} // end of main

	private static void dfs(int i, int j) {
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(i, j));
		isVisited[i][j] = true;
		while(!q.isEmpty()) {
			Position pos = q.poll();
			int x = pos.getX();
			int y = pos.getY();
			
			for(int k=0; k<8; k++) {
				int nx = dx[k] + x;
				int ny = dy[k] + y;
				
				if(nx < 0 || nx >= h || ny < 0 || ny >= w || isVisited[nx][ny] || graph[nx][ny] == 0)
					continue;
				
				isVisited[nx][ny] = true;
				q.offer(new Position(nx, ny));
			}
		}
		island++;
	}

} // end of class
