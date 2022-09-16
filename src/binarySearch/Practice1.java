package binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice1 {
	// 공유기 설치(백준 2110)

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 집의 개수, 공유기 개수
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		// 집의 좌표
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			arr.add(sc.nextInt());
		
		// 이진탐색을 위한 정렬 수행
		Collections.sort(arr);
		
		// 이진탐색을 위한 시작점과 끝점 설정
		int start = 1;	// 가능한 최소거리
		int end = arr.get(n-1) - arr.get(0);	// 가능한 최대거리
		int result = 0;	// 가장 인접한 공유기 사이의 최대거리
		
		// 이진탐색 수행
		while(start <= end) {
			int mid = (start + end) / 2;	// 가장 인접한 두 공유기 사이의 거리
			
			// 첫째 집에는 무조건 공유기를 설치한다고 가정
			int value = arr.get(0);	// 현재 설치한 공유기 집
			int cnt = 1;	// 설치한 공유기 개수
			
			// 현재의 mid 값을 이용해 공유기 설치하기
			for(int i=1; i<n; i++) {
				// 현재 집이 집에서 기준거리 이상 떨어져있다면
				if(arr.get(i) >= mid + value) {
					value = arr.get(i);	// 공유기 설치한 집 갱신
					cnt++;
				}
			}
			
			// c개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시키기(공유기 설치 간격 넓히기)
			if(cnt >= c) {
				start = mid + 1;
				result = mid;	// 최적의 결과를 저장
			}
			// c개 이상의 공유기를 설치할 수 없는 경우, 거리를 감소시키기(공유기를 설치할 수 있는 간격 좁히기)
			else 
				end = mid - 1;
			
		}
		
		System.out.println(result);

	}

}
