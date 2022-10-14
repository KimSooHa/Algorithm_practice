package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice1 {
	// Ư�� �Ÿ��� ���� ã��(���� 18352)

	// ������ ����(N), ������ ����(M), �Ÿ� ����(K), ��� ������ ��ȣ(X)
	public static int n, m, k, x;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static StringTokenizer st;
	
	// ��� ���ÿ� ���� �ִܰŸ� �ʱ�ȭ
	public static int[] d = new int[300001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		// �׷��� �� �ִ� �Ÿ� ���̺� �ʱ�ȭ
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
			d[i] = -1;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
		}
		
		// ��ߵ���(X)������ �Ÿ��� 0���� ����
		d[x] = 0;
		
		// �ʺ� �켱 Ž��(BFS) ����
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			// ���� ���ÿ��� �̵��� �� �ִ� ��� ���ø� Ȯ��
			for(int i=0; i<graph.get(now).size(); i++) {
				int nextNode = graph.get(now).get(i);
				// ���� �湮���� ���� �����
				if(d[nextNode] == -1) {
					d[nextNode] = d[now] + 1;
					q.offer(nextNode);
				}
			}
		}
		
		// �ִ� �Ÿ��� K�� ��� ������ ��ȣ�� ������������ ���
		boolean check = false;
		for(int i=1; i<=n; i++) {
			if(d[i] == k) {
				System.out.println(i);
				check = true;
			}
		}
		
		// ���� �ִܰŸ��� k�� ���ð� ���ٸ�, -1�� ���
		if(!check)
			System.out.println(-1);

	}	// end of main

}	// end of class
