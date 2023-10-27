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
	// ���� ���ø鼭 �ɾ��(���� 9205)
	
	static int t, n; // �׽�Ʈ���̽�(t), ������ ����(n)
	static StringTokenizer st;
	
	static int homeX, homeY, festivalX, festivalY; // ����̳� ��(x, y) �佺Ƽ��(x, y)
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
			List<Position> list = new ArrayList<>(); // ������
			
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
		Queue<Position> q = new LinkedList<>(); // �̵��� ��ġ
		q.add(new Position(homeX, homeY));
		boolean[] isVisited = new boolean[n];
		while(!q.isEmpty()) {
			Position p = q.poll();
			int px = p.x, py = p.y;
			int distance = Math.abs(px - festivalX) + Math.abs(py - festivalY); // ������ġ�� �������� �Ÿ�
			if(distance <= beers * 50)
				return true;

			for (int i = 0; i < n; i++) {
				if(isVisited[i]) continue;
				
				int nx = list.get(i).x, ny = list.get(i).y;
				if(Math.abs(px - nx) + Math.abs(py- ny) <= beers * 50) { // ���� ��ġ���� ���� ��ġ���� �̵��� ��ŭ�� ���� ���� �ִٸ� �̵�ó�� 
					isVisited[i] = true;
					q.add(new Position(nx, ny));
				}
			}
		}
		return false;
	}
}	// end of class
