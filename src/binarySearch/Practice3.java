package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice3 {
	// 고정점 찾기

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 원소 개수
		int n = Integer.parseInt(st.nextToken());
		
		// 전체 원소 입력받기
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		// 값이 [시작점, 끝점] 범위에 있는 고정점(값이 인덱스와 동일한 원소) 찾기
		int index = binarySearch(arr, 0, n-1);	// 배열, 시작점, 끝점
		
		System.out.println(index);

	}	// end of main

	// 이진탐색 소스코드
	public static int binarySearch(int[] arr, int start, int end) {
		
		if(start > end)
			return -1;
		
		int mid = (start + end) / 2;
		
		// 고정점을 찾은 경우 고정점 인덱스 반환
		if(arr[mid] == mid)
			return mid;
		// 중간점의 값보다 중간점이 작은 경우 왼쪽 확인
		if(arr[mid] > mid)
			return binarySearch(arr, start, mid-1);
		// 중간값의 값보다 중간점이 큰 경우 오른쪽 확인
		else
			return binarySearch(arr, mid+1, end);	
	}

	
}	// end of class
