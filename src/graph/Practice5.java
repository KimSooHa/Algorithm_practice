package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice5 {
	// 상근이의 여행(백준 9372)
	
	static int t, n, m; // 노드의 수(n)와 비행기의 개수(m)
	static int[][] plane;
	static boolean[] visit;
	static StringTokenizer st;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			plane = new int[n+1][n+1];
			visit = new boolean[n+1];
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				plane[a][b] = 1;
				plane[b][a] = 1;
			}
			
			bfs();
			
			System.out.println(n-1);
		}		
	}	// end of main
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visit[1] = true;
		while(!q.isEmpty()) {
			result++;
			int value = q.poll();
			for (int i = 1; i <= n; i++) {
				if(plane[value][i] != 0 && !visit[i]) {
					visit[i] = true;
					q.offer(i);
				}
			}
		}
	}
	
}	// end of class
