package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice13 {
	// 이동하기(백준 11048)
	static int n, m;
	static int[][] maze;
	static int[][] dp;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maze = new int[n][m];
		dp = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = maze[0][0]; // 시작 위치
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				if(i == 0 && j == 0) continue;
				
				int right = 0;
				int down = 0;
				int rightDown = 0;
				
				// dp에 해당 위치까지 도달가능한 경로의 사탕 갯수 더하기
				if(0 < i && 0 < j)
					rightDown = dp[i-1][j-1];
				if(0 < i)
					down = dp[i-1][j];
				if(0 < j)
					right = dp[i][j-1];
				
				// 기존 위치까지 도달가능한 경로의 사탕개수 최댓값 + 현재위치의 사탕개수
				dp[i][j] = Math.max(rightDown, Math.max(down, right)) + maze[i][j];
			}
		}
		
		System.out.println(dp[n-1][m-1]);
		
	}	// end of main
}	// end of class
