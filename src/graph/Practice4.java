package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice4 {
	// 탑승구
	
	// union-find
	
	static int g, p; // 노드의 수(g)와 비행기의 개수(p)
	// 부모 테이블 초기화
	static int[] parent;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		g = Integer.parseInt(br.readLine());
		p = Integer.parseInt(br.readLine());
	
		parent = new int[g+1];
		for (int i = 0; i <= g; i++) 
			parent[i] = i;
		
		int result = 0;
		// Union 연산을 각각 수행
		for (int i = 0; i < p; i++) {
			int x = Integer.parseInt(br.readLine());
			int root = findParent(x);
			if(root == 0) // 현재 루트가 0이라면, 종료
				break;
			// 그렇지 않다면 바로 왼쪽의 집합과 합집합 연산 수행
			unionParent(root, root-1);
			result++;
		}
		
		System.out.println(result);
	}	// end of main

	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a<b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	public static int findParent(int x) {
		// 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
		if(x == parent[x])
			return x;
		
		return parent[x] = findParent(parent[x]);
	}

}	// end of class
