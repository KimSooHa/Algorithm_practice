package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Practice9 {
	// 숫자판 점프(백준 2210)
	
	static StringTokenizer st;
	static String[][] map; // 숫자판
	static Set<String> set = new HashSet<>();
	
	// 4방향의 위치
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new String[5][5];
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = st.nextToken();
			}
		}
		
		for(int i = 0; i < 5; i++) 
			for (int j = 0; j < 5; j++) 
				dfs(i, j, 1, map[i][j]);
			
		
		System.out.println(set.size());
		
	}	// end of main

	public static void dfs(int x, int y, int cnt, String tmp) {

		// 숫자 6개가 다차면 리스트에 추가
		if(cnt == 6) {
			set.add(tmp);
			return;
		}
		
		for (int k = 0; k < 4; k++) {
			int nx = dx[k] + x;
			int ny = dy[k] + y;
			
			if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
			
			dfs(nx, ny, cnt+1, tmp + map[nx][ny]);
		}
	}

}	// end of class