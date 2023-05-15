package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice9 {
	// 오르막 수(백준 11057)
	// 수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램 작성
	static int n;
	static int[][] dp; // N개 자리의 숫자 중 가장 맨뒤의 숫자가 k일 때의 경우의 수

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1][10];
		
		for (int i = 0; i < 10; i++)
			dp[0][i] = 1;
		
		// 이번 자릿수 n-1에서의 j부터 마지막 9까지의 합  
		for (int i = 1; i <= n; i++) {
			for(int j=0; j<10; j++) {
				for (int k = j; k < 10; k++) 
					dp[i][j] += (dp[i-1][k]) % 10007;
			}
		}
		// 길이가 n인 오르막 수의 개수를 10007로 나눈 나머지값 출력
		System.out.println(dp[n][0]);
	}	// end of main

}	// end of class
