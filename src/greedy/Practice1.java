package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice1 {
	// 모험가 길드 => 받은 입력값(공포도)을 작은 수부터 정렬하는 것이 중요

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			arrayList.add(sc.nextInt());
		
		Collections.sort(arrayList);
		
		int result = 0;	// 떠날 수 있는 총 그룹의 수
		int cnt = 0;	// 현재 그룹에 포함된 모험가의 수
		
		for(int i=0; i<n; i++) {	// 공포도를 낮은 것부터 하나씩 확인하며
			
			cnt += 1;
			
			if(cnt >= arrayList.get(i)) {	// 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
				result += 1;	// 총 그룹의 수 증가시키기	
				cnt = 0;	// 현재 그룹에 포함된 모험가의 수 초기화
			}
		}

		System.out.println(result);
		
	}	// end of main

}	// end of class
