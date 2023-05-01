package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice4 {
	// ����� ��� �Ա�
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
		
		// ��� ���(��ġ)�� ���Ͽ� ����� ä���
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// ���� ��ġ���� DFS ����
				// true�� ��쿡 ���̽�ũ�� ���� �߰�
				if(dfs(i, j))
					result++;
			}
		}
		System.out.println(result);
	}	// end of main

	// DFS �Լ� ����
	static boolean dfs(int x, int y) {
		// �־��� ������ ����� ��쿡�� ��� ����
		if(x < 0 || x >= n || y < 0 || y >= m) return false;
			
		// ���� ��带 ���� �湮���� �ʾҴٸ�
		if(graph[x][y] == 0) {
			// �ش� ��� �湮 ó��
			graph[x][y] = 1;
			
			// ��,��,��,���� ��ġ�鵵 ��� ��������� ȣ��
			dfs(x-1, y);
			dfs(x+1, y);
			dfs(x, y+1);
			dfs(x, y-1);
			return true;
		}
		return false;
	}

}	// end of class
