package sorting;

import java.util.Arrays;

public class Practice4 {
	// ���� ū ��(���α׷��ӽ�)
	// ���ϴ� �� ���ڸ� ��, �ڷ� �����ư��� �̾���� ���� �������� ���ϱ�
	
	public static String solution(int[] numbers) {
		String[] arr = new String[numbers.length];
		
        
        for(int i=0; i<arr.length; i++) {
        	arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2) -> -(o1 + o2).compareTo(o2 + o1));	// ���ϴ� �� ���ڸ� ��, �ڷ� �����ư��� �̾���� ���� �������� �� => �������� ����
        
        if(arr[0].equals("0")) {
        	return "0";
        }
        
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<arr.length; i++)
        	answer.append(arr[i]);
        
        
        return answer.toString();
    }
	
	public static void main(String[] args) {
		
		int[] numbers = {6, 10, 2};
		
		String answer = solution(numbers);
		
		System.out.println(answer);
		
	}	// end of main

}	// end of class
