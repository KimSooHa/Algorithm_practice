package greedy;

import java.util.Arrays;

class Practice13 {
	// �� �����ϱ�(���α׷��ӽ� lv3)
	// => ũ�罺Į �˰���
	static int[] parent;
	
	// Ư�� ���Ұ� ���� ���� ã��
	public static int findParent(int x) {
		if(parent[x] == x)
			return x;
		
		return parent[x] = findParent(parent[x]);
	}
	
	// �� ��尡 ���� ���� ��ġ��
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
		
        // ���� �������� �����ϵ��� ����
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]); // �������� ����
		
        
        for (int i = 0; i < costs.length; i++) {
			int a = costs[i][0];
			int b = costs[i][1];
			int c = costs[i][2];
			
			// �� ����� ��Ʈ ��尡 �ٸ���
			if(findParent(a) != findParent(b)) {
				unionParent(a, b); // ��Ʈ ��� ��ġ��
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