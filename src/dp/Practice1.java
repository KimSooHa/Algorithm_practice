package dp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice1 {
	// ���� ��ġ�ϱ�(���� 18353) - �ǹ�2
	// ���� �� �����ϴ� �κ� ����(LDS) = ���� �� �����ϴ� �κ� ������ �ٲ㼭 Ǯ��!
	
	public static int n;	// ��ü ���� ��
	public static ArrayList<Integer> v = new ArrayList<>();
	public static int[] dp = new int[2000];	// ���̳��� ���α׷����� ���� DP ���̺� �ʱ�ȭ
		

public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			v.add(x);
		}
		
		// ������ ������ '���� ���� �κ� ����' ������ ��ȯ
		Collections.reverse(v);
		
		// ���̳��� ���α׷����� ���� 1���� DP ���̺� �ʱ�ȭ
		for(int i=0; i<n; i++)
			dp[i] = 1;
		
		// ���� �� �����ϴ� �κ� ����(LIS) �˰��� ����
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(v.get(j) < v.get(i))
					dp[i] = Math.max(dp[i], dp[j] + 1);	// ���� ������ ���� ���� �۴ٸ� �����ϰ� �ִ� ���̱� ������ ���� ���̺��� ���� �ִ밪���� 1�� �����ؼ� ����
			}
		}
		
		// �����ؾ� �ϴ� ������ �ּ� ���� ���
		int maxValue = 0;
		for(int i=0; i<n; i++) {
			maxValue = Math.max(maxValue, dp[i]);	// �����ִ� ������ �ִ� ��
		}
		
		
		// ���� ��� ���
		System.out.println(n - maxValue);	// ���ܽ��Ѿ� �� ���� ���̱� ������ ���� ���� �� - �����ִ� �ִ� �����


	}	// end of main

}	// end of class
