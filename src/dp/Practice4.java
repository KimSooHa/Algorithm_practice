package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice4 {
	// 금광
	
	// 테스트 케이스 수(T), 배열의 크기(n, m)
	public static int t, n, m;

	// 입력받은 배열 초기화
	public static int[][] arr = new int[20][20];
	public static int[][] dp = new int[20][20];	// 다이나믹 프로그래밍을 위한 DP 테이블 초기화
	
	public static StringTokenizer st;
		

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<n; i++)
				for(int j=0; j<m; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			
			
			for(int i=0; i<n; i++)
				for(int j=0; j<m; j++)
					dp[i][j] = arr[i][j];
			
					
			for(int j=1; j<m; j++) {
				for(int i=0; i<n; i++) {
					
					// 이전 금 누적하기 위한 위치별 변수(왼쪽 위, 왼쪽 아래, 왼쪽)
					int leftUp, leftDown, left;
					
					if(i == 0)
						leftUp = 0;
					else
						leftUp = dp[i-1][j-1];
					
					if(i == n-1)
						leftDown = 0;
					else
						leftDown = dp[i+1][j-1];
					
					left = dp[i][j-1];
					
					dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));	// 이전 위치의 방향에서 가장 많은 금으로 누적하기
				}
			}
			
			// 금의 최대 크기
			int result = 0;
			
			// 각 행의 끝열의 금을 비교해 최대값으로 대입
			for(int i=0; i<n; i++)
				result = Math.max(result, dp[i][m-1]);
			
			System.out.println(result);

		}

	}	// end of main

}	// end of class
