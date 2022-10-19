package bfs;

import java.util.ArrayList;

public class Practice2 {
	// 타겟넘버(프로그래머스)
	// 특정 수를 음수로 바꿔 타겟을 찾기

	public static int solution(int[] numbers, int target) {
		ArrayList<Integer> arr = new ArrayList<>();
		int sum = 0;	// 배열 합계
		int count = 0;	// 방법의 수
		
		for(int i=0; i<numbers.length; i++) {
			arr.add(i, numbers[i]);
			sum += numbers[i];
		}
		
		count = makeTarget(arr, 0, sum, target, count);
		
		return count;
	}
	
	public static int makeTarget(ArrayList<Integer> numbers, int index, int sum, int target, int count) {
		
		int partCnt = 0;
		
		for(int i=index; i<numbers.size(); i++) {
			
			int prevSum = sum;
			ArrayList<Integer> newNums = new ArrayList<>();
			newNums.addAll(numbers);
			
			// 특정 수만 음수로 바꾼 전체 합은 전체 합 - (음수로 바꿀 수 * 2)가 성립
			prevSum = prevSum - (newNums.get(i) * 2);
			
			if(prevSum < target)	// 타겟보다 작기 때문에 기존 합계에서 다음 인덱스값 빼서 비교
				continue;
			// 타겟과 동일하면 경우의 수 증가
			else if(prevSum == target) 
				count++;
			else // 타겟보다 크기 때문에 현재 빠진 합계에서 다음 인덱스값 빼고 이어서 비교
				count += makeTarget(newNums, i+1, prevSum, target, partCnt);
			
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
		
	}	// end of main

}	// end of class
