package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice11 {
	// 포도주 시식(백준 2156)
	// => 와인 3잔을 연속해서 마실 수 없기 때문에 현재 위치에서 OOX, OX< XOO의 경우 어떤 것이 가장 많이 먹을 수 있는 경우인지 판단하기(맨 오른쪽이 현재 위치)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wines = new int[n];  //포도주 잔에 들어있는 포도주의 양
		int[] dp = new int[n];
		
		for (int i = 0; i < n; i++)
			wines[i] = Integer.parseInt(br.readLine());
		
		// dp[0], dp[1], dp[2]는 예외처리
		dp[0] = wines[0];
		
		for (int i = 1; i < n; i++) {
			if(i == 1) {
				dp[1] = wines[0] + wines[1];
				continue;
			}
			if(i == 2) {
				dp[2] = Math.max(dp[1], Math.max(wines[0] + wines[2], wines[1] + wines[2]));
				continue;
			}
			// OOX: dp[i-1], OXO: dp[i-2] + wines[i], XOO: dp[i-2] + wines[i-1] + wines[i]
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wines[i], dp[i-3] + wines[i-1] + wines[i]));
				
		}
		
		System.out.println(dp[n-1]);
	}	// end of main

}	// end of class
