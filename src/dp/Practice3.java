package dp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice3 {
	// 편집 거리
	
	// 문자열 A(str1), 문자열 B(str2)
	public static String str1, str2;
		

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);

		str1 = sc.nextLine();
		str2 = sc.nextLine();
		
		// 최소 편집 거리 출력
		System.out.println(editDist(str1, str2));


	}	// end of main


	// 최소 편집 거리(Edit Distance) 계산을 위한 다이나믹 프로그래밍
	private static int editDist(String str1, String str2) {
		
		int n = str1.length();
		int m = str2.length();
		
		// 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
		int[][] dp = new int[n+1][m+1];
		
		// DP 테이블 초기 설정(왼쪽(열)에 있는 문자열을 위쪽(행)에 있는 문자열로 변경하는 비용을 계산)
		for(int i=1; i<=n; i++)	// 왼쪽(열)에 있는 문자열(편집할 문자열)
			dp[i][0] = i;
		
		for(int i=1; i<=m; i++)	// 위쪽(행)에 있는 문자열(만들 문자열)
			dp[0][i] = i;
		
		// 최소 편집 거리 계산
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				
				// 문자가 같다면, 왼쪽 위에 해당하는 수를 그대로 대입
				if(str1.charAt(i-1) == str2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				// 문자가 다르다면, 세 가지 경우 중에서 최솟값 찾기
				else	// 삽입(왼쪽), 삭제(위쪽), 교체(왼쪽 위) 중에서 최소 비용을 찾아 1을 더해 대입
					dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
			}
		}
		
		
		return dp[n][m];
	}

}	// end of class
