package greedy;

import java.util.Arrays;
import java.util.Comparator;

class Practice11 {
	// �ܼ� ī�޶�(���α׷��ӽ�)
	
	public static int solution(int[][] routes) {
        int answer = 0;
        
        int target = -30001;
        
        // ī�޶� ���� ������ ���� ������� ��ġ�ϱ�(���������� �������� ����)
        Arrays.sort(routes, new Comparator<int[]>() {
        	
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return o1[1] - o2[1];
        	}
		});
        
        
        for (int i = 0; i < routes.length; i++) {
        	// ���Ա����� ���� ī�޶��� ��ġ�������� ������, �׳� ���� ������ �ѱ��
    		if(target >= routes[i][0])
    			continue;
				
			answer++;
        	target = routes[i][1]; // ���� ī�޶��� ��ġ�� ���� ������ġ�� ����
		}
        
        
        return answer;
    }

	
	public static void main(String args[]) {
		
		int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		
		System.out.println(solution(routes));
				
	} // end of main

}	// end of class