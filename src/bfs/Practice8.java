package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Practice8 {
	// 나이트의 이동(백준 7562)

	public static class Position {
		int x;
		int y;
		int cnt;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
			this.cnt = 0;
		}

		public Position(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}

	static int t, l;
	static boolean[][] visited; 
	static Position position[] = new Position[2];
	static StringTokenizer st;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			l = Integer.parseInt(br.readLine());
			visited = new boolean[l][l];
						
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				position[i] = new Position(start, end);
			}			
			sb.append(bfs(position) + "\n");
		}
		
		System.out.println(sb);
	}	// end of main

	public static int bfs(Position[] position) {
		Queue<Position> q = new LinkedList<>();
		q.offer(position[0]);
		// 현재 위치 방문처리
		visited[position[0].x][position[0].y] = true;
		
		while(!q.isEmpty()) {
			Position pos = q.poll();
		
			// 종료 조건
			if(pos.x == position[1].x && pos.y == position[1].y)
				return pos.cnt;
			
			
			for (int i = 0; i < 8; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				
				// 범위가 벗어날 경우
				if(0 > nx || nx >= l || 0 > ny || ny >= l || visited[nx][ny]) continue;
					
				visited[nx][ny] = true;
				q.offer(new Position(nx, ny, pos.cnt+1));
				
			}
		}
		return 0;
	}
	
}	// end of class
