package dp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice1 {
	// 병사 배치하기(백준 18353) - 실버2
	// 가장 긴 감소하는 부분 수열(LDS) = 가장 긴 증가하는 부분 수열로 바꿔서 풀기!
	
	public static int n;	// 전체 병사 수
	public static ArrayList<Integer> v = new ArrayList<>();
	public static int[] dp = new int[2000];	// 다이나믹 프로그래밍을 위한 DP 테이블 초기화
		

public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			v.add(x);
		}
		
		// 순서를 뒤집어 '최장 증가 부분 수열' 문제로 변환
		Collections.reverse(v);
		
		// 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
		for(int i=0; i<n; i++)
			dp[i] = 1;
		
		// 가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(v.get(j) < v.get(i))
					dp[i] = Math.max(dp[i], dp[j] + 1);	// 기준 값보다 앞의 값이 작다면 증가하고 있는 것이기 때문에 앞의 테이블의 값의 최대값에서 1씩 증가해서 저장
			}
		}
		
		// 열외해야 하는 병사의 최소 수를 출력
		int maxValue = 0;
		for(int i=0; i<n; i++) {
			maxValue = Math.max(maxValue, dp[i]);	// 남아있는 병사의 최대 수
		}
		
		
		// 계산된 결과 출력
		System.out.println(n - maxValue);	// 열외시켜야 할 병사 수이기 때문에 기존 병사 수 - 남아있는 최대 병사수


	}	// end of main

}	// end of class
