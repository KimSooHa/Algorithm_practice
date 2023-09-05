package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice11 {
	// 촌수계산(백준 2644)
	
	// 전체 사람의 수(n), 서로 다른 두 사람의 번호(x, y), 부모 자식들 간의 관계의 개수(m)
	static int n, m, x, y;
	static StringTokenizer st;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 부모 자식간의 관계(부모,자식)
	static int answer = -1; // 두 사람(x,y)의 촌수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		dfs(x, y, 0);
		System.out.println(answer);
		
	} // end of main

	public static void dfs(int start, int end, int cnt) {
		// start와 end가 같으면 두 사람의 촌수가 계산이 되었기 때문에 종료
		if(start == end) {
			answer = cnt;
			return;
		}
		
		visited[start] = true; // 계산한 촌수는 방문처리
		
		for (int i = 0; i < list.get(start).size(); i++) {
			int next = list.get(start).get(i);
			if(!visited[next])
				dfs(next, end, cnt+1);
		}
	}

} // end of class
