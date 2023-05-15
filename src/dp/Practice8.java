package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice8 {
	// 2xn 타일링(백준 11726)
	static int n;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[1000];
		dp[0] = 1;
		dp[1] = 2;
		
		for (int i = 2; i < n; i++) 
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		
		
		System.out.println(dp[n-1]);
	}	// end of main

}	// end of class
