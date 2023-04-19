package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice11 {
	// 부녀회장이 될테야(백준 2775) 
	public static int[][] dp = new int[15][15];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			for(int i=0; i<=k; i++) {
				for(int j=0; j<=n; j++) {
					if(i==0)
						dp[i][j] = j;
					else
						dp[i][j] = sum(i-1, j);
				}
			}
			
			System.out.println(dp[k][n]);
		}
		
	}	// end of main
	
	public static int sum(int x, int y) {
		int sum = 0;
		
		for(int j=0; j<=y; j++) 
			sum += dp[x][j];
		
		return sum;
	}
	
}	// end of class