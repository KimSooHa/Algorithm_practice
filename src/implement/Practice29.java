package implement;

import java.io.IOException;
import java.util.Scanner;

class Practice29 {
	// 문자열 압축(프로그래머스 lv2)
	
	public static int solution(String s) {
        int answer = 0;
        for(int i=1; i<=(s.length()/2)+1; i++) {
        	int result = getSplitedLength(s, i, 1).length();
        	answer = i == 1 ? result : Math.min(answer, result);
        }
        return answer;
    }
	
	public static String getSplitedLength(String s, int n, int repeat) {
		// 문자열 길이가 자르는 기준인덱스보다 작으면 기존 문자열 반환
		if(s.length() < n) return s;
		
		String result = "";
		String preString = s.substring(0, n);	// n번째까지 자르기(자르는 기준문자)
		String postString = s.substring(n);	// 자르고 나머지 뒷부분
		
		// 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
		if(!postString.startsWith(preString)) {
			if(repeat == 1) return result += preString + getSplitedLength(postString, n, 1);
			return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
		}
		
		return result += getSplitedLength(postString, n, repeat+1);
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int answer = solution(s);
		System.out.println(answer);
		
	}	// end of main

}	// end of class