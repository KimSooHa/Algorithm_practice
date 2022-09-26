package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Practice1 {
	// ���ٲ���

	// ���ٲ���(���ͽ�Ʈ�� �˰���)
	
		// �갣 ����(n), ��� ����(m)
		public static int n, m;
		public static StringTokenizer st;
		
		public static final int INF = (int) 1e9;	// ���Ѵ� �ǹ�(10��)
			
		// ���� ��带 1�� �갣���� ����
		public static int start = 1;
		
		// �� ��忡 ����Ǿ� �ִ� ��忡 ���� ������ ��� ����Ʈ �����
		public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		
		// �ִ� �Ÿ� ���̺� �����
		public static int[] d = new int[20001];

		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());	// �갣 ����(node)
			m = Integer.parseInt(st.nextToken());	// ��� ����(edge)
			
			// �׷��� �ʱ�ȭ(�갣�� ������ŭ ����Ʈ �����α�)
			for(int i=0; i<=n; i++) 
				graph.add(new ArrayList<Node>());
			
			// �갣���� ����� ��� �Է¹ޱ�
			for(int i=0; i<m; i++) {
				st= new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				// a�� ���� b�� ����� ����� 1�̶�� �ǹ�(�����)
				graph.get(a).add(new Node(b, 1));
				graph.get(b).add(new Node(a, 1));
			}
			
			//  �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ
			Arrays.fill(d, INF);
			
			// ���ͽ�Ʈ�� �˰����� ����
			dijkstra(start);
			
			// ���� �Ÿ��� �� ��� ��ȣ(�����̰� ���� �갣�� ��ȣ)
			int maxNode = 0;
			// ������ �� �ִ� ��� �߿���, ���� �ִ� �Ÿ��� �� ������ �ִ� �Ÿ�
			int maxDistance = 0;
			// ���� �ִ� �Ÿ��� �� ������ �ִ� �Ÿ��� ������ �ִ� �Ÿ��� ������ ������ ����Ʈ
			ArrayList<Integer> result = new ArrayList<>();
			
			for(int i=1; i<=n; i++) {
				
				if(maxDistance < d[i]) {
					maxNode = i;
					maxDistance = d[i];
					result.clear();
					result.add(maxNode);
				} 
				else if(maxDistance == d[i])
					result.add(i);
			}
			
			System.out.println(maxNode + " " + maxDistance + " " + result.size());
			
		}	// end of main

		public static void dijkstra(int start) {
			// ���� ���(1)�� ���� ���� �ִ� ��δ� 0���� �����Ͽ�, ť�� ����
			PriorityQueue<Node> pq = new PriorityQueue<>();	// �켱���� ť ����
			pq.offer(new Node(start, 0));
			d[start] = 0;
			
			while(!pq.isEmpty()) {
				
				// ���� �ִ� �Ÿ��� ª�� ��忡 ���� ���� ������
				Node node = pq.poll();
				int now = node.getIndex();	// ���� ���	/ 1
				int dist = node.getDistance();	// ���� �������� �Ÿ�
				
				// ���� ��尡 �̹� ó���� ���� �ִ� ����� ����
				if(d[now] < dist)	continue;
				
				// ���� ���� ����� �ٸ� ������ ������ Ȯ��
				for(int i=0; i<graph.get(now).size(); i++) {
					
					int cost = d[now] + graph.get(now).get(i).getDistance();
					
					// ���� ��带 ���ļ�, �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
					if(cost < d[graph.get(now).get(i).getIndex()]) {
						d[graph.get(now).get(i).getIndex()] = cost;	// ������ ��忡 ���� ��� ���ؼ� �����ϱ�
						pq.offer(new Node(graph.get(now).get(i).getIndex(), cost)); 
					}
				}
				
			}	// end of while
			
		}	

}	// end of class
