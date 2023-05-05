package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice4 {
	// 미로 탈출
	
	static int n, m;
	static int[][] graph;
	static StringTokenizer st;
	
	// 이동할 네 가지 방향 정의(상, 하, 좌, 우)
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	
	public static class Node {
		
		private int x;
		private int y;
		
		public Node(int x, int y) {
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
	
	// BFS 함수 정의
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		
		// 큐가 빌 때까지 반복
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX();
			y = node.getY();
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					
				// 괴물이 없는경우(0) 무시
				if(graph[nx][ny] == 0) continue;
				
				// 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
				if(graph[nx][ny] == 1) {
					graph[nx][ny] = graph[x][y] + 1;
					q.offer(new Node(nx, ny));
				}
			}
		}
		return graph[n-1][m-1];
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		
		// 맵 정보 입력받기
		for (int i = 0; i < n; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < m; j++) 
				graph[i][j] = arr[j].charAt(0) - '0';
		}
		
		System.out.println(bfs(0, 0));

	}	// end of main


}	// end of class
