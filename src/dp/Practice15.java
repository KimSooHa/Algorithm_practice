package dp;

import java.util.ArrayList;
import java.util.List;

public class Practice15 {
	// N으로 표현(프로그래머스)
	// n으로 만들 수 있는 최소 숫자를 찾기 x. 숫자를 i개 사용했을 때 만들어지는 모든 수들을 하나의 통에 담기

	public static int solution(int N, int number) {
        
        List<ArrayList<Integer>> list = new ArrayList<>();
        
        // 총 8개의 통 만들기
        for (int i = 0; i <= 8; i++) 
			list.add(new ArrayList<>());
        
        list.get(1).add(N); // 숫자 1개만 쓸 땐 자기 자신밖에 못들어감(초기화)
		
    	if(number == N)
    		return 1;
    	
    	// 숫자 2개부터 탐색
    	for (int i = 2; i <= 8; i++) {
    		ArrayList<Integer> total = list.get(i); // 숫자를 i개 썼을 때의 숫자들이 들어갈 리스트
    		
    		// 이전 리스트들 가지고 찾기
    		for (int j = 1; j < i; j++) {
				ArrayList<Integer> a = list.get(j);
				ArrayList<Integer> b = list.get(i-j);
				
				for(int x : a) {
					for(int y : b) {
						total.add(x+y);
						total.add(x-y);
						total.add(x*y);
						if(x != 0 && y != 0)
							total.add(x/y);
					}
				}
				// 같은 숫자로 된것 추가하기
				// n을 반복횟수만큼 붙여서 넣어주기
				total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
			}
    		
    		if(total.contains(number))
    			return i;
		}
        
        return -1;
    }
	
	

	public static void main(String[] args) {

		
		int n = 5;
		int number = 12;
		
		System.out.println(solution(n, number));

	} // end of main

} // end of class
