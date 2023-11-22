package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Practice10 {
	// 영단어 암기는 괴로워(백준 20920)
	// 아래의 우선순위로 차례로 적용하여 앞에 배치하여 정렬
	// 1. 자주 나오는 단어일수록, 2. 단어 길이가 길수록, 3. 알파벳 사전순으로 앞에 있는 단어일수록
	
	static int n, m; // 단어 개수(n), 외울단어 길이 기준(m)
	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			if(word.length() >= m) 
				map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		ArrayList<String> keySet = new ArrayList<>(map.keySet());
		
		keySet.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 자주 나오는 단어순으로 앞에 배치
				if(map.get(o2) != map.get(o1))
					return map.get(o2) - map.get(o1);
				// 단어 길이가 길수록 앞에 배치
				else if(o1.length() != o2.length())
					return o2.length() - o1.length();
				else // 알파벳 사전순으로 앞에 배치
					return o1.compareTo(o2);	
			}
		});
		
		StringBuffer sb = new StringBuffer();
		
		for(String key : keySet) 
			sb.append(key).append("\n");
		
		System.out.println(sb);
	} // end of main
} // end of class
