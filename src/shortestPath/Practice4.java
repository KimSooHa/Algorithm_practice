package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Practice4 {
	// ��Ȯ�� ����(�÷��̵� ����)
	
	// �л� ��(n), �� �л��� ������ ���� Ƚ��(m)
	public static int n, m;
	public static StringTokenizer st;
	
	public static final int INF = (int) 1e9;	// ���Ѵ� �ǹ�(10��)
		
	
	// 2���� �迭�� ����� => �л��� ���� �ִ� 501���� ����
	public static int[][] graph = new int[501][501];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	// �л� ��(node)
		m = Integer.parseInt(st.nextToken());	// �� �л��� ������ ���� Ƚ��
		
		// �׷��� �ʱ�ȭ(�л��� ������ŭ ����Ʈ �����α�)
		for(int i=0; i<graph.length; i++) 
			Arrays.fill(graph[i], INF);
		
		for(int a=1; a<=n; a++)
			for(int b=1; b<=n; b++)
				if(a == b)
					graph[a][b] = 0;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
		}
		
		for(int k=1; k<=n; k++)
			for(int a=0; a<=n; a++)
				for(int b=0; b<=n; b++)
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
			
		int result = 0;
		
		// �� �л��� ��ȣ�� ���� �� �� Ȯ���ϸ� ���� �������� üũ
		for(int a=1; a<=n; a++) {
			int cnt = 0;
			
			for(int b=1; b<=n; b++) {
				if(graph[a][b] != INF || graph[b][a] != INF)	// a->b Ȥ�� b->a �� ���ް���(a�� b�� �����񱳰���)�ϸ� Ƚ�� ����
					cnt++;
			}
			
			// ���� ������ ��Ȯ�� �� �� �ִ� �л��̸�(�л��� ��� �л��� ���� �����ϸ�) result �� ���� 
			if(cnt == n)
				result++;
		}
		
		System.out.println(result);
		
	}	// end of main	

}	// end of class
