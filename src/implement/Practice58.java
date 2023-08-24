package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice58 {
	// Æä±× ¼ÖÅ×¸®¾î(¹éÁØ 9207)

	static int n; // Å×½ºÆ®ÄÉÀÌ½º °³¼ö
	static char[][] map;
	static int x = 5, y = 9, remainPin, move;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < n; tc++) {
			map = new char[x][y];
			int pin = 0;
			
			// .: ºóÄ­, o: ÇÉÀÌ ²ÈÇôÀÖ´Â Ä­, #: ±¸¸ÛÀÌ ¾ø´Â Ä­
			for (int i = 0; i < x; i++) {
				String str = br.readLine();
				for (int j = 0; j < y; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'o')
						pin++;					
				}
			}
			
			remainPin = pin;
			
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if(map[i][j] == 'o')
						dfs(i, j, pin, 0);
				}
			}
			
			if(tc < n-1)
				br.readLine();
			
			sb.append(remainPin + " " + move + "\n");
		}
		System.out.print(sb);
	} // end of main

	private static void dfs(int cx, int cy, int remain, int moveCnt) {
		if(remain <= remainPin) {
			remainPin = remain;
			move = moveCnt;
		}
			
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + cx;
			int ny = dy[i] + cy;
			
			if(nx < 0 || nx >= x || ny < 0 || ny >= y || map[nx][ny] != 'o') continue;
			
			int nnx = nx + dx[i];
			int nny = ny + dy[i];
			
			if(nnx < 0 || nnx >= x || nny < 0 || nny >= y || map[nnx][nny] != '.') continue;
			map[cx][cy] = '.';
			map[nx][ny] = '.';
			map[nnx][nny] = 'o';
			
			for (int j = 0; j < x; j++) {
				for (int k = 0; k < y; k++) {
					if(map[j][k] == 'o')
						dfs(j, k, remain-1, moveCnt+1);
				}
			}
			map[cx][cy] = 'o';
			map[nx][ny] = 'o';
			map[nnx][nny] = '.';
		}
		
	}

} // end of class
