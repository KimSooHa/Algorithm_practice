package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice4 {
	// �ݱ�
	
	// �׽�Ʈ ���̽� ��(T), �迭�� ũ��(n, m)
	public static int t, n, m;

	// �Է¹��� �迭 �ʱ�ȭ
	public static int[][] arr = new int[20][20];
	public static int[][] dp = new int[20][20];	// ���̳��� ���α׷����� ���� DP ���̺� �ʱ�ȭ
	
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
					
					// ���� �� �����ϱ� ���� ��ġ�� ����(���� ��, ���� �Ʒ�, ����)
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
					
					dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));	// ���� ��ġ�� ���⿡�� ���� ���� ������ �����ϱ�
				}
			}
			
			// ���� �ִ� ũ��
			int result = 0;
			
			// �� ���� ������ ���� ���� �ִ밪���� ����
			for(int i=0; i<n; i++)
				result = Math.max(result, dp[i][m-1]);
			
			System.out.println(result);

		}

	}	// end of main

}	// end of class
