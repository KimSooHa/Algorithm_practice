package implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice65 {
	// 과일 장수(프로그래머스 lv1)

	// 풀이 1
//	public static int solution(int k, int m, int[] score) {
//        int answer = 0;
//        Arrays.sort(score);
//        
//        List<Integer> list = new ArrayList<>();
//        int idx = 0;
//        
//        for(int i=score.length-1; i>=0; i--) {
//            idx++;
//            list.add(score[i]);
//            if(idx == m) {
//                answer += list.get(list.size()-1) * m * 1;
//                idx = 0;
//                list.clear();
//            }
//        }
//        
//        return answer;
//    }
	
	// 풀이 2
	public static int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        for(int i=score.length; i>=m; i -= m) 
            answer += score[i-m] * m;
        
        return answer;
    }

	public static void main(String[] args) {

		// ex1
		int k =3, m = 4;
		int[] score1 = {1, 2, 3, 1, 2, 3, 1};
		System.out.println("ex1 = " + solution(k, m, score1));
		
		// ex2
		k = 4;
		m = 3;
		int[] score2 = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
		System.out.println("ex2 = " + solution(k, m, score2));

	} // end of main

} // end of class
