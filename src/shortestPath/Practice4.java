package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Practice4 {
	// 정확한 순위(플로이드 워셜)
	
	// 학생 수(n), 두 학생의 성적을 비교한 횟수(m)
	public static int n, m;
	public static StringTokenizer st;
	
	public static final int INF = (int) 1e9;	// 무한대 의미(10억)
		
	
	// 2차원 배열을 만들기 => 학생의 수는 최대 501개로 지정
	public static int[][] graph = new int[501][501];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	// 학생 수(node)
		m = Integer.parseInt(st.nextToken());	// 두 학생의 성적을 비교한 횟수
		
		// 그래프 초기화(학생의 개수만큼 리스트 만들어두기)
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
		
		// 각 학생을 번호에 따라 한 명씩 확인하며 도달 가능한지 체크
		for(int a=1; a<=n; a++) {
			int cnt = 0;
			
			for(int b=1; b<=n; b++) {
				if(graph[a][b] != INF || graph[b][a] != INF)	// a->b 혹은 b->a 가 도달가능(a와 b의 성적비교가능)하면 횟수 증가
					cnt++;
			}
			
			// 성적 순위를 정확히 알 수 있는 학생이면(학생이 모든 학생에 도달 가능하면) result 값 증가 
			if(cnt == n)
				result++;
		}
		
		System.out.println(result);
		
	}	// end of main	

}	// end of class
