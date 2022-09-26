package kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice1 {
	// 행성 터널(백준 2887)
	
	public static int n;	// 행성의 개수(n)
	// 노드의 개수는 최대 100,000개라고 가정
	public static int[] parent = new int[100001];

	public static ArrayList<Edge> edges = new ArrayList<>();
	public static int result = 0;
	
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		// 부모 테이블상에서, 부모를 자기 자신으로 초기화
		for(int i=1; i<=n; i++)
			parent[i] = i;
		
		// x, y, z 좌표에 대한 리스트
		ArrayList<Position> x = new ArrayList<>();
		ArrayList<Position> y = new ArrayList<>();
		ArrayList<Position> z = new ArrayList<>();
		
		// 모든 간선에 대한 정보를 입력받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			x.add(new Position(a, i));
			y.add(new Position(b, i));
			z.add(new Position(c, i));
		}
		
		// 간선을 비용순으로 정렬
		Collections.sort(x);
		Collections.sort(y);
		Collections.sort(z);
		
		// 행성간 거리 및 행성 노드 담기(x,y,z 축끼리 앞뒤 노드간의 거리를 계산해서 최소비용으로 간선을 연결하기 위해 edge에 좌표끼리 노드간의 비용 계산해서 리스트 추가)
		for(int i=0; i<n-1; i++) {
			edges.add(new Edge(x.get(i+1).getX() - x.get(i).getX(), x.get(i).getY(), x.get(i+1).getY()));
			edges.add(new Edge(y.get(i+1).getX() - y.get(i).getX(), y.get(i).getY(), y.get(i+1).getY()));
			edges.add(new Edge(z.get(i+1).getX() - z.get(i).getX(), z.get(i).getY(), z.get(i+1).getY()));
		}
		
		// 간선을 비용순으로 정렬
		Collections.sort(edges);
		
		// 간선을 하나씩 확인하며
		for(int i=0; i<edges.size(); i++) {
			int cost = edges.get(i).getDistance();
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			
			// 사이클이 발생하지 않는 경우에만 집합에 포함(이미 같은 부모노드라면 해당간선은 최소비용으로 포함된것)
			if(findParent(a) != findParent(b)) {
				unionParent(a, b);
				
				result += cost;	// 최소 신장 트리를 구성하는 비용
			}
				
		}
		
		System.out.println(result);

	}	// end of main

	// 특정 원소가 속한 집합을 찾기
	public static int findParent(int x) {
		// 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
		if(x == parent[x])
			return x;
		
		return parent[x] = findParent(parent[x]);
	}

	// 두 원소가 속한 집합을 합치기
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
		
	}


}	// end of class
