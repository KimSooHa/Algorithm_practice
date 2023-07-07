package dp;

public class Practice14 {
	// 등굣길(프로그래머스)

	public static int solution(int m, int n, int[][] puddles) {

		int dp[][] = new int[n][m];

		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0)
					continue;

				int right = 0;
				int down = 0;

				if (checkPuddles(i, j, puddles)) 
					continue;
				
				if (i > 0)
					down = dp[i - 1][j];
				if (j > 0)
					right = dp[i][j - 1];

				// 효율성 테스트 때문에 모듈러 연산 필요없는 경우는 그냥 대입하기
				dp[i][j] = (down + right) >= 1000000007 ? (down + right) % 1000000007 : down + right;
			}
		}

		return dp[n - 1][m - 1];
	}

	public static boolean checkPuddles(int i, int j, int[][] puddles) {

		for (int k = 0; k < puddles.length; k++) {
			if (i + 1 == puddles[k][1] && j + 1 == puddles[k][0])
				return true;
		}
		return false;
	}

	public static void main(String[] args) {

		int m = 4;
		int n = 3;
		int[][] puddles = {{2,2}};
		System.out.println(solution(m, n, puddles));

	} // end of main

} // end of class
