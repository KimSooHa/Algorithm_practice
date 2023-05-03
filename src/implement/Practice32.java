package implement;

import java.util.ArrayList;
import java.util.Collections;

class Practice32 {
	// ��հ� �� ��ġ(���α׷��ӽ�)
	
	static class Node implements Comparable<Node> {
		private int x;
		private int y;
		private int stuff;
		
		public Node(int x, int y, int stuff) {
			this.x = x;
			this.y = y;
			this.stuff = stuff;
		}
		
		
		public int getX() {
			return x;
		}


		public int getY() {
			return y;
		}


		public int getStuff() {
			return stuff;
		}


		@Override
		public int compareTo(Node other) {
			// x, y ��ǥ�� ��� ���� ��� ����� ������ ������
			if(this.x == other.x && this.y == other.y)
				return Integer.compare(this.stuff, other.stuff);
			// x��ǥ�� ���� ��� y��ǥ �������� ��������
			if(this.x == other.x)
				return Integer.compare(this.y, other.y);
			// x��ǥ �������� ��������
			return Integer.compare(this.x, other.x);
		}
	}

	public static int[][] solution(int n, int[][] build_frame) {
		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0]; // ���� ��ǥ
			int y = build_frame[i][1]; // ���� ��ǥ
			
			int stuff = build_frame[i][2]; // ������ ����(0 - ���, 1 - ��)
			int operate = build_frame[i][3]; // ������ ��ġ(1)���� ����(0)����
			
			// �����ϴ� ���
			if(operate == 0) {
				// �ϴ� ������ �غ� �ڿ�
				int index = 0;
				for (int j = 0; j < answer.size(); j++) {
					if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && stuff == answer.get(j).get(2))
						index = j;
				}
				
				ArrayList<Integer> erased = answer.get(index);
				answer.remove(index);
				if(!possible(answer)) // ������ ���������� Ȯ��
					answer.add(erased); // ������ �������� �ƴ϶�� �ٽ� ��ġ	
			}
			// ��ġ�ϴ� ���
			if(operate == 1) {
				// �ϴ� ��ġ�� �غ� �ڿ�
				ArrayList<Integer> inserted = new ArrayList<>();
				inserted.add(x);
				inserted.add(y);
				inserted.add(stuff);
				answer.add(inserted);
				// ������ �������� �ƴ϶�� �ٽ� ����
				if(!possible(answer))
					answer.remove(answer.size()-1); 
			}
		}
		
		// ���� ����
		ArrayList<Node> ans = new ArrayList<>();
		for (int i = 0; i < answer.size(); i++) 
			ans.add(new Node(answer.get(i).get(0), answer.get(i).get(1), answer.get(i).get(2)));
		
		Collections.sort(ans);
		
		// �迭�� �ٲپ� ��ȯ
		int[][] res = new int[ans.size()][3];
		for (int i = 0; i < ans.size(); i++) {
			res[i][0] = ans.get(i).getX();
			res[i][1] = ans.get(i).getY();
			res[i][2] = ans.get(i).getStuff();
		}
		
        return res;
    }
	
	static boolean possible(ArrayList<ArrayList<Integer>> answer) {
		for (int i = 0; i < answer.size(); i++) {
			int x = answer.get(i).get(0);
			int y = answer.get(i).get(1);
			int stuff = answer.get(i).get(2);
			
			// ��ġ�� ���� '���'�� ���(0)
			if(stuff == 0) {
				boolean check = false;
				// '�ٴ�' ����� ����
				if(y == 0)
					check = true;
				// '���� ���� �� �κ� ��' Ȥ�� '�ٸ� ��� ��'��� ����
				for (int j = 0; j < answer.size(); j++) {
					// ����� ���ʿ� ��ġ && ���� y��ǥ
					if(x-1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) // ����� ��(1)�� ������ ���κ�
						check = true;
					// ����� ���� �����ʿ� ��ġ
					if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2))
						check = true;
					// ����� �ٸ� ����� ��
					if(x == answer.get(j).get(0) && y-1 == answer.get(j).get(1) && 0 == answer.get(j).get(2))
						check = true;
				} // �ƴ϶�� ���� ��ȯ
				if(!check)
					return false;
			} else if(stuff == 1) { // ��ġ�� ���� '��'�� ���
				boolean check = false;
				boolean left = false;
				boolean right = false;
				
				// '���� ���κ��� ��� ��' Ȥ�� '���� ���κ��� �ٸ� ���� ���ÿ� ����'�̶�� ����
				for (int j = 0; j < answer.size(); j++) {
					if(x == answer.get(j).get(0) && y-1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) // ���� ���� ���� ��� ��
						check = true;
					if(x+1 == answer.get(j).get(0) && y-1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) // ���� ������ ���� ��� ��
						check = true;
					if(x-1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) // ���� ���� ���� ���� ���� ����
						left = true;
					if(x+1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) // ���� ������ ���� ������ ���� ����
						right = true;
				}
				if(left && right)
					check = true;
				if(!check)
					return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		
		int n = 5;
		int[][] build_frame = {{1,0,0,1}, {1,1,1,1}, {2,1,0,1}, {2,2,1,1}, {5,0,0,1}, {5,1,0,1}, {4,2,1,1}, {3,2,1,1}};
		int[][] res = solution(n, build_frame);
		System.out.print("[");
		for (int i = 0; i < res.length; i++) {
			int x = res[i][0];
			int y = res[i][1];
			int stuff = res[i][2];
			
			System.out.print("[" + x + "," + y + "," + stuff + "]");
			if(i != res.length-1)
				System.out.print(",");
			else
				System.out.print("]");
		}		
	}	// end of main

}	// end of class