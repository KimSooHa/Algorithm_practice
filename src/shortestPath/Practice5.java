package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Practice5 {
	// ȭ��Ž��(���ͽ�Ʈ��)
	
	static StringTokenizer st;
	
	static final int INF = (int) 1e9;	// ���Ѵ� �ǹ�(10��)
	// �� ��忡 ����Ǿ� �ִ� ��忡 ���� ���� �迭
	static int[][] graph;
	// �ִܰŸ� ���̺� �����
	static int[][] d;
	static int testCase, n;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Node implements Comparable<Node> {
		
		private int x;
		private int y;
		private int distance;

		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getDistance() {
			return distance;
		}

		// �Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
		@Override
		public int compareTo(Node other) {
			if(this.distance < other.distance)
				return -1;
			
			return 1;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		// ��ü �׽�Ʈ���̽���ŭ �ݺ� 
		for(int tc=0; tc<testCase; tc++) {
			// ����� ������ �Է¹ޱ�
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];
			d = new int[n][n];
			// ��ü �� ���� �Է¹ޱ�
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) 
					graph[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// �ִܰŸ� ���̺��� ��� �������� �ʱ�ȭ
			for (int i = 0; i < n; i++) 
				Arrays.fill(d[i], INF);
			
			int x = 0, y = 0; // ���� ��ġ�� (0, 0)
			// ���� ���� ���� ���� �ִ� ��δ� 0���� �����Ͽ�, ť�� ����
			PriorityQueue<Node> pq = new PriorityQueue<>(); // �켱���� ť ����
			pq.offer(new Node(x, y, graph[x][y]));
			d[x][y] = graph[x][y];
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int dist = node.getDistance();
				x = node.getX();
				y = node.getY();
				
				// ���� ��尡 �̹� ó���� �� �ִ� ����� ����
				if(d[x][y] < dist)
					continue;
				// ���� ���� ����� �ٸ� ������ ������ Ȯ��
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					// ���� ������ ����� ��� ����
					if(nx < 0 || nx >= n || ny < 0 || ny >= n) 
						continue;
						
					int cost = dist + graph[nx][ny];
					// ���� ��带 ���ļ�, �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
					if(cost < d[nx][ny]) {
						d[nx][ny] = cost; // ������ ��忡 ���� ��� ���ؼ� �����ϱ�
						pq.offer(new Node(nx, ny, cost));
					}
				}
			}
			System.out.println(d[n-1][n-1]);
		}
		
	}	// end of main	

}	// end of class
