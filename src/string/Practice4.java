package string;

import java.util.Arrays;

public class Practice4 {
	// ���� ���� ���ϱ�(���α׷��ӽ� - ���� �ڵ� ç���� ����3)
	
	public static int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        
        for(int i=0; i<=9; i++) {	// ��� ���Ҹ�ŭ ���鼭
            boolean flag = false;
            
            for(int j=0; j<numbers.length; j++) { 
                if(i == numbers[j]) {	// �迭�� ���� ���Ұ� ������
                    flag = true;
                    break;
                }
            }
            
            if(!flag)	// ���Ұ� ������
                answer += i;	// answer�� ���� ���ϱ�
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		
		int[] numbers = {5,8,4,0,6,7,9};
		
		
		System.out.println(solution(numbers));
		

	}

}
