package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Practice5 {
	// 화성탐사(다익스트라)
	
	static StringTokenizer st;
	
	static final int INF = (int) 1e9;	// 무한대 의미(10억)
	// 각 노드에 연결되어 있는 노드에 대한 정보 배열
	static int[][] graph;
	// 최단거리 테이블 만들기
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

		// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
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
		
		// 전체 테스트케이스만큼 반복 
		for(int tc=0; tc<testCase; tc++) {
			// 노드의 개수를 입력받기
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];
			d = new int[n][n];
			// 전체 맵 정보 입력받기
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) 
					graph[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// 최단거리 테이블을 모두 무한으로 초기화
			for (int i = 0; i < n; i++) 
				Arrays.fill(d[i], INF);
			
			int x = 0, y = 0; // 시작 위치는 (0, 0)
			// 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
			PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐 생성
			pq.offer(new Node(x, y, graph[x][y]));
			d[x][y] = graph[x][y];
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int dist = node.getDistance();
				x = node.getX();
				y = node.getY();
				
				// 현재 노드가 이미 처리된 적 있는 노드라면 무시
				if(d[x][y] < dist)
					continue;
				// 현재 노드와 연결된 다른 인접한 노드들을 확인
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					// 맵의 범위를 벗어나는 경우 무시
					if(nx < 0 || nx >= n || ny < 0 || ny >= n) 
						continue;
						
					int cost = dist + graph[nx][ny];
					// 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
					if(cost < d[nx][ny]) {
						d[nx][ny] = cost; // 인접한 노드에 이전 비용 합해서 갱신하기
						pq.offer(new Node(nx, ny, cost));
					}
				}
			}
			System.out.println(d[n-1][n-1]);
		}
		
	}	// end of main	

}	// end of class
