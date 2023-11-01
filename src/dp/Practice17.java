package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice17 {
	// 1,2,3 더하기 2(백준 12101)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		
		for(int i=0; i<=n+2; i++) { // n이 3보다 작을 수 있기 때문에 미리 3까지의 합을 세팅하기 위해 +2까지 list 초기화
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
		
		// k번째 오는 식이 없는 경우에는 -1을 출력
		if(list.get(n).size() < k)
			System.out.println(-1);
		else { // n을 1, 2, 3의 합으로 나타내는 방법 중에서 사전 순으로 k번째에 오는 것을 출력
			Collections.sort(list.get(n));
			System.out.println(list.get(n).get(k-1));
		}
					
	} // end of main
} // end of class
