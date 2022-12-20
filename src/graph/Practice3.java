package graph;

public class Practice3 {
	// ��Ʈ��ũ(���α׷��ӽ�) 
	
	// union-find ������� Ǯ���� 
	
	// �θ� ���̺� �ʱ�ȭ
	public static int[] parent;
	
	 public static int solution(int n, int[][] computers) {
		 
		 int answer = 0;
		 
		 parent = new int[n];
	
		 // �θ� ���̺�󿡼�, ��� �ڱ� �ڽ����� �ʱ�ȭ
		 for(int i=1; i<n; i++)
			 parent[i] = i;
		 
		 // Union ������ ���� ����
		 for(int i=0; i<n; i++) {
			 for(int j=0; j<n; j++) {
				 if(i!=j && computers[i][j] == 1)
					 unionParent(i, j);
			 }
		 }
		 
		 for(int i=0; i<n; i++) {
			 if(parent[i] == i)
				 answer++;
		 }
		 
		 
	    return answer;
	}

	public static void main(String[] args) {
		
		// ex1
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
		// ex2
//		int n = 3;
//		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
		// ex3
//		int n = 7;
//		int[][] computers = {
//					{1,0,0,0,0,0,1},
//	                {0,1,1,0,1,0,0},
//	                {0,1,1,1,0,0,0},
//	                {0,0,1,1,0,0,0},
//	                {0,1,0,0,1,1,0},
//	                {0,0,0,0,1,1,1},
//	                {1,0,0,0,0,1,1}
//                };
		
		
		int answer = solution(n, computers);
		
		System.out.println(answer);
		
	}	// end of main
	
	
	// �� ���Ұ� ���� ������ ��ġ��
	public static void unionParent(int a, int b) {	// a�� b�� ����Ǿ������Ƿ�
		 // �� ����� ��Ʈ��带 ã�Ƽ�
		a = findParent(a);
		b = findParent(b);
		
		// �� ���� ���� ��ġ��
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
		
	}


	// Ư�� ���Ұ� ���� ������ ã��
	public static int findParent(int x) {
		// ��Ʈ ����� �״�� ��ȯ
		if(x == parent[x])
			return x;
		
		// ��Ʈ ��尡 �ƴ϶��, ��Ʈ ��带 ã�� ������ ��������� ȣ��
		return parent[x] = findParent(parent[x]);
	}

}	// end of class
