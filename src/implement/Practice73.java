package implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice73 {
	// 주차 요금 계산(프로그래머스 lv2 - 2022 KAKAO BLIND RECRUITMENT)

	// fees[0]: 기본 시간(분), fees[1]: 기본 요금(원), fees[2]: 단위 시간(분), fees[3]: 단위 요금(원)
	// 어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주
	// 누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구
	// 누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구
	// 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림
	public static int[] solution(int[] fees, String[] records) {

		Map<String, String> map = new HashMap<>(); // 입출차 기록
		Map<String, Integer> parkFee = new HashMap<>(); // 차량번호 별 누적주차시간

		for (int i = 0; i < records.length; i++)
			parkFee.put(records[i].split(" ")[1], 0);

		for (int i = 0; i < records.length; i++) {
			String[] infos = records[i].split(" ");

			// 차량번호가 있다면
			if (map.containsKey(infos[1])) {
				String[] inTime = map.remove(infos[1]).split(":"); // 입차시간
				String[] outTime = infos[0].split(":"); // 출차시간

				int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
				int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);

				parkFee.replace(infos[1], parkFee.get(infos[1]) + 60 * hour + minute); // 이전 시간이랑 합치기

			} else
				map.put(infos[1], infos[0]); // 차 번호, 시간
		}

		// map에 남아있다면 출차내역 없는 차량 => 출차처리(23:59에 출차한 것으로 간주)
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
			// 누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구(초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림)
			if (parkFee.get(key) > fees[0])
				answer[idx++] = fees[1] + (int) Math.ceil((parkFee.get(key) - fees[0]) / (double) fees[2]) * fees[3]; // Math.ceil할 때 정수형으로 나누면 소숫점이 버려지기때문에 올림이 안됨 => 실수형으로 나누기!
			// 누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구
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
