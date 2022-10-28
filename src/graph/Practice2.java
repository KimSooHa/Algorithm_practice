package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Practice2 {
	// 가장 먼 노드(프로그래머스 - 다익스트라)
	
	public static int[] d;
	public static final int INF = (int) 1e9;	// 무한대 의미(10억)
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	// 시작 노드 1번으로 설정
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


		// 거리가 작은 순으로 오름차순
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
			
			// 노드에 양방향 간선으로 두기 
			graph.get(a).add(new Node(b, 1));
			graph.get(b).add(new Node(a, 1));
		}
		
		// 배열을 최댓값으로 채워두기
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		int max = 0;
		
		// 최댓값(가장 멀리 떨어진 노드) 업데이트하기
		for(int i=1; i<=n; i++) 
			max = Math.max(max, d[i]);
		
		// 가장 멀리 떨어진 노드와 동일한 노드가 있다면
		for(int i=1; i<=n; i++) {
			if(d[i] == max)
				answer++;	// 카운트 늘리기
		}
		
		
		return answer;
	}

	public static void dijkstra(int start) {
		// 시작노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;	// 시작노드에서 시작노드로 가는 최단경로는 0
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.getIndex();	// 현재 노드
			int dist = node.getDistance();	// 현재 노드까지의 거리
			
			if(d[now] < dist)	continue;
			
			
			// 현재 노드와 연결된 다른 인접한 노드들을 확인
			for(int i=0; i<graph.get(now).size(); i++) {
				
				// 현재 노드까지의 거리와 인접한 노드의 거리를 누적하기
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				// 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
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
