package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice6 {
	// ���� ����(���� 2468)
	
	static int n;
	static int[][] map;
	static boolean[][] checked;
	static int answer;
	
	static StringTokenizer st;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
    
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		int maxHeight = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > maxHeight)
					maxHeight = map[i][j];
			}
		}
		
		int max = 0;
		
		// ��� ���� Ž��
		for (int height = 0; height <= maxHeight; height++) {
			checked = new boolean[n][n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// ���� ���� Ž��
					if(!checked[i][j] && map[i][j] > height)
						cnt += dfs(i, j, height); // �ش� �������� Ž�� ����
				}
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
		
	}

	// ���� ���� Ž��
	public static int dfs(int x, int y, int height) {
		checked[x][y] = true;
		// 4���� �������� ���� ���� Ž��
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// �迭 �ۿ� �ְų� �湮�� �����̸� continue
			if(0 > nx || nx >= n || 0 > ny || ny >= n || checked[nx][ny]) continue;
			if(map[nx][ny] > height) // ���� ���̿� ����� �ʴ� �����̸� Ž��
				dfs(nx, ny, height);
		}
		return 1;
	}

}	// end of class
