package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice11 {
	// �̼����(���� 2644)
	
	// ��ü ����� ��(n), ���� �ٸ� �� ����� ��ȣ(x, y), �θ� �ڽĵ� ���� ������ ����(m)
	static int n, m, x, y;
	static StringTokenizer st;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // �θ� �ڽİ��� ����(�θ�,�ڽ�)
	static int answer = -1; // �� ���(x,y)�� �̼�
	
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
		// start�� end�� ������ �� ����� �̼��� ����� �Ǿ��� ������ ����
		if(start == end) {
			answer = cnt;
			return;
		}
		
		visited[start] = true; // ����� �̼��� �湮ó��
		
		for (int i = 0; i < list.get(start).size(); i++) {
			int next = list.get(start).get(i);
			if(!visited[next])
				dfs(next, end, cnt+1);
		}
	}

} // end of class
