package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice1 {
	// 연산자 끼워 넣기(백준 14888)
	
	// 수의 개수
	public static int n;
	
	// 연산을 수행하고자 하는 수 리스트
	public static ArrayList<Integer> arr = new ArrayList<>();
	
	// 더하기, 빼기, 곱하기, 나누기 연산자 개수
	public static int add, sub, mul, div;
	
	// 최솟값, 최대값 초기화(-10억 ~ 10억)
	public static int minValue = (int) 1e9;
	public static int maxValue = (int) -1e9;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 수의 개수 입력받기
		n = sc.nextInt();
		
		// 수열 입력받기
		for(int i=0; i<n; i++)
			arr.add(sc.nextInt());
		
		// 연산자 개수 입력받기
		add = sc.nextInt();
		sub = sc.nextInt();
		mul = sc.nextInt();
		div = sc.nextInt();
		
		// DFS 메서드 호출
		dfs(1, arr.get(0));
		
		System.out.println(maxValue);
		System.out.println(minValue);
		
	}

	public static void dfs(int i, int now) {
		
		// 모든 연산자를 다 사용한 경우, 최솟값과 최댓값 업데이트
		if(i == n) {
			maxValue = Math.max(maxValue, now);
			minValue = Math.min(minValue, now);
		} 
		// 수열을 다 돌지 않은 경우 남은 연산자로 식 만들기
		else {	
			// 각 연산자에 대해서 재귀적으로 수행
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
