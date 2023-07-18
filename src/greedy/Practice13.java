package greedy;

import java.util.Arrays;

class Practice13 {
	// 섬 연결하기(프로그래머스 lv3)
	// => 크루스칼 알고리즘
	static int[] parent;
	
	// 특정 원소가 속한 집합 찾기
	public static int findParent(int x) {
		if(parent[x] == x)
			return x;
		
		return parent[x] = findParent(parent[x]);
	}
	
	// 두 노드가 속한 집합 합치기
	public static void unionParent(int a , int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a > b)
			parent[a] = b;
		else
			parent[b] = a;
	}
	
	public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for (int i = 0; i < n; i++) 
			parent[i] = i;
		
        // 적은 비용순으로 연결하도록 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]); // 오름차순 정렬
		
        
        for (int i = 0; i < costs.length; i++) {
			int a = costs[i][0];
			int b = costs[i][1];
			int c = costs[i][2];
			
			// 두 노드의 루트 노드가 다르면
			if(findParent(a) != findParent(b)) {
				unionParent(a, b); // 루트 노드 합치기
				answer += c;
			}
		}
        
        return answer;
    }

	
	public static void main(String args[]) {
		
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.println(solution(n, costs));
				
	} // end of main

}	// end of class