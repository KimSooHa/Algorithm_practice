package sorting;

import java.util.Arrays;

public class Practice4 {
	// 가장 큰 수(프로그래머스)
	// 비교하는 두 숫자를 앞, 뒤로 번갈아가며 이어붙인 것을 기준으로 비교하기
	
	public static String solution(int[] numbers) {
		String[] arr = new String[numbers.length];
		
        
        for(int i=0; i<arr.length; i++) {
        	arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2) -> -(o1 + o2).compareTo(o2 + o1));	// 비교하는 두 숫자를 앞, 뒤로 번갈아가며 이어붙인 것을 기준으로 비교 => 내림차순 정렬
        
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
