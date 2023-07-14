package greedy;

class Practice12 {
	// 큰 수 만들기(프로그래머스)
	// 각 자리에서 최고로 높은 수가 나오는 경우를 생각하기
	public static String solution(String number, int k) {
        String answer = "";
        char[] arr = number.toCharArray();
        int length = arr.length - k;
        // 문자 비교를 시작하는 인덱스
        int idx = 0;
        StringBuilder sb = new StringBuilder(); // 그냥 문자열 더하면 시간초과남
        
        for (int i = 0; i < length; i++) {
        	char max = '0';
			for (int j = idx; j <= i + k; j++) {
				// 가장 큰 수를 골라서 그 다음 인덱스를 시작인덱스로 갱신
				if(arr[j] > max) {
					max = arr[j];
					idx = j+1;
				}
			}
			sb.append(max);
		}
        
        answer = sb.toString();
        
        return answer;
    }

	
	public static void main(String args[]) {
		
		String number = "1924";
		int k = 2;
		
		System.out.println(solution(number, k));
				
	} // end of main

}	// end of class