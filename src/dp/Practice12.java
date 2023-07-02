package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice12 {
	// 점프(백준 1890)
	static int n;
	static int[][] board;
	static long[][] dp;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		dp = new long[n][n]; // 경로의 갯수는 2^63-1 이하이므로 long 타입
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1; // 경로의 갯수
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int next = board[i][j];
				
				// 0인 경우(가장 오른쪽 아래 칸)은 패스
				if(next == 0)
					break;
				
				// dp에 해당 위치까지 도착하는 경로의 개수 더하기
				if(j + next < n)
					dp[i][j + next] += dp[i][j];
				if(i + next < n)
					dp[i + next][j] += dp[i][j];
			}
		}
		
		System.out.println(dp[n-1][n-1]);
		
	}	// end of main
	

}	// end of class
