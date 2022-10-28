package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Practice2 {
	// ���� �� ���(���α׷��ӽ� - ���ͽ�Ʈ��)
	
	public static int[] d;
	public static final int INF = (int) 1e9;	// ���Ѵ� �ǹ�(10��)
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	// ���� ��� 1������ ����
	public static int start = 1;	
	
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
		
	public static int solution(int n, int[][] edge) {
		
		int answer = 0;
		
		d = new int[n+1];
		
		for(int i=0; i<=n; i++)
			graph.add(new ArrayList<Node>());
		
		for(int[] arr : edge) {
			int a = arr[0];
			int b = arr[1];
			
			// ��忡 ����� �������� �α� 
			graph.get(a).add(new Node(b, 1));
			graph.get(b).add(new Node(a, 1));
		}
		
		// �迭�� �ִ����� ä���α�
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		int max = 0;
		
		// �ִ�(���� �ָ� ������ ���) ������Ʈ�ϱ�
		for(int i=1; i<=n; i++) 
			max = Math.max(max, d[i]);
		
		// ���� �ָ� ������ ���� ������ ��尡 �ִٸ�
		for(int i=1; i<=n; i++) {
			if(d[i] == max)
				answer++;	// ī��Ʈ �ø���
		}
		
		
		return answer;
	}

	public static void dijkstra(int start) {
		// ���۳��� ���� ���� �ִ� ��δ� 0���� �����Ͽ�, ť�� ����
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;	// ���۳�忡�� ���۳��� ���� �ִܰ�δ� 0
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.getIndex();	// ���� ���
			int dist = node.getDistance();	// ���� �������� �Ÿ�
			
			if(d[now] < dist)	continue;
			
			
			// ���� ���� ����� �ٸ� ������ ������ Ȯ��
			for(int i=0; i<graph.get(now).size(); i++) {
				
				// ���� �������� �Ÿ��� ������ ����� �Ÿ��� �����ϱ�
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				// ���� ��带 ���ļ�, �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
				
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		int n = 6;
		int[][] edge = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
		
		System.out.println(solution(n, edge));
		
	}	// end of main


		
		

}	// end of class
