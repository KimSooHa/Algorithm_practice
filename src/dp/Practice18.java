package dp;

public class Practice18 {
	// �����Ա�(���α׷��ӽ� lv2)
	
	static int solution(int[][] land) {
        int answer = 0;
        // �� ���� �� ������ �ִ밪�� ����
        int[][] dp = new int[land.length+1][land[0].length];
        
        // ���� ���� ���� ���� ���ϱ� ���� �ε��� 1���� ����
        for(int i=1; i<=land.length; i++) {
        	// �� ���� ���� ���
            for(int j=0; j<land[0].length; j++) {
            	// ���� ���� ������ ������ ���� ���� ���� ���� ���� �ִ� ���ϱ�
                for(int k=0; k<land[0].length; k++) {
                    // ���� ���� ����
                    if(j == k) continue;
                    // ������ ���� ���� ��갪�� �ִ� ���ؼ� �����ϱ�
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
