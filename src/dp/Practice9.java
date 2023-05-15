package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice9 {
	// ������ ��(���� 11057)
	// ���� ���� N�� �־����� ��, ������ ���� ������ ���ϴ� ���α׷� �ۼ�
	static int n;
	static int[][] dp; // N�� �ڸ��� ���� �� ���� �ǵ��� ���ڰ� k�� ���� ����� ��

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1][10];
		
		for (int i = 0; i < 10; i++)
			dp[0][i] = 1;
		
		// �̹� �ڸ��� n-1������ j���� ������ 9������ ��  
		for (int i = 1; i <= n; i++) {
			for(int j=0; j<10; j++) {
				for (int k = j; k < 10; k++) 
					dp[i][j] += (dp[i-1][k]) % 10007;
			}
		}
		// ���̰� n�� ������ ���� ������ 10007�� ���� �������� ���
		System.out.println(dp[n][0]);
	}	// end of main

}	// end of class
