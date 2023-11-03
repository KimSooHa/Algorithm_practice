package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice74 {
	// ����(���� 14719)

	static int h, w; // ����(h), ����(w)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		int[] height = new int[w];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<w; i++) 
			height[i] = Integer.parseInt(st.nextToken());
		
		int total = 0;
		for(int i=1; i<w-1; i++) { // �ε��� �� ���̴� ����. ù, ������ �ε��� ����(ù, ������ ��Ͽ��� ������ ���� �� ����)
			int left = 0;
			int right = 0;
			
			for(int j=0; j<i; j++)
				left = Math.max(height[j], left); // ���� ���غ���� ���̺��� ���� ����� ���ʿ� �־�� �� 
			
			for(int j=i+1; j<w; j++)
				right = Math.max(height[j], right); // ���� ���غ���� ���̺��� ���� ����� �����ʿ� �־�� ��
			
			if(height[i] < left && height[i] < right) // ���� ����� �� ��Ϻ��� ������ Ȯ��(���ƾ� ���� ���� �� ����)
				total += Math.min(left, right) - height[i]; // �� �߿� �� ���� ����� �������� ���� ����� ������ ���� �� �ִ� ���� ���
		}
		
		System.out.println(total);

	} // end of main

} // end of class
