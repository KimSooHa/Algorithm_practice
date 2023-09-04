package sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Practice9 {
	// 두 개 뽑아서 더하기(프로그래머스)

	public static int[] solution(int[] numbers) {

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}

		int[] answer = new int[set.size()];
		Iterator<Integer> iter = set.iterator();
		for (int i = 0; i < set.size(); i++)
			answer[i] = iter.next();

		Arrays.sort(answer);

		return answer;
	}

	public static void main(String[] args) {

		int[] numbers = { 2, 1, 3, 4, 1 };
		int[] results = solution(numbers);

		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}

	} // end of main
} // end of class
