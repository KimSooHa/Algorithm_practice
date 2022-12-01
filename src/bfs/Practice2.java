package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice2 {
	// 인구 이동(백준 16234)

	// 각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠동한 발생하는지 구하라.
	
	// 땅의 크기(N), 두 나라의 인구 차이 (L)명 ~ (R)명
	public static int n, l, r;
	public static StringTokenizer st;
	public static int totalCount = 0;
	
	// 모든 도시에 대한 최단거리 초기화
	public static int[][] graph = new int[50][50];
	public static int[][] unions = new int[50][50];	// 연합국가 인덱스 배열
	
	// 연합된 나라를 확인하기 위한 4방향의 위치
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	// 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루동안 연합이라고 한다.
	// 연합을 이루고 있는 각 칸의 인구수 = (연합의 인구수) / (연합을 이루고 있는 칸의 개수)
	
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
		
		
		// 그래프 및 최단 거리 테이블 초기화
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) 
				graph[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 더이상 인구 이동을 할 수 없을 때까지 반복
		while(true) {
			
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					unions[i][j] = -1;
				
			// 연합국가 인덱스로 구별
			int index = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(unions[i][j] == -1) {
						process(i, j, index);
						index++;
					}
				}
			}
			
			// 모든 인구 이동이 끝난 경우
			if(index == n*n)
				break;
			
			totalCount++;
		}
		// 인구 이동 횟수 출력
		System.out.println(totalCount);

	}	// end of main

	// 특정 위치에서 출발하여 모든 연합을 체크한 뒤에 데이터 갱신
	public static void process(int x, int y, int index) {
		
		// (x, y)의 위치와 연결된 나라(연합) 정보를 담는 리스트
		ArrayList<Position> united = new ArrayList<>();
		united.add(new Position(x, y));
		
		// 너비 우선 탐색(BFS)을 위한 큐 라이브러리 사용
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x, y));
		
		unions[x][y] = index;	// 현재 연합의 번호 할당
		int summary = graph[x][y];	// 현재 연합의 전체 인구 수
		int count = 1;	// 현재 연합의 국가 수

		// 큐가 빌 때까지 반복(BFS)
		while(!q.isEmpty()) {
			Position pos = q.poll();
			x = pos.getX();
			y = pos.getY();
			
			// 현재 위치에서 가지 방향을 확인하며
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 바로 옆에 있는 나라를 확인하여
				if(0<=nx && nx<n && 0<=ny && ny<n && unions[nx][ny] == -1) {
					
					// 옆에 있는 나라와 인구 차이가 L명 이상, R명 이하라면
					int gap = Math.abs(graph[nx][ny] - graph[x][y]);					
					if(l<=gap && gap<=r) {
						q.offer(new Position(nx, ny));
						// 연합에 추가하기
						unions[nx][ny] = index;
						summary += graph[nx][ny];
						count++;
						united.add(new Position(nx, ny));
					}
				}
			}
		}
		
		// 연합 국가끼리 인구를 분배
		for(int i=0; i<united.size(); i++) {
			x = united.get(i).getX();
			y = united.get(i).getY();
			graph[x][y] = summary/count;
		}
	}

}	// end of class
