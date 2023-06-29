package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Practice10 {
	// ���ٲ���(���� 1697)
	// �������� ��ġ�� �迭�� �ε����� ���ϰ� �ð��� �̵��� ������ ����

	static int n, k; // ������ ��ġ, ���� ��ġ
	static int[] visited = new int[100001];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int time = bfs(n);
	
		
		System.out.println(time);
	}	// end of main
	
	public static int bfs(int node) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(node);
		
		int index = node;
		int n = 0;
		visited[index] = 1;
		while(!q.isEmpty()) {
			n = q.poll();
			
			if(n == k)
				return visited[n]-1; // 0�ʸ� 1�� ǥ���߱� ������ �������� �ð��� ���� ���� ������ -1�ϱ�
			// �迭�� 0���� �ƴ����� �湮 ���� �ľ�(�湮�ߴٸ� �� �������� ����)
			// �� �̵� �� �����̵� ������ ��ġ�̸鼭 �湮���� �ʾҴٸ� ���� ��ġ�� �ð�+1 ���� 
			if(n-1 >= 0 && visited[n-1] == 0) {
				visited[n-1] = visited[n]+1;
				q.add(n-1);
			}
			if(n+1 <= 100000 && visited[n+1] == 0) {
				visited[n+1] = visited[n]+1;
				q.add(n+1);
			}
			if(n*2 <= 100000 && visited[n*2] == 0) {
				visited[n*2] = visited[n]+1;
				q.add(n*2);
			}
		}
		return -1;
	}
	
}	// end of class
