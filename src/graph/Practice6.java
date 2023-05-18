package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice6 {
	// ��� ã��(���� 11403)
	//�÷��̵� ���� ����
	static int n; // ����� ��(n)
	static int[][] graph = new int[101][101];
	static int[][] answer; 
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for (int j = 0; j < n; j++) {
					if(graph[i][k] == 1 && graph[k][j] == 1) // i���� k��, k���� j�� ���� ��ΰ� �ִٸ� 1
						graph[i][j] = 1;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(graph[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}	// end of main
	
}	// end of class
