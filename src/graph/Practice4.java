package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice4 {
	// ž�±�
	
	// union-find
	
	static int g, p; // ����� ��(g)�� ������� ����(p)
	// �θ� ���̺� �ʱ�ȭ
	static int[] parent;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		g = Integer.parseInt(br.readLine());
		p = Integer.parseInt(br.readLine());
	
		parent = new int[g+1];
		for (int i = 0; i <= g; i++) 
			parent[i] = i;
		
		int result = 0;
		// Union ������ ���� ����
		for (int i = 0; i < p; i++) {
			int x = Integer.parseInt(br.readLine());
			int root = findParent(x);
			if(root == 0) // ���� ��Ʈ�� 0�̶��, ����
				break;
			// �׷��� �ʴٸ� �ٷ� ������ ���հ� ������ ���� ����
			unionParent(root, root-1);
			result++;
		}
		
		System.out.println(result);
	}	// end of main

	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a<b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	public static int findParent(int x) {
		// ��Ʈ ��尡 �ƴ϶��, ��Ʈ ��带 ã�� ������ ��������� ȣ��
		if(x == parent[x])
			return x;
		
		return parent[x] = findParent(parent[x]);
	}

}	// end of class
