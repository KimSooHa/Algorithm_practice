package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice2 {
	// 정렬된 배열에서 특정 수의 개수 구하기

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		// 찾고자 하는 문자열
		int x = Integer.parseInt(st.nextToken());
		
		// 전체 원소 입력받기
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		// 값이 [x, x] 밤위에 있는 데이터의 개수 계산
		int cnt = countByRange(arr, x, x);
		
		
		if(cnt == 0)
			System.out.println(-1);
		else
			System.out.println(cnt);

	}	// end of main

	// 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
	public static int countByRange(int[] arr, int leftValue, int rightValue) {
		// 유의: lowerBound와 upperBound는 end 변수의 값을 배열의 길이로 설정
		
		int rightIndex = upperBound(arr, rightValue, 0, arr.length);
		int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
		
		return rightIndex - leftIndex;
	}

	public static int lowerBound(int[] arr, int target, int start, int end) {
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] >= target)
				end = mid;
			else
				start = mid + 1;
		}
		
		return end;
	}

	public static int upperBound(int[] arr, int target, int start, int end) {
		
		while(start < end) {
			int mid = (start + end) / 2;

			// target에 해당하는 개수를 계산해야 하므로 target과 같으면 보다 큰 인덱스로 가게 비교
			if(arr[mid] > target)	
				end = mid;
			else
				start = mid + 1;
		}
		return end;
	}

}	// end of class
