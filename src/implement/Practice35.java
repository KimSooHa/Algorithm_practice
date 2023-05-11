package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Practice35 {
	// ���� ���ϱ�(���� 18428)
	
	static int n; // ������ ũ��
	static StringTokenizer st;
	static char board[][]; // ���� ����
	static ArrayList<Position> teachers = new ArrayList<>(); // ��� ������ ��ġ ����
	static ArrayList<Position> spaces = new ArrayList<>(); // ��� �� ���� ��ġ ����
	
	static class Combination {
		private int n; // �� ���� ����
		private int r; // �ִ� ��ֹ� ����
		private int[] now; // ���� ����
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
			// ��ֹ��� �� �������� ����Ʈ�� �߰�
			if(depth == r) {
				ArrayList<Position> temp = new ArrayList<>();
				for(int i=0; i<now.length; i++) 
					temp.add(arr.get(now[i]));
				result.add(temp);
				return;
			}
			// target�� �� ���� ���� �������� ��ȯ
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
	
	// ��ֹ� ��ġ ���Ŀ�, �� ���̶� �л��� �����Ǵ��� �˻�
	static boolean process() {
		// ��� ������ ��ġ�� �ϳ��� Ȯ��
		for (int i = 0; i < teachers.size(); i++) {
			int x = teachers.get(i).getX();
			int y = teachers.get(i).getY();
			
			// 4���� �������� �л��� ������ �� �ִ��� Ȯ��
			for (int j = 0; j < 4; j++) {
				if(watch(x,y,j))
					return true;
			}
		}
		return false;
	}
	
	// Ư�� �������� ���ø� ����(�л� �߰�:true, �л� �̹߰�:false)
	static boolean watch(int x, int y, int direction) {
		// ���� �������� ����
		if(direction == 0) {
			while(y>=0) {
				if(board[x][y] == 'S') // �л��� �ִ� ���
					return true;
				if(board[x][y] == 'O') // ��ֹ��� �ִ� ���
					return false;
					
				y--;
			}
		}
		// ������ �������� ����
		if(direction == 1) {
			while(y<n) {
				if(board[x][y] == 'S') // �л��� �ִ� ���
					return true;
				if(board[x][y] == 'O') // ��ֹ��� �ִ� ���
					return false;
					
				y++;
			}
		}
		// ���� �������� ����
		if(direction == 2) {
			while(x>=0) {
				if(board[x][y] == 'S') // �л��� �ִ� ���
					return true;
				if(board[x][y] == 'O') // ��ֹ��� �ִ� ���
					return false;
					
				x--;
			}
		}
		// �Ʒ��� �������� ����
		if(direction == 3) {
			while(x<n) {
				if(board[x][y] == 'S') // �л��� �ִ� ���
					return true;
				if(board[x][y] == 'O') // ��ֹ��� �ִ� ���
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
		
		// �� �������� 3���� �̴� ��� ������ Ȯ��
		Combination comb = new Combination(spaces.size(), 3);
		comb.combination(spaces, 0, 0, 0);
		ArrayList<ArrayList<Position>> spaceList = comb.getResult();
		
		// �л��� �� �� �������� �ʵ��� ��ġ�� �� �ִ����� ����
		boolean found = false;
		for (int i = 0; i < spaceList.size(); i++) {
			// ��ֹ��� ��ġ�غ���
			for (int j = 0; j < spaceList.get(i).size(); j++) {
				int x = spaceList.get(i).get(j).getX();
				int y = spaceList.get(i).get(j).getY();
				board[x][y] = 'O';
			}
			// �л��� �� �� �������� ���� ���
			if(!process()) {
				// ���ϴ� ��츦 �߰�
				found = true;
				break;
			}
			// ��ġ�� ��ֹ��� �ٽ� ���ֱ�
			for (int j = 0; j < spaceList.get(i).size(); j++) {
				int x = spaceList.get(i).get(j).getX();
				int y = spaceList.get(i).get(j).getY();
				board[x][y] = 'X';
			}
		}
		// �������� ���ÿ� ��Ű�� �ʾҴٸ�
		if(found) System.out.println("YES");
		// ���״ٸ�
		else System.out.println("NO");	
	}	// end of main
}	// end of class