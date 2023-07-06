package greedy;

class Practice10 {
	// 최고의 집합(프로그래머스 연습문제)
	// 가능한 집합 중 값들의 차이가 가장 작은 케이스로 답이 이뤄짐
	
	public static int[] solution(int n, int s) {
        int[] answer;
        
		
		if(s < n) {
			answer = new int[] {-1};
			return answer;
		}
		
		int init = s / n; // 몫
		int mod = s % n; // 나머지
		
		answer = new int[n];
		
		// 배열의 모든 값을 몫으로 초기화
		for (int i = 0; i < n; i++) 
			answer[i] = init;
		
		// 나머지 만큼 뒤에서부터(오름차순 정렬이 되게) 1씩 더해줌
		int idx = n - 1;
		for (int i = 0; i < mod; i++) {
			answer[idx]++;
			idx--;
		}
        
        return answer;
    }

	
	public static void main(String args[]) {
		
		int n = 2;
		int s = 9;
		
		int[] answer = solution(n, s);
		
		for (int i = 0; i < n; i++) 
			System.out.println(answer[i]);
		
				
	} // end of main

}	// end of class