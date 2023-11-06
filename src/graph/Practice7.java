package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Practice7 {
	// 택배 배송(백준 5972)
	
	static int[] d;
	static final int INF = (int) 1e9;	// 무한대 의미(10억)
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	// 시작 노드 1번으로 설정
	static int start = 1;
	static int n, m; // 헛간 갯수(n), 소들의 길 갯수(m)
	
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
		// 시작노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0; // 시작노드 -> 시작노드 = 0
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.getIndex(); // 현재 노드
			int dist = node.getDistance(); // 현재 노드까지의 거리
			
			if(d[now] < dist) continue;
			
			// 현재 노드와 연결된 다른 인접한 노드들을 확인
			for(int i=0; i<graph.get(now).size(); i++) {
				// 현재 노드까지의 거리와 인접한 노드의 거리 누적하기
				int cost = graph.get(now).get(i).getDistance() + d[now];
				
				// 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}
}	// end of class
