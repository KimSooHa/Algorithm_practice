package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice51 {
	// ���� ���� ����(���� 2784)
	
	// 0��, 1��, 2��, 0��, 1��, 2��
	static List<String> arr = new ArrayList<>(6); // ���ڿ� ����
	static boolean[] isSelected = new boolean[6]; // �湮 ���
	static List<List<String>> list = new ArrayList<>(); // ���� ���� �迭

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
			// 3�� �� ���� ���
			List<String> temp = new ArrayList<>(3);
			List<String> copy = new ArrayList<>(6);
			copy.addAll(arr);
			
			// ���� 3�� �ܾ� �ֱ�
			for (int i = 0; i < 3; i++) {
				temp.add(arr.get(ans[i]));
				copy.remove(arr.get(ans[i]));
			}
			
			// ������ �����ϴ��� ��
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
