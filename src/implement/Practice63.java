package implement;

import java.util.HashMap;
import java.util.Map;

public class Practice63 {
	// 추억 점수(프로그래머스 lv1)

	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++) 
            map.put(name[i], yearning[i]);
        
        for(int i=0; i<photo.length; i++) {
            int num = 0;
            for(int j=0; j<photo[i].length; j++) 
                num += map.containsKey(photo[i][j]) ? map.get(photo[i][j]) : 0;
            
            answer[i] = num;
        }
        
        return answer;
    }

	public static void main(String[] args) {

		// ex1
		String[] name1 = {"may", "kein", "kain", "radi"};
		int[] yearning1 = {5, 10, 1, 3};
		String[][] photo1 = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
		int[] result1 = solution(name1, yearning1, photo1);
		for (int i : result1) 			
			System.out.println(i);
		
		System.out.println("----------------");
		// ex2
		String[] name2 = {"kali", "mari", "don"};
		int[] yearning2 = {11, 1, 55};
		String[][] photo2 = {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};
		int[] result2 = solution(name2, yearning2, photo2);
		for (int i : result2) 			
			System.out.println(i);
		
		System.out.println("----------------");

		String[] name3 = {"may", "kein", "kain", "radi"};
		int[] yearning3 = {5, 10, 1, 3};
		String[][] photo3 = {{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};
		int[] result3 = solution(name3, yearning3, photo3);
		for (int i : result3) 			
			System.out.println(i);

	} // end of main

} // end of class
