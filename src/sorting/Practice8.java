package sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

public class Practice8 {
	// 문자열 내 마음대로 정렬하기(프로그래머스 lv1)
	
	public static String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(strings);
        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) - o2.charAt(n));
        answer = strings;
        
        return answer;
    }
	
	public static void main(String[] args) throws IOException {
		
		// case1
		String[] strings1 = {"sun", "bed", "car"};
		int n = 1;
		String[] answer = solution(strings1, n);
		for(String s : answer)
			System.out.println(s);
			
		System.out.println("-----");
		
		// case2
		String[] strings2 = {"abce", "abcd", "cdx"};
		n = 2;
		answer = solution(strings2, n);
		for(String s : answer)
			System.out.println(s);
		
	}	// end of main

}	// end of class
