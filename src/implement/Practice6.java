package implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice6 {
	// ���ǰ��(���α׷��ӽ�) 
	
	// 1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	// 2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	// 3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	
	
	// 1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, 
	// ���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

	// ������ �ִ� 10,000 ������ �����Ǿ��ֽ��ϴ�.
	// ������ ������ 1, 2, 3, 4, 5�� �ϳ��Դϴ�.
	// ���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� �������ּ���.
	
	public static int[] solution(int[] answers) {
	 	
        ArrayList<Integer> list = new ArrayList<>();
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int[] arr = new int[3];
        
        int maxScore = 0;
        
        for(int i=0; i<answers.length; i++) {
        	if(answers[i] == one[i%one.length]) {
        		arr[0]++;
        		System.out.println(arr[0]);
        	}

        	if(answers[i] == two[i%two.length]) {
        		arr[1]++;
        		System.out.println(arr[1]);
        	}

        	if(answers[i] == three[i%three.length]) {
        		arr[2]++;
        		System.out.println(arr[2]);
        	}
        }
        
        
        for(int i=0; i<arr.length; i++) 
        	maxScore = Math.max(maxScore, arr[i]);
        
        	
        
        for(int i=0; i<arr.length; i++) {
        	if(maxScore == arr[i]) {
        		list.add(i+1);
        	}
        }
        
        int[] answer = new int[list.size()];

        for(int i=0; i<list.size(); i++) 
        	answer[i] = list.get(i);
        	
        
        return answer;
    }
	
	public static void main(String args[]) {
		int[] answers = {1,2,3,4,5};
		int[] answer = solution(answers);
		
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");			
		}
	}	// end of main
	
}	// end of class