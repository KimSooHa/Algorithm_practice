package bfs;

import java.util.ArrayList;

public class Practice2 {
	// Ÿ�ٳѹ�(���α׷��ӽ�)
	// Ư�� ���� ������ �ٲ� Ÿ���� ã��

	public static int solution(int[] numbers, int target) {
		ArrayList<Integer> arr = new ArrayList<>();
		int sum = 0;	// �迭 �հ�
		int count = 0;	// ����� ��
		
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
			
			// Ư�� ���� ������ �ٲ� ��ü ���� ��ü �� - (������ �ٲ� �� * 2)�� ����
			prevSum = prevSum - (newNums.get(i) * 2);
			
			if(prevSum < target)	// Ÿ�ٺ��� �۱� ������ ���� �հ迡�� ���� �ε����� ���� ��
				continue;
			// Ÿ�ٰ� �����ϸ� ����� �� ����
			else if(prevSum == target) 
				count++;
			else // Ÿ�ٺ��� ũ�� ������ ���� ���� �հ迡�� ���� �ε����� ���� �̾ ��
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
