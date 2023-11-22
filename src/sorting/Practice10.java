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
	// ���ܾ� �ϱ�� ���ο�(���� 20920)
	// �Ʒ��� �켱������ ���ʷ� �����Ͽ� �տ� ��ġ�Ͽ� ����
	// 1. ���� ������ �ܾ��ϼ���, 2. �ܾ� ���̰� �����, 3. ���ĺ� ���������� �տ� �ִ� �ܾ��ϼ���
	
	static int n, m; // �ܾ� ����(n), �ܿ�ܾ� ���� ����(m)
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
				// ���� ������ �ܾ������ �տ� ��ġ
				if(map.get(o2) != map.get(o1))
					return map.get(o2) - map.get(o1);
				// �ܾ� ���̰� ����� �տ� ��ġ
				else if(o1.length() != o2.length())
					return o2.length() - o1.length();
				else // ���ĺ� ���������� �տ� ��ġ
					return o1.compareTo(o2);	
			}
		});
		
		StringBuffer sb = new StringBuffer();
		
		for(String key : keySet) 
			sb.append(key).append("\n");
		
		System.out.println(sb);
	} // end of main
} // end of class
