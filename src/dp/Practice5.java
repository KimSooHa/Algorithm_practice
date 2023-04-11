package dp;
import java.io.IOException;

public class Practice5 {
	// ���� �ﰢ��(���α׷��ӽ� lv3)
	
	public static int solution(int[][] triangle) {
        int answer = 0;

        int length = triangle.length;
        int[][] dp = new int[length][length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < length; i++) {
            // �� ����
            dp[i][0] = dp[i - 1][0] + triangle[i][0];

            // �߰�
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }

            // �� ������
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        for (int i = 0; i < length; i++) {
            answer = Math.max(answer, dp[length - 1][i]);
        }

        return answer;
    }
		

public static void main(String[] args) throws IOException {
		
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		int answer = solution(triangle);
		System.out.println(answer);

	}	// end of main

}	// end of class
