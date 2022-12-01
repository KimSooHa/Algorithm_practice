package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice2 {
	// �α� �̵�(���� 16234)

	// �� ������ �α����� �־����� ��, �α� �̵��� ��ĥ���� �߻��ϴ��� ���϶�.
	
	// ���� ũ��(N), �� ������ �α� ���� (L)�� ~ (R)��
	public static int n, l, r;
	public static StringTokenizer st;
	public static int totalCount = 0;
	
	// ��� ���ÿ� ���� �ִܰŸ� �ʱ�ȭ
	public static int[][] graph = new int[50][50];
	public static int[][] unions = new int[50][50];	// ���ձ��� �ε��� �迭
	
	// ���յ� ���� Ȯ���ϱ� ���� 4������ ��ġ
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	// ���漱�� �����־� ������ ĭ���� �̿��� �̵��� �� ������, �� ���� ���� �Ϸ絿�� �����̶�� �Ѵ�.
	// ������ �̷�� �ִ� �� ĭ�� �α��� = (������ �α���) / (������ �̷�� �ִ� ĭ�� ����)
	
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
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		
		// �׷��� �� �ִ� �Ÿ� ���̺� �ʱ�ȭ
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) 
				graph[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// ���̻� �α� �̵��� �� �� ���� ������ �ݺ�
		while(true) {
			
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					unions[i][j] = -1;
				
			// ���ձ��� �ε����� ����
			int index = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(unions[i][j] == -1) {
						process(i, j, index);
						index++;
					}
				}
			}
			
			// ��� �α� �̵��� ���� ���
			if(index == n*n)
				break;
			
			totalCount++;
		}
		// �α� �̵� Ƚ�� ���
		System.out.println(totalCount);

	}	// end of main

	// Ư�� ��ġ���� ����Ͽ� ��� ������ üũ�� �ڿ� ������ ����
	public static void process(int x, int y, int index) {
		
		// (x, y)�� ��ġ�� ����� ����(����) ������ ��� ����Ʈ
		ArrayList<Position> united = new ArrayList<>();
		united.add(new Position(x, y));
		
		// �ʺ� �켱 Ž��(BFS)�� ���� ť ���̺귯�� ���
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x, y));
		
		unions[x][y] = index;	// ���� ������ ��ȣ �Ҵ�
		int summary = graph[x][y];	// ���� ������ ��ü �α� ��
		int count = 1;	// ���� ������ ���� ��

		// ť�� �� ������ �ݺ�(BFS)
		while(!q.isEmpty()) {
			Position pos = q.poll();
			x = pos.getX();
			y = pos.getY();
			
			// ���� ��ġ���� ���� ������ Ȯ���ϸ�
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// �ٷ� ���� �ִ� ���� Ȯ���Ͽ�
				if(0<=nx && nx<n && 0<=ny && ny<n && unions[nx][ny] == -1) {
					
					// ���� �ִ� ����� �α� ���̰� L�� �̻�, R�� ���϶��
					int gap = Math.abs(graph[nx][ny] - graph[x][y]);					
					if(l<=gap && gap<=r) {
						q.offer(new Position(nx, ny));
						// ���տ� �߰��ϱ�
						unions[nx][ny] = index;
						summary += graph[nx][ny];
						count++;
						united.add(new Position(nx, ny));
					}
				}
			}
		}
		
		// ���� �������� �α��� �й�
		for(int i=0; i<united.size(); i++) {
			x = united.get(i).getX();
			y = united.get(i).getY();
			graph[x][y] = summary/count;
		}
	}

}	// end of class
