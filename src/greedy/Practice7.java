package greedy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Practice7 {
	// 볼링공 고르기
	
	public static int n, m;
	public static Set<Integer> list = new HashSet<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();	// 볼링공의 개수
		m = sc.nextInt();	// 공의 최대 무게
		int answer = 0;
		
		for (int i = 0; i < n; i++) 
			list.add(sc.nextInt());
		
		for (int i = 1; i < n; i++) {
			answer += i;
		}
		answer -= (n - list.size());
		System.out.println(answer);
	}	// end of main

}	// end of class
