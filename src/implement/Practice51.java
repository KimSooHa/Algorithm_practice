package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice51 {
	// 가로 세로 퍼즐(백준 2784)
	
	// 0행, 1행, 2행, 0열, 1열, 2열
	static List<String> arr = new ArrayList<>(6); // 문자열 저장
	static boolean[] isSelected = new boolean[6]; // 방문 기록
	static List<List<String>> list = new ArrayList<>(); // 최종 퍼즐 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 6; i++) 
			arr.add(br.readLine());
		
		Collections.sort(arr);
		
		select(new int[3], 0);
		
		if(list.isEmpty())
			sb.append(0);
		else {
			for (int i = 0; i < 3; i++) {
				sb.append(list.get(0).get(i)).append("\n");
			}
		}
		
		System.out.println(sb);
	} // end of main

	private static void select(int[] ans, int idx) {
		
		if(idx == 3) {
			// 3개 다 뽑은 경우
			List<String> temp = new ArrayList<>(3);
			List<String> copy = new ArrayList<>(6);
			copy.addAll(arr);
			
			// 뽑은 3개 단어 넣기
			for (int i = 0; i < 3; i++) {
				temp.add(arr.get(ans[i]));
				copy.remove(arr.get(ans[i]));
			}
			
			// 퍼즐이 성립하는지 비교
			for (int i = 0; i < 3; i++) {
				String tempStr = "" +
						temp.get(0).charAt(i) +
						temp.get(1).charAt(i) +
						temp.get(2).charAt(i);
				
				if(copy.contains(tempStr)) copy.remove(tempStr);
				else return;
			}
			list.add(temp);
			return;
		}
		
		for (int i = 0; i < arr.size(); i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			ans[idx] = i;
			select(ans, idx+1);
			isSelected[i] = false;
		}
		
	}

} // end of class
