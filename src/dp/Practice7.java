package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice7 {
	// 퇴사(백준 14501)
	static int n;
	static int[] t;
	static int[] p;
	static int[] dp; // DP 테이블 초기화
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
		
		// 배열을 뒤에서부터 거꾸로 확인
		for(int i=n-1; i>=0; i--) {
			int time = t[i]+i;
			// 상담이 기간 안에 끝나는 경우
			if(time<=n) {
				// 점화식에 맞게, 현재까지의 최고 이익 계산
				dp[i] = Math.max(p[i]+dp[time], maxValue);
				maxValue = dp[i];
			}
			// 상담이 기간을 벗어나는 경우
			else
				dp[i] = maxValue;
		}
		
		System.out.println(maxValue);
	}	// end of main

}	// end of class
