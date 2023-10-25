package implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice73 {
	// ���� ��� ���(���α׷��ӽ� lv2 - 2022 KAKAO BLIND RECRUITMENT)

	// fees[0]: �⺻ �ð�(��), fees[1]: �⺻ ���(��), fees[2]: ���� �ð�(��), fees[3]: ���� ���(��)
	// � ������ ������ �Ŀ� ������ ������ ���ٸ�, 23:59�� ������ ������ ����
	// ���� ���� �ð��� �⺻ �ð����϶��, �⺻ ����� û��
	// ���� ���� �ð��� �⺻ �ð��� �ʰ��ϸ�, �⺻ ��ݿ� ���ؼ�, �ʰ��� �ð��� ���ؼ� ���� �ð� ���� ���� ����� û��
	// �ʰ��� �ð��� ���� �ð����� ������ �������� ������, �ø�
	public static int[] solution(int[] fees, String[] records) {

		Map<String, String> map = new HashMap<>(); // ������ ���
		Map<String, Integer> parkFee = new HashMap<>(); // ������ȣ �� ���������ð�

		for (int i = 0; i < records.length; i++)
			parkFee.put(records[i].split(" ")[1], 0);

		for (int i = 0; i < records.length; i++) {
			String[] infos = records[i].split(" ");

			// ������ȣ�� �ִٸ�
			if (map.containsKey(infos[1])) {
				String[] inTime = map.remove(infos[1]).split(":"); // �����ð�
				String[] outTime = infos[0].split(":"); // �����ð�

				int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
				int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);

				parkFee.replace(infos[1], parkFee.get(infos[1]) + 60 * hour + minute); // ���� �ð��̶� ��ġ��

			} else
				map.put(infos[1], infos[0]); // �� ��ȣ, �ð�
		}

		// map�� �����ִٸ� �������� ���� ���� => ����ó��(23:59�� ������ ������ ����)
		for (String key : map.keySet()) {
			String[] inTime = map.get(key).split(":");

			int hour = 23 - Integer.parseInt(inTime[0]);
			int minute = 59 - Integer.parseInt(inTime[1]);

			parkFee.replace(key, parkFee.get(key) + 60 * hour + minute);
		}

		List<String> keySet = new ArrayList(parkFee.keySet());
		Collections.sort(keySet);

		int[] answer = new int[keySet.size()];
		int idx = 0;
		for (String key : keySet) {
			// ���� ���� �ð��� �⺻ �ð��� �ʰ��ϸ�, �⺻ ��ݿ� ���ؼ�, �ʰ��� �ð��� ���ؼ� ���� �ð� ���� ���� ����� û��(�ʰ��� �ð��� ���� �ð����� ������ �������� ������, �ø�)
			if (parkFee.get(key) > fees[0])
				answer[idx++] = fees[1] + (int) Math.ceil((parkFee.get(key) - fees[0]) / (double) fees[2]) * fees[3]; // Math.ceil�� �� ���������� ������ �Ҽ����� �������⶧���� �ø��� �ȵ� => �Ǽ������� ������!
			// ���� ���� �ð��� �⺻ �ð����϶��, �⺻ ����� û��
			else
				answer[idx++] = fees[1];
		}

		return answer;
	}

	public static void main(String[] args) {

		// ex1
		int[] fees1 = {180, 5000, 10, 600};
		String[] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] result1 = solution(fees1, records1);
		for(int num : result1)
			System.out.println(num);

		System.out.println("===========");
		// ex2
		int[] fees2 = {120, 0, 60, 591};
		String[] records2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		int[] result2 = solution(fees2, records2);
		for(int num : result2)
			System.out.println(num);

		System.out.println("===========");

		// ex3
		int[] fees3 = {1, 461, 1, 10};
		String[] records3= {"00:00 1234 IN"};
		int[] result3 = solution(fees3, records3);
		for(int num : result3)
			System.out.println(num);

		

	} // end of main

} // end of class
