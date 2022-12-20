package graph;

public class Practice3 {
	// 네트워크(프로그래머스) 
	
	// union-find 방식으로 풀었음 
	
	// 부모 테이블 초기화
	public static int[] parent;
	
	 public static int solution(int n, int[][] computers) {
		 
		 int answer = 0;
		 
		 parent = new int[n];
	
		 // 부모 테이블상에서, 모두 자기 자신으로 초기화
		 for(int i=1; i<n; i++)
			 parent[i] = i;
		 
		 // Union 연산을 각각 수행
		 for(int i=0; i<n; i++) {
			 for(int j=0; j<n; j++) {
				 if(i!=j && computers[i][j] == 1)
					 unionParent(i, j);
			 }
		 }
		 
		 for(int i=0; i<n; i++) {
			 if(parent[i] == i)
				 answer++;
		 }
		 
		 
	    return answer;
	}

	public static void main(String[] args) {
		
		// ex1
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
		// ex2
//		int n = 3;
//		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
		// ex3
//		int n = 7;
//		int[][] computers = {
//					{1,0,0,0,0,0,1},
//	                {0,1,1,0,1,0,0},
//	                {0,1,1,1,0,0,0},
//	                {0,0,1,1,0,0,0},
//	                {0,1,0,0,1,1,0},
//	                {0,0,0,0,1,1,1},
//	                {1,0,0,0,0,1,1}
//                };
		
		
		int answer = solution(n, computers);
		
		System.out.println(answer);
		
	}	// end of main
	
	
	// 두 원소가 속한 집합을 합치기
	public static void unionParent(int a, int b) {	// a와 b는 연결되어있으므로
		 // 두 노드의 루트노드를 찾아서
		a = findParent(a);
		b = findParent(b);
		
		// 더 작은 노드로 합치기
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
		
	}


	// 특정 원소가 속한 집합을 찾기
	public static int findParent(int x) {
		// 루트 노드라면 그대로 반환
		if(x == parent[x])
			return x;
		
		// 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
		return parent[x] = findParent(parent[x]);
	}

}	// end of class
