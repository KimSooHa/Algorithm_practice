package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice6 {
	// 안전 영역(백준 2468)
	
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
		
		// 모든 지역 탐색
		for (int height = 0; height <= maxHeight; height++) {
			checked = new boolean[n][n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 안전 영역 탐지
					if(!checked[i][j] && map[i][j] > height)
						cnt += dfs(i, j, height); // 해당 안전영역 탐색 시작
				}
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
		
	}

	// 안전 영역 탐색
	public static int dfs(int x, int y, int height) {
		checked[x][y] = true;
		// 4가지 방향으로 안전 영역 탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 배열 밖에 있거나 방문한 지역이면 continue
			if(0 > nx || nx >= n || 0 > ny || ny >= n || checked[nx][ny]) continue;
			if(map[nx][ny] > height) // 물의 높이에 잠기지 않는 지역이면 탐색
				dfs(nx, ny, height);
		}
		return 1;
	}

}	// end of class
