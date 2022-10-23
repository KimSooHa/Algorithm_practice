package shortestPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Practice2 {
	// 플로이드(백준 11404)
	
		// 도시의 갯수(n), 버스의 갯수(m)
		public static int n, m;
		public static StringTokenizer st;
		
		public static final int INF = (int) 1e9;	// 무한대 의미(10억)
			
		
		// 2차원 배열(그래프 표현)을 만들기 => 노드(도시)의 개수는 최대 101개(0~100)로 지정
		public static int[][] graph = new int[101][101];

		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			n = Integer.parseInt(br.readLine());	// 도시 갯수(node)
			m = Integer.parseInt(br.readLine());	// 버스 갯수(edge)
			
			// 최단 거리 테이블을 모두 무한으로 초기화(도시의 개수만큼 최댓값으로 채우기)
			for(int i=0; i<=n; i++) 
				Arrays.fill(graph[i], INF);
			
			// 자기 자신에서 자기 자신으로 가능 비용은 0으로 초기화
			for(int a=1; a<=n; a++)
				for(int b=1; b<=n; b++)
					if(a==b)
						graph[a][b] = 0;
			
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if(graph[a][b] > c)	// a에서 b로 가는데 필요한 비용이 c보다 크면
					graph[a][b] = c;	// c로 대입
			}
			
			// a에서 b로 가는 경로가 k를 거쳐서 가는 경우의 비용과 비교해서 더 작은 비용으로 갱신
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
