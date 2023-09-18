package implement;

import java.util.HashMap;
import java.util.Map;

public class Practice61 {
	// 할인 행사(프로그래머스 lv2)

	static Map<String, Integer> wantPrdNumMap = new HashMap<>();
	static Map<String, Integer> canBuyDiscountPrdNumMap = new HashMap<>();

	static boolean canSignUp() {

		for (String needProduct : wantPrdNumMap.keySet()) {

			int needNum = wantPrdNumMap.get(needProduct);
			int canBuyNum = canBuyDiscountPrdNumMap.getOrDefault(needProduct, 0);

			if (canBuyNum != needNum)
				return false;
		}

		return true;
	}

	static int findSignUpDates(String[] discount) {

		int signUpDateNum = 0;

		for (int i = 0; i < discount.length; i++) {

			if (wantPrdNumMap.containsKey(discount[i])) {

				int canBuyNum = canBuyDiscountPrdNumMap.getOrDefault(discount[i], 0);
				canBuyDiscountPrdNumMap.put(discount[i], canBuyNum + 1);
			}

			if (i >= 10) {

				if (wantPrdNumMap.containsKey(discount[i - 10])) {

					int canBuyNum = canBuyDiscountPrdNumMap.getOrDefault(discount[i - 10], 0);
					canBuyDiscountPrdNumMap.put(discount[i - 10], canBuyNum - 1);
				}
			}

			if (canSignUp() == true)
				signUpDateNum++;

		}

		return signUpDateNum;
	}

	public static int solution(String[] want, int[] number, String[] discount) {

		// 원하는 상품들의 개수를 hash map으로 저장해 놓는다.
		// 연속되는 10일 간의 할인 상품들의 개수를 hash map으로 저장해 놓고
		// 앞서 저장해 놓았던 원하는 상품들의 개수와 비교해서 일치하면 회원 가입 가능한 날짜라고 판단한다.
		// 처음 10일 이후부터는 10일의 범위에 벗어난 이전 상품 데이터를 갱신해 준다.

		int answer = 0;

		for (int i = 0; i < want.length; i++)
			wantPrdNumMap.put(want[i], number[i]);

		answer = findSignUpDates(discount);

		return answer;
	}

	public static void main(String[] args) {

		// ex1
		String[] want1 = { "banana", "apple", "rice", "pork", "pot" };
		int[] number1 = { 3, 2, 2, 2, 1 };
		String[] discount1 = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
				"pot", "banana", "apple", "banana" };
		System.out.println(solution(want1, number1, discount1));

		// ex2
		String[] want2 = { "apple" };
		int[] number2 = { 10 };
		String[] discount2 = { "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
				"banana" };
		System.out.println(solution(want2, number2, discount2));

	} // end of main

} // end of class
