package dp;

public class Practice18 {
	// 땅따먹기(프로그래머스 lv2)
	
	static int solution(int[][] land) {
        int answer = 0;
        // 각 행의 각 열마다 최대값을 저장
        int[][] dp = new int[land.length+1][land[0].length];
        
        // 앞의 행의 열의 값을 합하기 위해 인덱스 1부터 시작
        for(int i=1; i<=land.length; i++) {
        	// 각 열에 대한 계산
            for(int j=0; j<land[0].length; j++) {
            	// 현재 열을 제외한 나머지 열과 현재 열을 합한 값의 최댓값 구하기
                for(int k=0; k<land[0].length; k++) {
                    // 현재 열을 제외
                    if(j == k) continue;
                    // 나머지 열에 대한 계산값의 최댓값 비교해서 저장하기
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i-1][j]);
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		System.out.println(solution(land));
					
	} // end of main
} // end of class
