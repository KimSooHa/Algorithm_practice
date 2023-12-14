package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Practice12 {
	// 숫자 고르기(백준 2668)
	/*
	 * 2 -> 1 <-> 3 // 5<->5 <- 4 <- 6 <- 7
	 * 아래 3가지가 사이클이 된다
	 * 1 -> 3 -> 1
	 * 3 -> 1 -> 3
	 * 5 -> 5
	 */
	
	static int n; // 칸의 수(n)
	static boolean[] isVisited; // 방문 처리
	static int[] arr;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		n = Integer.parseInt(br.readLine());
		
		isVisited = new boolean[n+1];
		arr = new int[n+1];
		
		for(int i=1; i<n+1; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < n+1; i++) {
			isVisited[i] = true;
			dfs(i, i);
			isVisited[i] = false;
		} 
		
		System.out.println(list.size());
		Collections.sort(list);
		for(int li : list)
			System.out.println(li);
		
	} // end of main

	public static void dfs(int start, int target) {
		if(!isVisited[arr[start]]) {
			isVisited[arr[start]] = true;
			dfs(arr[start], target);
			isVisited[arr[start]] = false;
		}
		
		// 사이클이 발생(출발 숫자 만나는 경우)했다면 마지막 수를 넣어줌
		if(arr[start] == target)
			list.add(target);
	}

} // end of class
