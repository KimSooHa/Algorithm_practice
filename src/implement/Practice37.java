package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Practice37 {
	// 체스판 다시 칠하기(백준 1018)
	
	static int n, m;
	static char[][] board = new char[51][51];
	static StringTokenizer st;
	static int result = 8*8;

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				board[i][j] = str[j].charAt(0);
			}
		}
		
		int row = n - 7;
		int col = m - 7;
		
		for(int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				find(i, j);
			}
		}
				
		System.out.println(result);
	}	// end of main

	public static void find(int x, int y) {
		int endX = x + 8;
		int endY = y + 8;
		int cnt = 0;
		
		char color = board[x][y];
		
		for(int i = x; i < endX; i++) {
			for (int j = y; j < endY; j++) {
				// 올바른 색이 아닐 경우
				if(board[i][j] != color)
					cnt++;
				
				color = changeColor(color);
			}
			color = changeColor(color);
		}
		
		cnt = Math.min(cnt, 64 - cnt);
		
		result = Math.min(cnt, result);
	}

	public static char changeColor(char color) {
		if(color == 'W')
			color = 'B';
		else
			color = 'W';
		
		return color;
	}

	
}	// end of class