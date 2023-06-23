package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Practice46 {
	// 미로 만들기(백준 1347)
	
	static int n; // 길이
	static char[] directions;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
	static int direction = 0;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		directions = new char[n];
		String s = br.readLine();
		
		for (int i = 0; i < n; i++) 
			directions[i] = s.charAt(i);
		// 내용의 길이가 50보다 작으므로 미로의 크기를 2배로 잡는다.
		char[][] maze = new char[100][100];
		// 모든 칸을 벽으로 채워두기
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) 
				maze[i][j] = '#';	
		}
		
		int posX = 50, posY = 50;
		int minX = 50, minY = 50, maxX = 50, maxY = 50;
		
		maze[posX][posY] = '.'; // 시작위치 이동칸으로 갱신
		for (int i = 0; i < n; i++) {
			// 입력이 'F'가 아닌 'R' 혹은 'L'이면 방향 90도 회전
			if(directions[i] != 'F')
				direction = turn90(direction, directions[i]);
				
			else { // 입력이 'F'라면 현재 방향으로 이동 및 이동칸으로 갱신
				posX += dx[direction];
				posY += dy[direction];
				maze[posX][posY] = '.';
				// 미로의 시작위치, 끝나는 위치 갱신
				maxX = Math.max(maxX, posX);
				maxY = Math.max(maxY, posY);
				minX = Math.min(minX, posX);
				minY = Math.min(minY, posY);
			}
		}
		
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) 
				System.out.print(maze[i][j]);
			System.out.println();
		}
				
	} // end of main



	public static int turn90(int direction, char c) {
		direction = c == 'R' ? (direction + 1) % 4 : direction == 0 ? 3 : direction - 1;
		return direction;
	}

}	// end of class