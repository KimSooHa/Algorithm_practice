package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice16 {
	// 분수찾기(백준 1193) 
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		// T = 분모 + 분자(짝수일 때는 왼쪽아래에서 오른쪽 위 방향 / 홀수일 때는 오른쪽 위에서 왼쪽 아래 방향으로 진행)
		// crossCnt(대각선 개수 = T-1), prevCntSum(직전 대각선까지의 블럭 개수)
		int crossCnt = 1, prevCntSum = 0;
		
		while (true) {
			// 직전 대각선 누적합 + 해당 대각선 개수 이용한 범위 판별
			if (x <= prevCntSum + crossCnt) {
				
				if (crossCnt % 2 == 1) { // 대각선의 개수가 홀수라면(T가 짝수라면)
					// 분자가 큰 수부터 시작
					// 분자 = 대각선상 블럭의 개수 - (X 번째 - 직전 대각선까지의 블럭 개수) + 1 => 대각선상 블럭의 개수 - 분모값 + 1(대각선의 개수(crossCnt)와 분모+분자의 합(T)의 차이 1)
					// 분모 = X 번째 - 직전 대각선까지의 블럭 개수
					System.out.print((crossCnt - (x - prevCntSum) + 1) + "/" + (x - prevCntSum));
					break;
				}
				
				else {	// 대각선의 개수가 짝수라면 (T가 홀수라면)
					// 홀수일 때의 출력을 반대로 
					System.out.print((x - prevCntSum) + "/" + (crossCnt - (x - prevCntSum) + 1));
					break;
				}
 
			} else {
				prevCntSum += crossCnt;
				crossCnt++;
			}
		}
		
	}	// end of main
	
}	// end of class