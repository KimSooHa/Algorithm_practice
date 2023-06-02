package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice6 {
	// 물통(백준 2251)

	static class AB {
		int a;
		int b;
		
		public AB(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}


	static boolean[][] visited;
	static StringTokenizer st;
	static int[] sender = {0,0,1,1,2,2};
	static int[] receiver = {1,2,0,2,0,1};
	static boolean[] answer;
	static int[] now = new int[3];
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		now[0] = Integer.parseInt(st.nextToken());
		now[1] = Integer.parseInt(st.nextToken());
		now[2] = Integer.parseInt(st.nextToken());
		
		visited = new boolean[201][201];
		answer = new boolean[201];
		bfs();
		
		for (int i = 0; i < answer.length; i++) 
			if(answer[i]) System.out.print(i + " ");
		

	}	// end of main


	public static void bfs() {
		Queue<AB> q = new LinkedList<>();
		q.add(new AB(0, 0));
		visited[0][0] = true;
		answer[now[2]] = true;
		
		while(!q.isEmpty()) {
			AB p = q.poll();
			int a = p.a;
			int b = p.b;
			int c = now[2] - a - b;
			
			for (int i = 0; i < 6; i++) {
				int[] next = {a,b,c}; // 다음 노드
				next[receiver[i]] += next[sender[i]]; // 보내는 물통의 모든 용량을 받는 물통에 저장
				next[sender[i]] = 0;
				// 받는 물통이 넘칠 경우
				if(next[receiver[i]] > now[receiver[i]]) {
					next[sender[i]] = next[receiver[i]] - now[receiver[i]]; // 초과하는 값만큼 보내는 물통에 남기기
					next[receiver[i]] = now[receiver[i]]; // 받는 용량으로 넘치치 않게 채우기
				} // A,B,C 무게가 동일한 노드에 방문한 이력이 없다면 방문처리 및 큐에 추가
				if(!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					q.add(new AB(next[0], next[1]));
					if(next[0] == 0) // 1번째 물통의 무게가 0일 때 3번째 물통의 값을 정답 배열에 추가
						answer[next[2]] = true;
				}
			}
		}
	}


}	// end of class
