package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Practice38 {
	// ����(���� 3048)
	
	static StringTokenizer st;
	static int n1, n2; // �� �׷��� ���� ��
	static char[] g1; // ù��° �׷�
	static char[] g2; // �ι�° �׷�
	static boolean[] left; // �� ������ �����̴� ����
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
					// ���� �������ֱ�
					char temp = order[j];
					order[j] = order[j-1];
					order[j-1] = temp;
					// ���� �������ֱ�
					boolean tmp = left[j];
					left[j] = left[j-1];
					left[j-1] = tmp;
					j++; // ������ �ε����� �ǳʶٱ�
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < order.length; i++) 
			sb.append(order[i]);
			
		System.out.println(sb);
	}

	
}	// end of class