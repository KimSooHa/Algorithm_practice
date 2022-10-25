package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Practice1 {
	// �����ȹ
	
		// �������� ����(n), ������ ����(m)
		public static int n, m;
		public static StringTokenizer st;
		
		public static final int INF = (int) 1e9;	// ���Ѵ� �ǹ�(10��)
			
		
		// �θ� ���̺� �ʱ�ȭ => ����� ������ �ִ� 501��(0~500)�� ����
		public static int[] parent = new int[501];

		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());	// ������ ����(node)
			m = Integer.parseInt(st.nextToken());	// ���� ����(edge)
			
			// �θ� ���̺�󿡼�, ��� �ڱ� �ڽ����� �ʱ�ȭ
			for(int i=1; i<=n; i++) 
				parent[i] = i;
			
			
			// Union ������ ���� ����
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					int x = Integer.parseInt(st.nextToken());
					if(x == 1)
						unionParent(i+1, j+1);	// 1,2�� ������(union) ���� ����
				}
			}
			
			// ���� ��ȹ �Է¹ޱ�
			ArrayList<Integer> plan = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<m; i++) {
				int x = Integer.parseInt(st.nextToken());
				plan.add(x);
			}
			
			boolean result = true;
			
			// ���� ��ȹ�� ���ϴ� ��� ����� ��Ʈ�� �������� Ȯ��
			for(int i=0; i<m-1; i++) {
				if(findParent(plan.get(i)) != findParent(plan.get(i+1)))
					result = false;
			}
			
			// ���� ��ȹ�� ���ϴ� ��� ��尡 ���� ����Ǿ� �ִ���(��Ʈ�� ��������) Ȯ��
			if(result)
				System.out.println("YES");
			else
				System.out.println("NO");
			
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
