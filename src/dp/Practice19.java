package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice19 {
	// ������ �� ����(Small)(���� 17484)
	
	static int n, m; // ��� ũ��
	static int[][] space;
	static int[] dx = {1, 1, 1}; // ���� �̵����� ��
	static int[] dy = {-1, 0, 1}; // ���� �̵����� ��
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		space = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) 
				space[i][j] = Integer.parseInt(st.nextToken());
		} // end of input
		
		// �� ���� ������ �������� �޿� ������������ ���� ���ϸ� ���� �� ���Ͽ� �ּڰ� �����ϱ�
		for(int i=0; i<m; i++) {
			int ans = 0;
			ans += space[0][i]; // ���� ���� �� ���ϰ� ����
			dfs(0, i, ans, 3);
		}
		
		System.out.println(min);
					
	} // end of main

	private static void dfs(int x, int y, int ans, int dir) {
		
		// x�� space�� ���� ���� �� �ּڰ� ����
		if(x == n-1) {
			if(ans < min)
				min = ans;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// ���� �ֱٿ� ������ ������ �ƴ϶�� && �̵��� ������ �̵������� �����ȿ� �ִٸ�
			if(dir != i && nx >= 0 && nx < n && ny >= 0 && ny < m)
				dfs(nx, ny, ans + space[nx][ny], i);
		}
	}
} // end of class
