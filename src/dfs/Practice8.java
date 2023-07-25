package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice8 {
	// 영역 구하기(백준 2583)
	
	static int m, n, k;
	static StringTokenizer st;
	
	static int[][] map; // 모눈종이
	static Queue<Position> q = new LinkedList<>();
	static List<Integer> list = new ArrayList<>();
	
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
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = x1; j < x2; j++) {
				for (int z = y1; z < y2; z++) 
					map[z][j] = 1; // 직사각형이 만들어지는 곳은 1로 변경
			}
		}
		
		for(int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					dfs(i, j);
				}
			}
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if(i != list.size()-1)
				sb.append(" ");
		}
		
		System.out.println(sb);
		
	}	// end of main

	public static void dfs(int i, int j) {
		
		q.offer(new Position(i, j));
		map[i][j] = 1;

		int count = 1;
		
		while (!q.isEmpty()) {
			
			Position pos = q.poll();
			int x = pos.getX();
			int y = pos.getY();
			
			for (int k = 0; k < 4; k++) {
				int nx = dx[k] + x;
				int ny = dy[k] + y;
				
				if(nx < 0 || nx >= m || ny < 0 || ny >= n || map[nx][ny] == 1)
					continue;
				
				q.offer(new Position(nx, ny));	
				map[nx][ny] = 1;
				count++;
			}
		}
		list.add(count);
	}
	
// 다른 방식의 풀이(재귀)
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		st = new StringTokenizer(br.readLine());
//		
//		m = Integer.parseInt(st.nextToken());
//		n = Integer.parseInt(st.nextToken());
//		k = Integer.parseInt(st.nextToken());
//		
//		map = new int[m][n];
//		
//		for(int i=0; i<k; i++) {
//			st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			int zx = Integer.parseInt(st.nextToken());
//			int zy = Integer.parseInt(st.nextToken());
//
//			
//			for (int j = x; j < zx; j++) {
//				for (int z = y; z < zy; z++) 
//					map[z][j] = 1; // 직사각형이 만들어지는 곳은 1로 변경
//			}
//			
//		}
//		
//		for(int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				if(map[i][j] == 0) {
//					cnt = 0; // 영역 개수 초기화
//					dfs(i, j);
//					list.add(cnt);
//				}
//			}
//		}
//		
//		Collections.sort(list); // 오름차순 정렬
//		
//		StringBuffer sb = new StringBuffer();
//		sb.append(list.size()).append("\n");
//		
//		for (int i = 0; i < list.size(); i++) 
//			sb.append(list.get(i)).append(" ");
//		
//		
//		System.out.println(sb);
//		
//	}	// end of main
//
//	public static void dfs(int x, int y) {
//		
//		map[x][y] = 1;
//		cnt++;
//		
//		for (int k = 0; k < 4; k++) {
//			int nx = dx[k] + x;
//			int ny = dy[k] + y;
//			
//			if(nx < 0 || nx >= m || ny < 0 || ny >= n || map[nx][ny] == 1)
//				continue;
//			
//			dfs(nx, ny);
//		}
//	}

}	// end of class