package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Practice10 {
	// 숨바꼭질(백준 1697)
	// 수빈이의 위치를 배열의 인덱스로 정하고 시간을 이동할 때마다 적기

	static int n, k; // 수빈이 위치, 동생 위치
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
				return visited[n]-1; // 0초를 1로 표시했기 때문에 마지막에 시간을 구할 때는 값에서 -1하기
			// 배열이 0인지 아닌지로 방문 여부 파악(방문했다면 값 변경하지 않음)
			// 각 이동 및 순간이동 가능한 위치이면서 방문하지 않았다면 현재 위치의 시간+1 갱신 
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
