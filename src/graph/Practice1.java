package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Practice1 {
	// 여행계획
	
		// 여행지의 갯수(n), 도시의 갯수(m)
		public static int n, m;
		public static StringTokenizer st;
		
		public static final int INF = (int) 1e9;	// 무한대 의미(10억)
			
		
		// 부모 테이블 초기화 => 노드의 개수는 최대 501개(0~500)로 지정
		public static int[] parent = new int[501];

		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());	// 여행지 갯수(node)
			m = Integer.parseInt(st.nextToken());	// 도시 갯수(edge)
			
			// 부모 테이블상에서, 모두 자기 자신으로 초기화
			for(int i=1; i<=n; i++) 
				parent[i] = i;
			
			
			// Union 연산을 각각 수행
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					int x = Integer.parseInt(st.nextToken());
					if(x == 1)
						unionParent(i+1, j+1);	// 1,2을 합집합(union) 연산 수행
				}
			}
			
			// 여행 계획 입력받기
			ArrayList<Integer> plan = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<m; i++) {
				int x = Integer.parseInt(st.nextToken());
				plan.add(x);
			}
			
			boolean result = true;
			
			// 여행 계획에 속하는 모든 노드의 루트가 동일한지 확인
			for(int i=0; i<m-1; i++) {
				if(findParent(plan.get(i)) != findParent(plan.get(i+1)))
					result = false;
			}
			
			// 여행 계획에 속하는 모든 노드가 서로 연결되어 있는지(루트가 동일한지) 확인
			if(result)
				System.out.println("YES");
			else
				System.out.println("NO");
			
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
