package implement;

public class Practice64 {
	// 2016년(프로그래머스 lv1)

	public static String solution(int a, int b) {

		int[] daysInMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int sum = 0;
		for (int i = 0; i < a - 1; i++)
			sum += daysInMonth[i];

		sum += b;

		switch (sum % 7) {
		case 0:
			return "THU";
		case 1:
			return "FRI";
		case 2:
			return "SAT";
		case 3:
			return "SUN";
		case 4:
			return "MON";
		case 5:
			return "TUE";
		case 6:
			return "WED";
		}

		return null;
	}

	public static void main(String[] args) {

		// ex1
		int a = 5, b = 24;
		System.out.println(solution(a, b));

	} // end of main

} // end of class
