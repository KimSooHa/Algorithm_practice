package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice5 {
	// 떡볶이 떡 만들기

	public static void main(String[] args) throws IOException {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 떡의 개수(N)
		int m = Integer.parseInt(st.nextToken()); // 요청한 떡의 길이(M)
		
		// 떡의 개별 높이 정보
		int arr[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		// 이진탐색을 위한 정렬
		Arrays.sort(arr);
		int start = 0;
		int end = arr[n-1];
		int result = 0; // 절단기 최대 높이
		
		while(start <= end) {
			long total = 0;
			int mid = (start + end) / 2;
			for(int i=0; i<n; i++) {
				if(arr[i] > mid)
					total += arr[i] - mid;
			}
			// 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 탐색)
			if(total < m)
				end = mid - 1;
			else { // 자른 떡을 합한 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
				result = mid;
				start = mid + 1;
			}
		}
		
		System.out.println(result);
	}	// end of main
	
}	// end of class
