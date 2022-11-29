package sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Practice3 {
	// K번째 수(프로그래머스)
	
	public static int[] solution(int[] array, int[][] commands) {
		
		int[] answer = new int[commands.length];
        
        for(int c=0; c<commands.length; c++) {
         
            ArrayList<Integer> result = new ArrayList<>();
            
            for(int i=commands[c][0]-1; i<commands[c][1]; i++) {
                result.add(array[i]);
            }

            Collections.sort(result); 
            
            int k = result.get(commands[c][2]-1);
            answer[c] = k;
        }
        
        return answer;
    }
	
	public static void main(String[] args) throws IOException {
		
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] answer = solution(array, commands);
		
		for(int i=0; i<commands.length; i++)
			System.out.print(answer[i] + " ");
		
	}	// end of main

}	// end of class
