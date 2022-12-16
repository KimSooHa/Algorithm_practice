package implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice6 {
	// 모의고사(프로그래머스) 
	
	// 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	// 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	// 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	
	
	// 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
	// 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

	// 시험은 최대 10,000 문제로 구성되어있습니다.
	// 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
	// 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
	
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