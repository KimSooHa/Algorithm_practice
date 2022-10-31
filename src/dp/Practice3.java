package dp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice3 {
	// ���� �Ÿ�
	
	// ���ڿ� A(str1), ���ڿ� B(str2)
	public static String str1, str2;
		

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);

		str1 = sc.nextLine();
		str2 = sc.nextLine();
		
		// �ּ� ���� �Ÿ� ���
		System.out.println(editDist(str1, str2));


	}	// end of main


	// �ּ� ���� �Ÿ�(Edit Distance) ����� ���� ���̳��� ���α׷���
	private static int editDist(String str1, String str2) {
		
		int n = str1.length();
		int m = str2.length();
		
		// ���̳��� ���α׷����� ���� 2���� DP ���̺� �ʱ�ȭ
		int[][] dp = new int[n+1][m+1];
		
		// DP ���̺� �ʱ� ����(����(��)�� �ִ� ���ڿ��� ����(��)�� �ִ� ���ڿ��� �����ϴ� ����� ���)
		for(int i=1; i<=n; i++)	// ����(��)�� �ִ� ���ڿ�(������ ���ڿ�)
			dp[i][0] = i;
		
		for(int i=1; i<=m; i++)	// ����(��)�� �ִ� ���ڿ�(���� ���ڿ�)
			dp[0][i] = i;
		
		// �ּ� ���� �Ÿ� ���
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				
				// ���ڰ� ���ٸ�, ���� ���� �ش��ϴ� ���� �״�� ����
				if(str1.charAt(i-1) == str2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				// ���ڰ� �ٸ��ٸ�, �� ���� ��� �߿��� �ּڰ� ã��
				else	// ����(����), ����(����), ��ü(���� ��) �߿��� �ּ� ����� ã�� 1�� ���� ����
					dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
			}
		}
		
		
		return dp[n][m];
	}

}	// end of class
