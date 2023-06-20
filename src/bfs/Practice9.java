package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Practice9 {
	// ġ��(���� 2636)
	// ���� ġ���� ������ ���� �� ���� ġ�� ������ 0�� �ƴ� ������ BFS Ž���� �ϸ� ġ���� ������ �ٿ�������
	// Ž���� [0,0] ���� �����Ͽ� ġ� ������ �ش� ġ� �����ְ� ġ� �ƴ϶�� ť�� �־� ��ó�� �ִ� ġ�� Ž�� 

	static int n, m;
	static boolean[][] visited; 
	static int[][] arr;
	static StringTokenizer st;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int time = 0; // ġ� ��� �������µ� �ɸ��� �ð�
	static int cheese = 0;
	static int cheeseCnt = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) cheese++;
			}
		}
		
		// cheese������ �� ����������
		while(cheese != 0) {
			cheeseCnt = cheese;
			time++;
			visited = new boolean[n][m]; // �湮 ���� �ʱ�ȭ
			bfs();
		}
		System.out.println(time);
		System.out.println(cheeseCnt);
		
	}	// end of main

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		// ���� ��ġ �湮ó��
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();			
			
			// 4�������� Ȯ��
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];
				
				// ������ ��� ���
				if(0 > nx || nx >= n || 0 > ny || ny >= m || visited[nx][ny]) continue;
				visited[nx][ny] = true; // �湮ó��
				if(arr[nx][ny] == 0)  // ġ� ���� ĭ�̸� ť�� ����
					q.offer(new int[] {nx, ny});					
				 else { // ġ� �ִ� ĭ�̸�
					cheese--; // ġ�� ���̱�(ġ�� ���� ���� ���̱�)
					arr[nx][ny] = 0; // ��ĭ ó��
				}
			}
		}
	}
	
}	// end of class
