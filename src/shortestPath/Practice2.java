package shortestPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Practice2 {
	// �÷��̵�(���� 11404)
	
		// ������ ����(n), ������ ����(m)
		public static int n, m;
		public static StringTokenizer st;
		
		public static final int INF = (int) 1e9;	// ���Ѵ� �ǹ�(10��)
			
		
		// 2���� �迭(�׷��� ǥ��)�� ����� => ���(����)�� ������ �ִ� 101��(0~100)�� ����
		public static int[][] graph = new int[101][101];

		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			n = Integer.parseInt(br.readLine());	// ���� ����(node)
			m = Integer.parseInt(br.readLine());	// ���� ����(edge)
			
			// �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ(������ ������ŭ �ִ����� ä���)
			for(int i=0; i<=n; i++) 
				Arrays.fill(graph[i], INF);
			
			// �ڱ� �ڽſ��� �ڱ� �ڽ����� ���� ����� 0���� �ʱ�ȭ
			for(int a=1; a<=n; a++)
				for(int b=1; b<=n; b++)
					if(a==b)
						graph[a][b] = 0;
			
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if(graph[a][b] > c)	// a���� b�� ���µ� �ʿ��� ����� c���� ũ��
					graph[a][b] = c;	// c�� ����
			}
			
			// a���� b�� ���� ��ΰ� k�� ���ļ� ���� ����� ���� ���ؼ� �� ���� ������� ����
			for(int k=1; k<=n; k++)
				for(int a=1; a<=n; a++)
					for(int b=1; b<=n; b++)
						graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			for(int a=1; a<=n; a++) {
				for(int b=1; b<=n; b++) {
					if(graph[a][b] == INF)
						bw.write(0 + " ");
					else
						bw.write(graph[a][b] + " ");
				}
				bw.flush();
				bw.newLine();
			}
			
			bw.close();
			
		}	// end of main

}	// end of class
