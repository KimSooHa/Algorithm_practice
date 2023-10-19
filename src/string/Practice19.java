package string;

import java.util.ArrayList;
import java.util.List;

public class Practice19 {
	// 옹알이(2) (프로그래머스 lv1)

	public static int solution(String[] babbling) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        list.add("aya");
        list.add("ye");
        list.add("woo");
        list.add("ma");

        for(int i=0; i<babbling.length; i++) {
            String str = "";
            String prevStr = "";
            int idx = 0;
            for(int j=0; j<babbling[i].length(); j++) {
                str += babbling[i].charAt(j);
                if(list.contains(str) && !str.equals(prevStr)) {
                    idx += str.length();
                    prevStr = str;
                    str = "";
                }
            }
            if(idx == babbling[i].length()) answer++;
        }
        return answer;
    }

	


// =========================

	// 다른 사람 풀이
	// 1.
//	public static int solution(String[] babblings) {
//        // "aya", "ye", "woo", "ma" 4가지 발음만 가능
//        int answer = 0;
//        for(int i = 0; i < babblings.length; i++) {
//            if(babblings[i].contains("ayaaya") || babblings[i].contains("yeye") || babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
//                continue;
//            }
//
//            babblings[i] = babblings[i].replace("aya", " ");
//            babblings[i] = babblings[i].replace("ye", " ");
//            babblings[i] = babblings[i].replace("woo", " ");
//            babblings[i] = babblings[i].replace("ma", " ");
//            babblings[i] = babblings[i].replace(" ", "");
//
//            if(babblings[i].length()  == 0) answer++;
//
//        }
//        return answer;
//    }

// ---------------------------
	// 2.
//	public static int solution(String[] babbling) {
//        int answer = 0;
//        for(String str:babbling){
//            if(str.contains("ayaaya") || str.contains("yeye") || str.contains("woowoo") || str.contains("mama"))
//                continue;
//            if(str.replace("aya", "1").replace("ye", "1").replace("woo", "1").replace("ma", "1").replace("1", "").length() == 0)
//                answer++;
//        }
//        return answer;
//    }

	public static void main(String[] args) {

		// ex1
		String[] babbling1 = {"aya", "yee", "u", "maa"};
		System.out.println(solution(babbling1));


		System.out.println("------");
		// ex2
		String[] babbling2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		System.out.println(solution(babbling2));		
	}
}