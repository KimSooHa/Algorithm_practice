package implement;

import java.io.IOException;
import java.util.Scanner;

public class Practice24 {
	// 3���� ������(���α׷��ӽ� - �����ڵ� ç���� ����1)
	
	public static int solution(int n) {
        //10���� -> 3����
        String ternary = Integer.toString(n, 3);
        StringBuffer sb = new StringBuffer(ternary);
        // �յڷ� ������
        ternary = sb.reverse().toString();
        // ������ ���� �ٽ� 10�������� ��ȯ
        return Integer.parseInt(ternary, 3);
    }	
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));	
	}	// end of main

}	// end of class