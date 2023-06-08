package stack_queue;

import java.util.ArrayList;

public class Practice2 {
	// 기능개발(프로그래머스 - lv2)
	
	public static int[] solution(int[] progresses, int[] speeds) {
		
		ArrayList<Integer> answer = new ArrayList<>();
        int[] arr = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
        	int rest = 100 - progresses[i];
			arr[i] = rest / speeds[i] + (rest % speeds[i] != 0 ? 1 : 0);
		}
        int max = arr[0];
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            
            if(arr[i] > max) {
				max = arr[i];
				answer.add(cnt);
				cnt = 0;
			}
			cnt++;
            
            if(i == arr.length-1 && cnt != 0)
                answer.add(cnt);
		}
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();

    }

	public static void main(String[] args) {
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		int[] answer = solution(progresses, speeds);
		
		System.out.print("[");
		
		for(int i=0; i<answer.length; i++) {
			if(i == answer.length-1)
				System.out.print(answer[i]);
			else
				System.out.print(answer[i] + ", ");
		}
		

		System.out.print("]");
	}	// end of main

}	// end of class
