package implement;

import java.util.ArrayList;

public class Practice82 {
	// 로또의 최고 순위와 최저 순위(프로그래머스 2021 Dev-Matching lv1)

	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6,5,4,3,2,1};
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<lottos.length; i++) 
            list.add(win_nums[i]);
        
        int max = 0, min = 0;
        for(int i=0; i<lottos.length; i++) {
            if(list.contains(lottos[i])) {
                max++;
                min++;
            } else if(lottos[i] == 0) 
                max++;
        }
        
        answer[0] = max < 2 ? 6 : rank[max-1];
        answer[1] = min < 2 ? 6 : rank[min-1];
        
        return answer;
    }

	public static void main(String[] args) {
		// tc1.
		int[] lottos1 = {44, 1, 0, 0, 31, 25};
		int[] win_nums1 = {31, 10, 45, 1, 6, 19};
		int[] result1 = solution(lottos1, win_nums1);
		for(int r : result1)
			System.out.println(r);
		
		System.out.println("-----");
		
		// tc2.
		int[] lottos2 = {0, 0, 0, 0, 0, 0};
		int[] win_nums2 = {38, 19, 20, 40, 15, 25};
		int[] result2 = solution(lottos2, win_nums2);
		for(int r : result2)
			System.out.println(r);
		
		System.out.println("-----");
		
		// tc3.
		int[] lottos3 = {45, 4, 35, 20, 3, 9};
		int[] win_nums3 = {20, 9, 3, 45, 4, 35};
		int[] result3 = solution(lottos3, win_nums3);
		for(int r : result3)
			System.out.println(r);
	} // end of main

} // end of class
