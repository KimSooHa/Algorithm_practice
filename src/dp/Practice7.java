package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice7 {
	// ���(���� 14501)
	static int n;
	static int[] t;
	static int[] p;
	static int[] dp; // DP ���̺� �ʱ�ȭ
	static int maxValue;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		t = new int[n];
		p = new int[n];
		dp = new int[n+1];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		// �迭�� �ڿ������� �Ųٷ� Ȯ��
		for(int i=n-1; i>=0; i--) {
			int time = t[i]+i;
			// ����� �Ⱓ �ȿ� ������ ���
			if(time<=n) {
				// ��ȭ�Ŀ� �°�, ��������� �ְ� ���� ���
				dp[i] = Math.max(p[i]+dp[time], maxValue);
				maxValue = dp[i];
			}
			// ����� �Ⱓ�� ����� ���
			else
				dp[i] = maxValue;
		}
		
		System.out.println(maxValue);
	}	// end of main

}	// end of class
