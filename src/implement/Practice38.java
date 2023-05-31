package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Practice38 {
	// 개미(백준 3048)
	
	static StringTokenizer st;
	static int n1, n2; // 각 그룹의 개미 수
	static char[] g1; // 첫번째 그룹
	static char[] g2; // 두번째 그룹
	static boolean[] left; // 각 개미의 움직이는 방향
	static int t;

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n1 = Integer.parseInt(st.nextToken());
		n2 = Integer.parseInt(st.nextToken());
		
		g1 = new char[n1];
		g2 = new char[n2];
		left = new boolean[n1+n2];
		
		String str = br.readLine();
		for (int i = 0; i < n1; i++) {
			g1[i] = str.charAt(i);
			left[i] = true;
		}
			
		str = br.readLine();
		
		for (int i = 0; i < n2; i++) 
			g2[i] = str.charAt(i);
			
		t = Integer.parseInt(br.readLine());
		
		char[] order = new char[n1+n2];
		for (int i = 0; i < n1; i++) 
			order[i] = g1[n1-1-i];
		
		for (int i = 0; i < n2; i++) 
			order[n1+i] = g2[i];
		
		for(int i=0; i<t; i++) {
			
			for (int j = 0; j < order.length; j++) {
				if(j != 0 && left[j] == false && left[j-1] == true) {
					// 순서 변경해주기
					char temp = order[j];
					order[j] = order[j-1];
					order[j-1] = temp;
					// 방향 변경해주기
					boolean tmp = left[j];
					left[j] = left[j-1];
					left[j-1] = tmp;
					j++; // 스왑한 인덱스는 건너뛰기
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < order.length; i++) 
			sb.append(order[i]);
			
		System.out.println(sb);
	}

	
}	// end of class