package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Practice46 {
	// �̷� �����(���� 1347)
	
	static int n; // ����
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
		// ������ ���̰� 50���� �����Ƿ� �̷��� ũ�⸦ 2��� ��´�.
		char[][] maze = new char[100][100];
		// ��� ĭ�� ������ ä���α�
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) 
				maze[i][j] = '#';	
		}
		
		int posX = 50, posY = 50;
		int minX = 50, minY = 50, maxX = 50, maxY = 50;
		
		maze[posX][posY] = '.'; // ������ġ �̵�ĭ���� ����
		for (int i = 0; i < n; i++) {
			// �Է��� 'F'�� �ƴ� 'R' Ȥ�� 'L'�̸� ���� 90�� ȸ��
			if(directions[i] != 'F')
				direction = turn90(direction, directions[i]);
				
			else { // �Է��� 'F'��� ���� �������� �̵� �� �̵�ĭ���� ����
				posX += dx[direction];
				posY += dy[direction];
				maze[posX][posY] = '.';
				// �̷��� ������ġ, ������ ��ġ ����
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