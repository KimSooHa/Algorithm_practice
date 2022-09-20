package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice1 {
	// ������ ���� �ֱ�(���� 14888)
	
	// ���� ����
	public static int n;
	
	// ������ �����ϰ��� �ϴ� �� ����Ʈ
	public static ArrayList<Integer> arr = new ArrayList<>();
	
	// ���ϱ�, ����, ���ϱ�, ������ ������ ����
	public static int add, sub, mul, div;
	
	// �ּڰ�, �ִ밪 �ʱ�ȭ(-10�� ~ 10��)
	public static int minValue = (int) 1e9;
	public static int maxValue = (int) -1e9;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// ���� ���� �Է¹ޱ�
		n = sc.nextInt();
		
		// ���� �Է¹ޱ�
		for(int i=0; i<n; i++)
			arr.add(sc.nextInt());
		
		// ������ ���� �Է¹ޱ�
		add = sc.nextInt();
		sub = sc.nextInt();
		mul = sc.nextInt();
		div = sc.nextInt();
		
		// DFS �޼��� ȣ��
		dfs(1, arr.get(0));
		
		System.out.println(maxValue);
		System.out.println(minValue);
		
	}

	public static void dfs(int i, int now) {
		
		// ��� �����ڸ� �� ����� ���, �ּڰ��� �ִ� ������Ʈ
		if(i == n) {
			maxValue = Math.max(maxValue, now);
			minValue = Math.min(minValue, now);
		} 
		// ������ �� ���� ���� ��� ���� �����ڷ� �� �����
		else {	
			// �� �����ڿ� ���ؼ� ��������� ����
			if(add > 0) {	
				add -= 1;
				dfs(i+1, now + arr.get(i));
				add += 1;
			}
			if(sub > 0) {
				sub -= 1;
				dfs(i+1, now - arr.get(i));
				sub += 1;
			}
			if(mul > 0) {
				mul -= 1;
				dfs(i+1, now * arr.get(i));
				mul += 1;
			}
			if(div > 0) {
				div -= 1;
				dfs(i+1, now / arr.get(i));
				div += 1;
			}
			
		}
		
	}
	


}	// end of class
