package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice1 {
	// 특정 거리의 도시 찾기(백준 18352)

	// 도시의 개수(N), 도로의 개수(M), 거리 정보(K), 출발 도시의 번호(X)
	public static int n, m, k, x;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static StringTokenizer st;
	
	// 모든 도시에 대한 최단거리 초기화
	public static int[] d = new int[300001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		// 그래프 및 최단 거리 테이블 초기화
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
		
		// 출발도시(X)까지의 거리는 0으로 설정
		d[x] = 0;
		
		// 너비 우선 탐색(BFS) 수행
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			// 현재 도시에서 이동할 수 있는 모든 도시를 확인
			for(int i=0; i<graph.get(now).size(); i++) {
				int nextNode = graph.get(now).get(i);
				// 아직 방문하지 않은 노드라면
				if(d[nextNode] == -1) {
					d[nextNode] = d[now] + 1;
					q.offer(nextNode);
				}
			}
		}
		
		// 최단 거리가 K인 모든 도시의 번호를 오름차순으로 출력
		boolean check = false;
		for(int i=1; i<=n; i++) {
			if(d[i] == k) {
				System.out.println(i);
				check = true;
			}
		}
		
		// 만약 최단거리가 k인 도시가 없다면, -1을 출력
		if(!check)
			System.out.println(-1);

	}	// end of main

}	// end of class
