package dp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice2 {
	// 못생긴 수
	
	public static int n;	// n번째 못생긴 수
	public static int[] ugly = new int[1000];	// 다이나믹 프로그래밍을 위한 DP 테이블 초기화
		

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		
		// 2배, 3배, 5배를 위한 인덱스
		int i2 = 0, i3 = 0, i5 = 0;
		
		// 처음에 곱셈 값을 초기화
		int next2 = 2, next3 = 3, next5 = 5;
		
		
		ugly[0] = 1;	// 첫번째 못생긴 수는 1
		
		
		// 1부터 n까지의 못생긴 수들을 찾기
		for(int j=1; j<n; j++) {
			// 가능한 곱셈 결과 중에서 가장 작은 수를 선택
			ugly[j] = Math.min(next2, Math.min(next3, next5));	
			
			// 인덱스에 따라서 곱셈 결과를 증가
			if(ugly[j] == next2) {	// j번째 수가 2배수라면
				i2++;	
				next2 = ugly[i2]*2;	// 다음 인덱스의 값에 2 곱하기
			}
			if(ugly[j] == next3) {	// j번째 수가 3배수라면
				i3++;	
				next3 = ugly[i3]*3;	// 다음 인덱스의 값에 3 곱하기	
			}
			if(ugly[j] == next5) {	// j번째 수가 5배수라면
				i5++;	
				next5 = ugly[i5]*5;	// 다음 인덱스의 값에 5 곱하기	
			}
		}
		
		
		
		// n번째 못생긴 수 결과 출력
		System.out.println(ugly[n-1]);


	}	// end of main

}	// end of class
