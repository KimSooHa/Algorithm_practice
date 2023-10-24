package implement;

import java.util.HashMap;
import java.util.Map;

public class Practice72 {
	// 모음사전(프로그래머스 lv2)

	// 5번째 = 1, 2, 3, 4, 5 .. += 5
	// => 4번째 = 1, 7, 13, 19, 25... +=6
	// 3번째 = 1, 32, 63, 94, 125... += 31
	// 2번째 = 1, 157, 313, 469, 625 += 156
	// 1번째 = 1, 782, 1563, 2344, 3125 += 781
	
	public static int solution(String word) {
		int answer = 0;
		Map<Character, Integer> first = new HashMap<>();
		Map<Character, Integer> second = new HashMap<>();
		Map<Character, Integer> third = new HashMap<>();
		Map<Character, Integer> fourth = new HashMap<>();
		Map<Character, Integer> fifth = new HashMap<>();

		first.put('A', 1);
		first.put('E', 782);
		first.put('I', 1563);
		first.put('O', 2344);
		first.put('U', 3125);

		second.put('A', 1);
		second.put('E', 157);
		second.put('I', 313);
		second.put('O', 469);
		second.put('U', 625);

		third.put('A', 1);
		third.put('E', 32);
		third.put('I', 63);
		third.put('O', 94);
		third.put('U', 125);

		fourth.put('A', 1);
		fourth.put('E', 7);
		fourth.put('I', 13);
		fourth.put('O', 19);
		fourth.put('U', 25);

		fifth.put('A', 1);
		fifth.put('E', 2);
		fifth.put('I', 3);
		fifth.put('O', 4);
		fifth.put('U', 5);

		for (int i = 0; i < word.length(); i++) 
			answer += (i == 0) ? first.get(word.charAt(i))
					: i == 1 ? second.get(word.charAt(i))
							: i == 2 ? third.get(word.charAt(i))
									: i == 3 ? fourth.get(word.charAt(i)) : fifth.get(word.charAt(i));

		return answer;
	}

// A(1), AA(2), AAA(3), AAAA(4)
// AAAAA(5), AAAAE(4+2=6), AAAAI(4+3=7), AAAAO(4+4=8), AAAAU(4+5)
// AAAE(3+7=10), AAAEA(3+7+1=11), AAAEE(3+7+2=12), AAAEI(13), AAAEO(14), AAAEU(15)
// AAAI(3+13=16), AAAIA(3+13+1=17), AAAAIE(18), AAAII(19), AAAIO(20), AAAIU(21)
// AAAO(3+19=21)
// AAAU(3+25=28)
// AAE(2+32=24)
// ... AAUUU(2+125+25+5=157)
// AE(1+157=158), ... AUUUU(1+625+125+25+5=781)
// E(782)

	// ---------------------
	// 다른 방식 풀이
	// 1.
//	public static int solution(String word) {
//        int answer = word.length();
//        for(int pos = 0; pos < word.length(); pos++){
//            char c = word.charAt(pos);
//            if(c=='A') continue;
//            int temp = 0;
//            for(int i = 0; i <= 4-pos; i++)
//                temp += Math.pow(5,i);
//            
//            answer += temp*val(c);
//        }
//        return answer;
//    }
//
//    public static int val(char c){
//        if(c=='E') return 1;
//        else if(c=='I') return 2;
//        else if(c=='O') return 3;
//        else return 4;
//    }

	public static void main(String[] args) {

		// ex1
		String word = "AAAAE";
		System.out.println(solution(word));

		// ex2
		word = "AAAE";
		System.out.println(solution(word));

		// ex3
		word = "I";
		System.out.println(solution(word));
		
		// ex4
		word = "EIO";
		System.out.println(solution(word));
		
	} // end of main

} // end of class
