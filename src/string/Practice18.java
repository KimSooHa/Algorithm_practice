package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice18 {
	// 튜플 (프로그래머스 2019 카카오 개발자 겨울 인턴쉽(lv2))

	public static int[] solution(String s) {

		ArrayList<ArrayList<Integer>> list = parseString(s);

		Collections.sort(list, (a, b) -> Integer.compare(a.size(), b.size()));
		List<Integer> li = new ArrayList<>();

		for (List<Integer> lis : list) {
			for (int i : lis)
				if (!li.contains(i))
					li.add(i);
		}

		int[] answer = {};
		answer = li.stream().mapToInt(i -> i).toArray();
		return answer;
	}

	public static ArrayList<ArrayList<Integer>> parseString(String s) {
		String[] str = s.substring(2, s.length() - 2).split("\\},\\{");

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i < str.length; i++) {
			ArrayList<Integer> li = new ArrayList<>();

			if (str[i].length() != 1) {
				String[] sp = str[i].split(",");
				for (String j : sp)
					li.add(Integer.parseInt(j));
			} else
				li.add(Integer.parseInt(str[i]));

			list.add(li);
		}
		return list;
	}


// =========================

	// 다른 사람 풀이
	// 1.
//		public int[] solution(String s) {
//	  Set<String> set = new HashSet<>();
//	  String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
//	  Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
//	  int[] answer = new int[arr.length];
//	  int idx = 0;
//	  for(String s1 : arr) {
//	      for(String s2 : s1.split(",")) {
//	          if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
//	      }
//	  }
//	  return answer;
//	}

// ---------------------------
	// 2.
//	public int[] solution(String s) {
//
//        Map<String, Integer> map = new HashMap<>();
//        Pattern pattern = Pattern.compile("[0-9]+");
//        Matcher matcher = pattern.matcher(s);
//        while (matcher.find()) {
//            String n = matcher.group();
//            map.put(n, map.getOrDefault(n, 0) + 1);
//        }
//        int size = map.size();
//        int[] answer = new int[size];
//        for (String key: map.keySet()) {
//            answer[size - map.get(key)] = Integer.parseInt(key);
//        }
//        return answer;
//    }

	public static void main(String[] args) {

		// ex1
		String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] result1 = solution(s1);

		for (int i = 0; i < result1.length; i++)
			System.out.println(result1[i]);

		System.out.println("----------------------");
		// ex2
		String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		int[] result2 = solution(s2);
		for (int i = 0; i < result2.length; i++) 
			System.out.println(result2[i]);
		
		System.out.println("----------------------");
		// ex3
		String s3 = "{{20,111},{111}}";
		int[] result3 = solution(s3);
		for (int i = 0; i < result3.length; i++) 
			System.out.println(result3[i]);
		
	}
}