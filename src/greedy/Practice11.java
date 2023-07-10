package greedy;

import java.util.Arrays;
import java.util.Comparator;

class Practice11 {
	// 단속 카메라(프로그래머스)
	
	public static int solution(int[][] routes) {
        int answer = 0;
        
        int target = -30001;
        
        // 카메라를 먼저 진출한 지점 순서대로 설치하기(진출순서대로 오름차순 정렬)
        Arrays.sort(routes, new Comparator<int[]>() {
        	
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return o1[1] - o2[1];
        	}
		});
        
        
        for (int i = 0; i < routes.length; i++) {
        	// 진입구간이 현재 카메라의 설치구간보다 작으면, 그냥 다음 값으로 넘기기
    		if(target >= routes[i][0])
    			continue;
				
			answer++;
        	target = routes[i][1]; // 현재 카메라의 위치를 현재 종점위치로 갱신
		}
        
        
        return answer;
    }

	
	public static void main(String args[]) {
		
		int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		
		System.out.println(solution(routes));
				
	} // end of main

}	// end of class