package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice1 {
	// ��(���� 3190)
			
	// ������ ũ��(n), ����� ����(k), ���� ���� ��ȯ Ƚ��(l)
	public static int n, k, l;
	public static int[][] arr = new int[101][101]; // �� ����
	public static ArrayList<Node> info = new ArrayList<>();	// ���� ȸ�� ����
	
	// ���� ���� ��ȯ(��,��,��,��) - ó������ �������� ���� ����
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static StringTokenizer st;
	
	public static class Position {

		private int x;
		private int y;
		
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}


		public int getX() {
			return x;
		}


		public int getY() {
			return y;
		}
		
		
	}
	
	public static class Node {

		private int time;
		private char direction;
		
		
		public Node(int time, char direction) {
			this.time = time;
			this.direction = direction;
		}


		public int getTime() {
			return time;
		}


		public char getDirection() {
			return direction;
		}
		
		
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
		}
		
		// ���� ȸ�� ���� �Է�
		l = Integer.parseInt(br.readLine());
		
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			
			info.add(new Node(x, c));
		}
		
		System.out.println(simulate());
		
	}

	public static int simulate() {
		
		int x = 1, y = 1;	// ���� �Ӹ� ��ġ
		arr[x][y] = 2;	// ���� �����ϴ� ��ġ�� 2�� ǥ��
		int direction = 0;	// ó������ ������ ���� ����
		int time = 0;	// ������ �ڿ� ���� '��' �ð�
		int index = 0;	// ������ ȸ���� ����
		
		// ���� �����ϰ� �ִ� ��ġ ����(������ ����)
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x, y));
		
		while(true) {
			
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			// �� ���� �ȿ� �ְ�, ���� ������ ���� ��ġ���
			if(1<=nx && nx<=n && 1<=ny &&ny<=ny && arr[nx][ny] != 2) {
	
				// ����� ���ٸ� ���� ����
				if(arr[nx][ny] == 0) {
					Position prev = q.poll();
					arr[prev.getX()][prev.getY()] = 0;	// ���� �κ� 0���� ó��
				}
				
				// ���� ��ġ �̵�
				arr[nx][ny] = 2;
				q.offer(new Position(nx, ny));

			}
			// ���̳� ���� ����� �ε����ٸ�
			else {
				time += 1;
				break;
			}
			
			// ���� ��ġ�� �Ӹ��� �̵�
			x = nx;
			y = ny;
			time += 1;
			// ȸ���� �ð��� ��� ȸ��
			if(index < l && time == info.get(index).getTime()) {
				direction = turn(direction, info.get(index).getDirection());
				index += 1;
			}
			
		}
		
		return time;
	}

	public static int turn(int direction, char c) {
		if(c == 'L') direction = (direction == 0) ? 3 : direction - 1; 	// ����
		else direction = (direction + 1) % 4;	// ������
		
		return direction;
	}
    
			
}	// end of class

