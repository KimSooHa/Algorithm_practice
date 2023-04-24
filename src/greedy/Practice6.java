package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice6 {
	// 만들 수 없는 금액
	
	public static int n;
	public static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) 
			list.add(sc.nextInt());
		
		Collections.sort(list);
		
		int target = 1; //n의 범위 1 <= n <= 1000
		for (int i = 0; i < n; i++) {
			if(target < list.get(i)) break;
			
			target += list.get(i);
		}
		
		System.out.println(target);
	}	// end of main

}	// end of class
