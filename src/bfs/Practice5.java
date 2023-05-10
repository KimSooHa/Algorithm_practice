package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice5 {
	// ������ ����(���� 18450)
	
	static int n, k;
	static int[][] graph;
	static ArrayList<Virus> viruses = new ArrayList<>();
	static StringTokenizer st;
	
	// �̵��� �� ���� ���� ����(��, ��, ��, ��)
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	
	public static class Virus implements Comparable<Virus> {
		
		private int index; // ���̷��� ����
		private int second; // �ð�
		private int x; // ��ġX
		private int y; // ��ġY
		
		public Virus(int index, int second, int x, int y) {
			this.index = index;
			this.second = second;
			this.x = x;
			this.y = y;
		}
		
		public int getIndex() {
			return index;
		}

		public int getSecond() {
			return second;
		}

		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}

		// ���� ������ '��ȣ�� ���� ����'
		@Override
		public int compareTo(Virus other) {
			if(other.index - this.index > 0)
				return -1;
			
			return 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		graph = new int[n][n];
		
		// �� ���� �Է¹ޱ�
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)  {
				graph[i][j] = Integer.parseInt(st.nextToken());
				// �ش� ��ġ�� ���̷����� �����ϴ� ���
				if(graph[i][j] != 0)
					// ���̷��� ����, �ð�, ��ġX, ��ġY ����
					viruses.add(new Virus(graph[i][j], 0, i, j));
			}
		}
		
		// ���� ���Ŀ� ť�� �ű��(���� ��ȣ�� ���̷����� ���� ����)
		Collections.sort(viruses);
		
		// ť ������ ���� queue ���̺귯�� ���
		Queue<Virus> q = new LinkedList<>();
		for(int i=0; i<viruses.size(); i++)
			q.offer(viruses.get(i));
		
		st = new StringTokenizer(br.readLine());
		int targetS = Integer.parseInt(st.nextToken());
		int targetX = Integer.parseInt(st.nextToken())-1; // ������ �迭�� �ε��� ���߱�
		int targetY = Integer.parseInt(st.nextToken())-1; // ������ �迭�� �ε��� ���߱�
		
		// BFS ����
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			
			// ��Ȯ�� second��ŭ �ʰ� �����ų�, ť�� �� ������ �ݺ�
			if(virus.getSecond() == targetS)
				break;
			
			// ���� ��忡�� �ֺ� 4���� ��ġ�� ���� Ȯ��
			for (int i = 0; i < 4; i++) {
				int nx = virus.getX() + dx[i];
				int ny = virus.getY() + dy[i];
				
				// �ش� ��ġ�� �̵��� �� �ִ� ���
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					// ���� �湮���� ���� ��ġ���, �� ��ġ�� ���̷��� �ֱ�
					if(graph[nx][ny] == 0) {
						graph[nx][ny] = virus.getIndex();
						q.offer(new Virus(virus.getIndex(), virus.getSecond()+1, nx, ny));
					}
				}
			}
		}
		
		System.out.println(graph[targetX][targetY]);

	}	// end of main


}	// end of class
