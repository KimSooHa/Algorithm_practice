package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Practice9 {
	// 치즈(백준 2636)
	// 현재 치즈의 개수를 세어 준 다음 치즈 개수가 0이 아닐 때까지 BFS 탐색을 하며 치즈의 개수를 줄여나가기
	// 탐색은 [0,0] 부터 시작하여 치즈를 만나면 해당 치즈를 없애주고 치즈가 아니라면 큐에 넣어 근처에 있는 치즈 탐색 

	static int n, m;
	static boolean[][] visited; 
	static int[][] arr;
	static StringTokenizer st;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int time = 0; // 치즈가 녹아 없어지는데 걸리는 시간
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
		
		// cheese조각이 다 녹을때까지
		while(cheese != 0) {
			cheeseCnt = cheese;
			time++;
			visited = new boolean[n][m]; // 방문 여부 초기화
			bfs();
		}
		System.out.println(time);
		System.out.println(cheeseCnt);
		
	}	// end of main

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		// 현재 위치 방문처리
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();			
			
			// 4방향으로 확인
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];
				
				// 범위가 벗어날 경우
				if(0 > nx || nx >= n || 0 > ny || ny >= m || visited[nx][ny]) continue;
				visited[nx][ny] = true; // 방문처리
				if(arr[nx][ny] == 0)  // 치즈가 없는 칸이면 큐에 삽입
					q.offer(new int[] {nx, ny});					
				 else { // 치즈가 있는 칸이면
					cheese--; // 치즈 녹이기(치즈 조각 개수 줄이기)
					arr[nx][ny] = 0; // 빈칸 처리
				}
			}
		}
	}
	
}	// end of class
