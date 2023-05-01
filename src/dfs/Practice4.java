package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice4 {
	// 음료수 얼려 먹기
	static int n, m;
	static int[][] graph;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine(); 
			for (int j = 0; j < m; j++) 
				graph[i][j] = str.charAt(j) - '0';
		}
		
		// 모든 노드(위치)에 대하여 음료수 채우기
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 현재 위치에서 DFS 수행
				// true인 경우에 아이스크림 갯수 추가
				if(dfs(i, j))
					result++;
			}
		}
		System.out.println(result);
	}	// end of main

	// DFS 함수 정의
	static boolean dfs(int x, int y) {
		// 주어진 범위를 벗어나는 경우에는 즉시 종료
		if(x < 0 || x >= n || y < 0 || y >= m) return false;
			
		// 현재 노드를 아직 방문하지 않았다면
		if(graph[x][y] == 0) {
			// 해당 노드 방문 처리
			graph[x][y] = 1;
			
			// 상,하,좌,우의 위치들도 모두 재귀적으로 호출
			dfs(x-1, y);
			dfs(x+1, y);
			dfs(x, y+1);
			dfs(x, y-1);
			return true;
		}
		return false;
	}

}	// end of class
