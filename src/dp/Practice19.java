package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice19 {
	// 진우의 달 여행(Small)(백준 17484)
	
	static int n, m; // 행렬 크기
	static int[][] space;
	static int[] dx = {1, 1, 1}; // 수직 이동방향 값
	static int[] dy = {-1, 0, 1}; // 수평 이동방향 값
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		space = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) 
				space[i][j] = Integer.parseInt(st.nextToken());
		} // end of input
		
		// 각 열의 시작을 기준으로 달에 도착지점까지 값을 비교하며 더한 값 비교하여 최솟값 갱신하기
		for(int i=0; i<m; i++) {
			int ans = 0;
			ans += space[0][i]; // 시작 지점 값 더하고 시작
			dfs(0, i, ans, 3);
		}
		
		System.out.println(min);
					
	} // end of main

	private static void dfs(int x, int y, int ans, int dir) {
		
		// x가 space의 끝에 왔을 때 최솟값 갱신
		if(x == n-1) {
			if(ans < min)
				min = ans;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 가장 최근에 움직인 방향이 아니라면 && 이동할 방향이 이동가능한 범위안에 있다면
			if(dir != i && nx >= 0 && nx < n && ny >= 0 && ny < m)
				dfs(nx, ny, ans + space[nx][ny], i);
		}
	}
} // end of class
