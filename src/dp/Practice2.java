package dp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice2 {
	// ������ ��
	
	public static int n;	// n��° ������ ��
	public static int[] ugly = new int[1000];	// ���̳��� ���α׷����� ���� DP ���̺� �ʱ�ȭ
		

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		
		// 2��, 3��, 5�踦 ���� �ε���
		int i2 = 0, i3 = 0, i5 = 0;
		
		// ó���� ���� ���� �ʱ�ȭ
		int next2 = 2, next3 = 3, next5 = 5;
		
		
		ugly[0] = 1;	// ù��° ������ ���� 1
		
		
		// 1���� n������ ������ ������ ã��
		for(int j=1; j<n; j++) {
			// ������ ���� ��� �߿��� ���� ���� ���� ����
			ugly[j] = Math.min(next2, Math.min(next3, next5));	
			
			// �ε����� ���� ���� ����� ����
			if(ugly[j] == next2) {	// j��° ���� 2������
				i2++;	
				next2 = ugly[i2]*2;	// ���� �ε����� ���� 2 ���ϱ�
			}
			if(ugly[j] == next3) {	// j��° ���� 3������
				i3++;	
				next3 = ugly[i3]*3;	// ���� �ε����� ���� 3 ���ϱ�	
			}
			if(ugly[j] == next5) {	// j��° ���� 5������
				i5++;	
				next5 = ugly[i5]*5;	// ���� �ε����� ���� 5 ���ϱ�	
			}
		}
		
		
		
		// n��° ������ �� ��� ���
		System.out.println(ugly[n-1]);


	}	// end of main

}	// end of class
