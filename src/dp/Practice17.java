package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice17 {
	// 1,2,3 ���ϱ� 2(���� 12101)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		
		for(int i=0; i<=n+2; i++) { // n�� 3���� ���� �� �ֱ� ������ �̸� 3������ ���� �����ϱ� ���� +2���� list �ʱ�ȭ
			list.add(new ArrayList<>());
			System.out.println(list.size());
		}
		
		list.get(1).add("1");
		list.get(2).add("1+1");
		list.get(2).add("2");
		list.get(3).add("1+1+1");
		list.get(3).add("1+2");
		list.get(3).add("2+1");
		list.get(3).add("3");
		  
		for(int i=4; i<=n; i++) {
			for(int j=1; j<=3; j++) {
				for(String s : list.get(i-j))
					list.get(i).add(s + "+" + j);
			}
		}
		
		// k��° ���� ���� ���� ��쿡�� -1�� ���
		if(list.get(n).size() < k)
			System.out.println(-1);
		else { // n�� 1, 2, 3�� ������ ��Ÿ���� ��� �߿��� ���� ������ k��°�� ���� ���� ���
			Collections.sort(list.get(n));
			System.out.println(list.get(n).get(k-1));
		}
					
	} // end of main
} // end of class
