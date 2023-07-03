package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice7 {
	// 바이러스(백준 2606)
	static int n, m; // 컴퓨터의 수, 컴퓨터 쌍의 수
	static int[][] parent;
	static boolean[] visit;
	static int answer = 0; 
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		visit = new boolean[n+1];
		parent = new int[n+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			parent[a][b] = 1;
			parent[b][a] = 1;
		}
		
		dfs(1);
		
		System.out.println(answer);
		
	}	// end of main

	public static void dfs(int x) {
		
		visit[x] = true;
		
		for (int i = 1; i <= n; i++) {
			if(parent[x][i] == 1 && visit[i] == false) {
				answer++;
				dfs(i);
			}
		}
	}
	
}	// end of class
