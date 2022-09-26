package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Practice1 {
	// 숨바꼭질

	// 숨바꼭질(다익스트라 알고리즘)
	
		// 헛간 갯수(n), 통로 갯수(m)
		public static int n, m;
		public static StringTokenizer st;
		
		public static final int INF = (int) 1e9;	// 무한대 의미(10억)
			
		// 시작 노드를 1번 헛간으로 설정
		public static int start = 1;
		
		// 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트 만들기
		public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		
		// 최단 거리 테이블 만들기
		public static int[] d = new int[20001];

		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());	// 헛간 갯수(node)
			m = Integer.parseInt(st.nextToken());	// 통로 갯수(edge)
			
			// 그래프 초기화(헛간의 개수만큼 리스트 만들어두기)
			for(int i=0; i<=n; i++) 
				graph.add(new ArrayList<Node>());
			
			// 헛간끼리 연결된 통로 입력받기
			for(int i=0; i<m; i++) {
				st= new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				// a번 노드와 b번 노드의 비용이 1이라는 의미(양방향)
				graph.get(a).add(new Node(b, 1));
				graph.get(b).add(new Node(a, 1));
			}
			
			//  최단 거리 테이블을 모두 무한으로 초기화
			Arrays.fill(d, INF);
			
			// 다익스트라 알고리즘을 수행
			dijkstra(start);
			
			// 가장 거리가 먼 노드 번호(동빈이가 숨을 헛간의 번호)
			int maxNode = 0;
			// 도달할 수 있는 노드 중에서, 가장 최단 거리가 먼 노드와의 최단 거리
			int maxDistance = 0;
			// 가장 최단 거리가 먼 노드와의 최단 거리와 동일한 최단 거리를 가지는 노드들의 리스트
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
			// 시작 노드(1)로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
			PriorityQueue<Node> pq = new PriorityQueue<>();	// 우선순위 큐 생성
			pq.offer(new Node(start, 0));
			d[start] = 0;
			
			while(!pq.isEmpty()) {
				
				// 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
				Node node = pq.poll();
				int now = node.getIndex();	// 현재 노드	/ 1
				int dist = node.getDistance();	// 현재 노드까지의 거리
				
				// 현재 노드가 이미 처리된 적이 있는 노드라면 무시
				if(d[now] < dist)	continue;
				
				// 현재 노드와 연결된 다른 인접한 노드들을 확인
				for(int i=0; i<graph.get(now).size(); i++) {
					
					int cost = d[now] + graph.get(now).get(i).getDistance();
					
					// 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
					if(cost < d[graph.get(now).get(i).getIndex()]) {
						d[graph.get(now).get(i).getIndex()] = cost;	// 인접한 노드에 이전 비용 합해서 갱신하기
						pq.offer(new Node(graph.get(now).get(i).getIndex(), cost)); 
					}
				}
				
			}	// end of while
			
		}	

}	// end of class
