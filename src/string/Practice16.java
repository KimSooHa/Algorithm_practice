package string;

public class Practice16 {
	// 푸드 파이트 대회 (프로그래머스)

	public static String solution(int[] food) {
		String answer = "";

		for (int i = 0; i < food.length; i++)
			food[i] /= 2;

		for (int i = 0; i < food.length; i++) {
			for (int j = 0; j < food[i]; j++)
				answer += i;
		}
		answer += "0";

		for (int i = food.length - 1; i >= 0; i--) {
			for (int j = 0; j < food[i]; j++)
				answer += i;
		}

		return answer;
	}

	// 다른 사람 풀이
	// 1.
//	public String solution(int[] food) {
//		String answer = "0";
//
//		for (int i = food.length - 1; i > 0; i--) {
//			for (int j = 0; j < food[i] / 2; j++) {
//				answer = i + answer + i;
//			}
//		}
//
//		return answer;
//	}

// ---------------------------
	// 2.
//	public String solution(int[] food) {
//        StringBuilder builder = new StringBuilder();
//        for (int i=1; i<food.length; i++) {
//            int result = food[i] / 2;
//            builder.append(String.valueOf(i).repeat(result));
//        }
//        String answer = builder + "0";
//        return answer + builder.reverse();
//    }

	public static void main(String[] args) {

		int[] food = { 1, 3, 4, 6 };
		String result = solution(food);

		for (int i = 0; i < result.length(); i++)
			System.out.println(result.charAt(i));

	}
}