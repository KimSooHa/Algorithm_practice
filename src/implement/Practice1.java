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
	// 뱀(백준 3190)
			
	// 보드의 크기(n), 사과의 개수(k), 뱀의 방향 변환 횟수(l)
	public static int n, k, l;
	public static int[][] arr = new int[101][101]; // 맵 정보
	public static ArrayList<Node> info = new ArrayList<>();	// 방향 회전 정보
	
	// 뱀의 방향 변환(동,남,서,북) - 처음에는 오른쪽을 보고 있음
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
		
		// 방향 회전 정보 입력
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
		
		int x = 1, y = 1;	// 뱀의 머리 위치
		arr[x][y] = 2;	// 뱀이 존재하는 위치는 2로 표시
		int direction = 0;	// 처음에는 동쪽을 보고 있음
		int time = 0;	// 시작한 뒤에 지난 '초' 시간
		int index = 0;	// 다음에 회전할 정보
		
		// 뱀이 차지하고 있는 위치 정보(꼬리가 앞쪽)
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x, y));
		
		while(true) {
			
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			// 맵 범위 안에 있고, 뱀의 몸통이 없는 위치라면
			if(1<=nx && nx<=n && 1<=ny &&ny<=ny && arr[nx][ny] != 2) {
	
				// 사과가 없다면 꼬리 제거
				if(arr[nx][ny] == 0) {
					Position prev = q.poll();
					arr[prev.getX()][prev.getY()] = 0;	// 꼬리 부분 0으로 처리
				}
				
				// 뱀의 위치 이동
				arr[nx][ny] = 2;
				q.offer(new Position(nx, ny));

			}
			// 벽이나 뱀의 몸통과 부딪혔다면
			else {
				time += 1;
				break;
			}
			
			// 다음 위치로 머리를 이동
			x = nx;
			y = ny;
			time += 1;
			// 회전할 시간인 경우 회전
			if(index < l && time == info.get(index).getTime()) {
				direction = turn(direction, info.get(index).getDirection());
				index += 1;
			}
			
		}
		
		return time;
	}

	public static int turn(int direction, char c) {
		if(c == 'L') direction = (direction == 0) ? 3 : direction - 1; 	// 왼쪽
		else direction = (direction + 1) % 4;	// 오른쪽
		
		return direction;
	}
    
			
}	// end of class

