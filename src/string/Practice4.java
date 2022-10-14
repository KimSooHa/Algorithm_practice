package string;

import java.util.Arrays;

public class Practice4 {
	// 없는 숫자 더하기(프로그래머스 - 월간 코드 챌린지 시즌3)
	
	public static int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        
        for(int i=0; i<=9; i++) {	// 모든 원소만큼 돌면서
            boolean flag = false;
            
            for(int j=0; j<numbers.length; j++) { 
                if(i == numbers[j]) {	// 배열에 현재 원소가 있으면
                    flag = true;
                    break;
                }
            }
            
            if(!flag)	// 원소가 없으면
                answer += i;	// answer에 원소 더하기
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		
		int[] numbers = {5,8,4,0,6,7,9};
		
		
		System.out.println(solution(numbers));
		

	}

}
