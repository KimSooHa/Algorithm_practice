package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Practice7 {
	// �ù� ���(���� 5972)
	
	static int[] d;
	static final int INF = (int) 1e9;	// ���Ѵ� �ǹ�(10��)
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	// ���� ��� 1������ ����
	static int start = 1;
	static int n, m; // �갣 ����(n), �ҵ��� �� ����(m)
	
	public static class Node implements Comparable<Node> {

		private int index;
		private int distance;
		
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		

		public int getIndex() {
			return index;
		}


		public int getDistance() {
			return distance;
		}


		// �Ÿ��� ���� ������ ��������
		@Override
		public int compareTo(Node other) {
			if(this.distance < other.distance)
				return -1;
			
			return 1;
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		d = new int[n+1];
		Arrays.fill(d, INF);
		
		for(int i=0; i<= n; i++) 
			graph.add(new ArrayList<>());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		dijkstra(start);
		
		System.out.println(d[n]);
		
	}	// end of main

	public static void dijkstra(int start) {
		// ���۳��� ���� ���� �ִ� ��δ� 0���� �����Ͽ�, ť�� ����
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0; // ���۳�� -> ���۳�� = 0
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.getIndex(); // ���� ���
			int dist = node.getDistance(); // ���� �������� �Ÿ�
			
			if(d[now] < dist) continue;
			
			// ���� ���� ����� �ٸ� ������ ������ Ȯ��
			for(int i=0; i<graph.get(now).size(); i++) {
				// ���� �������� �Ÿ��� ������ ����� �Ÿ� �����ϱ�
				int cost = graph.get(now).get(i).getDistance() + d[now];
				
				// ���� ��带 ���ļ� �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}
}	// end of class
