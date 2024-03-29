package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Practice35 {
	// 감시 피하기(백준 18428)
	
	static int n; // 복도의 크기
	static StringTokenizer st;
	static char board[][]; // 복도 정보
	static ArrayList<Position> teachers = new ArrayList<>(); // 모든 선생님 위치 정보
	static ArrayList<Position> spaces = new ArrayList<>(); // 모든 빈 공간 위치 정보
	
	static class Combination {
		private int n; // 빈 공간 개수
		private int r; // 최대 장애물 개수
		private int[] now; // 현재 조합
		private ArrayList<ArrayList<Position>> result;
		
		public Combination(int n, int r) {
			this.n = n;
			this.r = r;
			this.now = new int[r];
			this.result = new ArrayList<ArrayList<Position>>();
		}
		
		public ArrayList<ArrayList<Position>> getResult() {
			return result;
		}
		
		public void combination(ArrayList<Position> arr, int depth, int index, int target) {
			// 장애물을 다 세웠으면 리스트에 추가
			if(depth == r) {
				ArrayList<Position> temp = new ArrayList<>();
				for(int i=0; i<now.length; i++) 
					temp.add(arr.get(now[i]));
				result.add(temp);
				return;
			}
			// target이 빈 공간 수와 같아지면 반환
			if(target == n)
				return;
			now[index] = target;
			combination(arr, depth+1, index+1, target+1);
			combination(arr, depth, index, target+1);
		}
	}
	
	static class Position {
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
	
	// 장애물 설치 이후에, 한 명이라도 학생이 감지되는지 검사
	static boolean process() {
		// 모든 선생의 위치를 하나씩 확인
		for (int i = 0; i < teachers.size(); i++) {
			int x = teachers.get(i).getX();
			int y = teachers.get(i).getY();
			
			// 4가지 방향으로 학생을 감지할 수 있는지 확인
			for (int j = 0; j < 4; j++) {
				if(watch(x,y,j))
					return true;
			}
		}
		return false;
	}
	
	// 특정 방향으로 감시를 진행(학생 발견:true, 학생 미발견:false)
	static boolean watch(int x, int y, int direction) {
		// 왼쪽 방향으로 감시
		if(direction == 0) {
			while(y>=0) {
				if(board[x][y] == 'S') // 학생이 있는 경우
					return true;
				if(board[x][y] == 'O') // 장애물이 있는 경우
					return false;
					
				y--;
			}
		}
		// 오른쪽 방향으로 감시
		if(direction == 1) {
			while(y<n) {
				if(board[x][y] == 'S') // 학생이 있는 경우
					return true;
				if(board[x][y] == 'O') // 장애물이 있는 경우
					return false;
					
				y++;
			}
		}
		// 위쪽 방향으로 감시
		if(direction == 2) {
			while(x>=0) {
				if(board[x][y] == 'S') // 학생이 있는 경우
					return true;
				if(board[x][y] == 'O') // 장애물이 있는 경우
					return false;
					
				x--;
			}
		}
		// 아래쪽 방향으로 감시
		if(direction == 3) {
			while(x<n) {
				if(board[x][y] == 'S') // 학생이 있는 경우
					return true;
				if(board[x][y] == 'O') // 장애물이 있는 경우
					return false;
					
				x++;
			}
		}
			
		return false;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		board = new char[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = st.nextToken().charAt(0);
				
				if(board[i][j] == 'T') 
					teachers.add(new Position(i, j));
				if(board[i][j] == 'X')
					spaces.add(new Position(i, j));				
			}
		}
		
		// 빈 공간에서 3개를 뽑는 모든 조합을 확인
		Combination comb = new Combination(spaces.size(), 3);
		comb.combination(spaces, 0, 0, 0);
		ArrayList<ArrayList<Position>> spaceList = comb.getResult();
		
		// 학생이 한 명도 감지되지 않도록 설치할 수 있는지의 여부
		boolean found = false;
		for (int i = 0; i < spaceList.size(); i++) {
			// 장애물들 설치해보기
			for (int j = 0; j < spaceList.get(i).size(); j++) {
				int x = spaceList.get(i).get(j).getX();
				int y = spaceList.get(i).get(j).getY();
				board[x][y] = 'O';
			}
			// 학생이 한 명도 감지되지 않은 경우
			if(!process()) {
				// 원하는 경우를 발견
				found = true;
				break;
			}
			// 설치된 장애물들 다시 없애기
			for (int j = 0; j < spaceList.get(i).size(); j++) {
				int x = spaceList.get(i).get(j).getX();
				int y = spaceList.get(i).get(j).getY();
				board[x][y] = 'X';
			}
		}
		// 선생님의 감시에 들키지 않았다면
		if(found) System.out.println("YES");
		// 들켰다면
		else System.out.println("NO");	
	}	// end of main
}	// end of class