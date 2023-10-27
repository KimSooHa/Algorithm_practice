package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice14 {
	// 맥주 마시면서 걸어가기(백준 9205)
	
	static int t, n; // 테스트케이스(t), 편의점 개수(n)
	static StringTokenizer st;
	
	static int homeX, homeY, festivalX, festivalY; // 상근이네 집(x, y) 페스티벌(x, y)
	static int beers = 20;
	
	public static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			List<Position> list = new ArrayList<>(); // 편의점
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}			
			
			st = new StringTokenizer(br.readLine());
			festivalX = Integer.parseInt(st.nextToken());
			festivalY = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(list) ? "happy\n" : "sad\n");
		}
		
		System.out.print(sb);
		
	}	// end of main

	public static boolean bfs(List<Position> list) {
		Queue<Position> q = new LinkedList<>(); // 이동할 위치
		q.add(new Position(homeX, homeY));
		boolean[] isVisited = new boolean[n];
		while(!q.isEmpty()) {
			Position p = q.poll();
			int px = p.x, py = p.y;
			int distance = Math.abs(px - festivalX) + Math.abs(py - festivalY); // 현재위치와 목적지의 거리
			if(distance <= beers * 50)
				return true;

			for (int i = 0; i < n; i++) {
				if(isVisited[i]) continue;
				
				int nx = list.get(i).x, ny = list.get(i).y;
				if(Math.abs(px - nx) + Math.abs(py- ny) <= beers * 50) { // 현재 위치에서 다음 위치까지 이동할 만큼의 맥주 양이 있다면 이동처리 
					isVisited[i] = true;
					q.add(new Position(nx, ny));
				}
			}
		}
		return false;
	}
}	// end of class
