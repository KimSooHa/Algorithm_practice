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
	// 경쟁적 전염(백준 18450)
	
	static int n, k;
	static int[][] graph;
	static ArrayList<Virus> viruses = new ArrayList<>();
	static StringTokenizer st;
	
	// 이동할 네 가지 방향 정의(상, 하, 좌, 우)
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	
	public static class Virus implements Comparable<Virus> {
		
		private int index; // 바이러스 종류
		private int second; // 시간
		private int x; // 위치X
		private int y; // 위치Y
		
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

		// 정렬 기준은 '번호가 낮은 순서'
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
		
		// 맵 정보 입력받기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)  {
				graph[i][j] = Integer.parseInt(st.nextToken());
				// 해당 위치에 바이러스가 존재하는 경우
				if(graph[i][j] != 0)
					// 바이러스 종류, 시간, 위치X, 위치Y 삽입
					viruses.add(new Virus(graph[i][j], 0, i, j));
			}
		}
		
		// 정렬 이후에 큐로 옮기기(낮은 번호의 바이러스가 먼저 증식)
		Collections.sort(viruses);
		
		// 큐 구현을 위해 queue 라이브러리 사용
		Queue<Virus> q = new LinkedList<>();
		for(int i=0; i<viruses.size(); i++)
			q.offer(viruses.get(i));
		
		st = new StringTokenizer(br.readLine());
		int targetS = Integer.parseInt(st.nextToken());
		int targetX = Integer.parseInt(st.nextToken())-1; // 문제와 배열의 인덱스 맞추기
		int targetY = Integer.parseInt(st.nextToken())-1; // 문제와 배열의 인덱스 맞추기
		
		// BFS 수행
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			
			// 정확히 second만큼 초가 지나거나, 큐가 빌 때까지 반복
			if(virus.getSecond() == targetS)
				break;
			
			// 현재 노드에서 주변 4가지 위치를 각각 확인
			for (int i = 0; i < 4; i++) {
				int nx = virus.getX() + dx[i];
				int ny = virus.getY() + dy[i];
				
				// 해당 위치로 이동할 수 있는 경우
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					// 아직 방문하지 않은 위치라면, 그 위치에 바이러스 넣기
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
