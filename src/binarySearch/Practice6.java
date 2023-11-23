package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice6 {
	// 예산(백준 2512)
	// 가능한 한 최대의 총 예산 배정
	// 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정
	// 2. 모든 요청이 배정할 수 없는 경우에는 특수한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정. 상한액 이하의 예산요청에 대해서는 요청한 금액 그대로 배정. 

	static int n; // 지방의 수
	static int m; // 총 예산
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		// 이진탐색을 위한 정렬
		Arrays.sort(arr);
		
		int start = 0;
		int end = arr[n-1];
		int result = 0; // 상한액
		
		while(start <= end) {
			long total = 0;
			int mid = (start + end) / 2;
			for(int i=0; i<n; i++) {
				if(arr[i] > mid)
					total += mid;
				else
					total += arr[i];
			}
			// 총 예산이 남을 경우 더 많이 자르기(오른쪽 탐색)
			if(total <= m) {
				start = mid + 1;
				result = mid;				
			}
			else // 총 예산이 부족할 경우 덜 자르기(왼쪽 탐색)
				end = mid - 1;
		}
		System.out.println(result);
	}	// end of main
}	// end of class
