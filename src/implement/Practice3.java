package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice3 {
	// ġŲ ���(���� 15686)
			
	// ������ ũ��(n), �ִ� ġŲ�� ����(m)
	public static int n, m;
	public static int[][] arr = new int[50][50]; // �� ����
	public static ArrayList<Position> chicken = new ArrayList<>();
	public static ArrayList<Position> house = new ArrayList<>();
	
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
	
	public static class Combination {
		private int n;	// ġŲ�� ����
		private int m;	// ġŲ�� �ִ� ����
		private int[] now;	// ���� ����
		private ArrayList<ArrayList<Position>> result;	// ��� ����
		
		public Combination(int n, int m) {
			this.n = n;
			this.m = m;
			this.now = new int[m];
			this.result = new ArrayList<ArrayList<Position>>();
		}
		
		public void combination(ArrayList<Position> arr, int depth, int index, int target) {
			// ġŲ�� �ִ� ������ �Ǿ�����
			if(depth == m) {
				ArrayList<Position> temp = new ArrayList<>();
				
				// ���� ������ ġŲ ��ġ�� ����Ʈ�� �߰�
				for(int i=0; i<now.length; i++) 
					temp.add(arr.get(now[i]));
				
				result.add(temp);	// ����Ʈ�� result ����Ʈ�� �߰�(ġŲ�� �ִ� ������ŭ)
				
				return;
			}
			if(target == n)
				return;
			
			now[index] = target;
			
			combination(arr, depth+1, index+1, target+1);
			
			combination(arr, depth, index, target+1);
		}
		
		// ��� ������ ����Ʈ ��ȯ
		public ArrayList<ArrayList<Position>> getResult() {
			return result;
		}
		
	}
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 1)
					house.add(new Position(i, j));	// �Ϲ� ��
				else if(arr[i][j] == 2)
					chicken.add(new Position(i, j));	// ġŲ ��
			}
		}
		
		// ��� ġŲ �� �߿��� m���� ġŲ ���� �̴� ���� ���
		Combination comb = new Combination(chicken.size(), m);
		comb.combination(chicken, 0, 0, 0);
		ArrayList<ArrayList<Position>> chickenList = comb.getResult();
		
		// ġŲ �Ÿ��� ���� �ּҸ� ã�� ���
		int result = (int)1e9;	// �ִ밪���� ���� ���ϱ� ���� ������ �ǹ��ϴ� ������ 10���� ����
		
		// �� ���� ����Ʈ�� ������ ġŲ �Ÿ��� �ּڰ� ���ϱ�
		for(int i=0; i<chickenList.size(); i++) {
			result = Math.min(result, getSum(chickenList.get(i)));
		}
		
		System.out.println(result);

	}	// end of main	


	public static int getSum(ArrayList<Position> chickens) {
		int result = 0;
		
		// ��� ���� ���Ͽ�
		for(int i=0; i<house.size(); i++) {
			int hx = house.get(i).getX();
			int hy = house.get(i).getY();
			
			// ���� ����� ġŲ���� ã��
			int temp = (int)1e9;
			
			for(int j=0; j<chickens.size(); j++) {
				int cx = chickens.get(j).getX();
				int cy = chickens.get(j).getY();
				
				temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));	// ��� ���� �������� ���� ����� ġŲ�� ���ϱ�
			}
			
			// ��� ���� ġŲ�Ÿ��� ��(������ ġŲ�Ÿ�) ���ϱ�
			result += temp;
			
		}
		
		return result;
	}
	
}	// end of class

