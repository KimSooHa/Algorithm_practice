package kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice1 {
	// �༺ �ͳ�(���� 2887)
	
	public static int n;	// �༺�� ����(n)
	// ����� ������ �ִ� 100,000����� ����
	public static int[] parent = new int[100001];

	public static ArrayList<Edge> edges = new ArrayList<>();
	public static int result = 0;
	
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		// �θ� ���̺�󿡼�, �θ� �ڱ� �ڽ����� �ʱ�ȭ
		for(int i=1; i<=n; i++)
			parent[i] = i;
		
		// x, y, z ��ǥ�� ���� ����Ʈ
		ArrayList<Position> x = new ArrayList<>();
		ArrayList<Position> y = new ArrayList<>();
		ArrayList<Position> z = new ArrayList<>();
		
		// ��� ������ ���� ������ �Է¹ޱ�
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			x.add(new Position(a, i));
			y.add(new Position(b, i));
			z.add(new Position(c, i));
		}
		
		// ������ �������� ����
		Collections.sort(x);
		Collections.sort(y);
		Collections.sort(z);
		
		// �༺�� �Ÿ� �� �༺ ��� ���(x,y,z �ೢ�� �յ� ��尣�� �Ÿ��� ����ؼ� �ּҺ������ ������ �����ϱ� ���� edge�� ��ǥ���� ��尣�� ��� ����ؼ� ����Ʈ �߰�)
		for(int i=0; i<n-1; i++) {
			edges.add(new Edge(x.get(i+1).getX() - x.get(i).getX(), x.get(i).getY(), x.get(i+1).getY()));
			edges.add(new Edge(y.get(i+1).getX() - y.get(i).getX(), y.get(i).getY(), y.get(i+1).getY()));
			edges.add(new Edge(z.get(i+1).getX() - z.get(i).getX(), z.get(i).getY(), z.get(i+1).getY()));
		}
		
		// ������ �������� ����
		Collections.sort(edges);
		
		// ������ �ϳ��� Ȯ���ϸ�
		for(int i=0; i<edges.size(); i++) {
			int cost = edges.get(i).getDistance();
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			
			// ����Ŭ�� �߻����� �ʴ� ��쿡�� ���տ� ����(�̹� ���� �θ����� �ش簣���� �ּҺ������ ���ԵȰ�)
			if(findParent(a) != findParent(b)) {
				unionParent(a, b);
				
				result += cost;	// �ּ� ���� Ʈ���� �����ϴ� ���
			}
				
		}
		
		System.out.println(result);

	}	// end of main

	// Ư�� ���Ұ� ���� ������ ã��
	public static int findParent(int x) {
		// ��Ʈ ��尡 �ƴ϶��, ��Ʈ ��带 ã�� ������ ��������� ȣ��
		if(x == parent[x])
			return x;
		
		return parent[x] = findParent(parent[x]);
	}

	// �� ���Ұ� ���� ������ ��ġ��
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
		
	}


}	// end of class
