package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice10 {
	// 스타트와 링크(백준 14889)
	static int n;
	static int[][] s;
	static boolean[] visit;
	static StringTokenizer st;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		visit = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		back(0, 0);
		System.out.println(min);
		
		
	}	// end of main

	public static void back(int idx, int depth) {
		// 팀 조합이 완성된 경우 최솟값 찾는 함수 실행
		if(depth == n/2) {
			diff();
			return;
		}
		// 팀조합 만들기(한 팀의 인원수는 n/2)
		for (int i = idx; i < n; i++) { // 순열이 아닌 조합일 땐 idx로 가지치기 수행하여 시간 절약
			if(!visit[i]) {
				visit[i] = true;
				back(i+1, depth+1);
				visit[i] = false; // 재귀가 끝나면 비방문으로 변경
			}
		}
	}

	// 팀 당 능력치의 합을 구해서 최솟값 찾기
	public static void diff() {
		int start = 0;
		int link = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if(visit[i] == true && visit[j] == true) {
					start += s[i][j];
					start += s[j][i];
				} else if(visit[i] == false && visit[j] == false) {
					link += s[i][j];
					link += s[j][i];
				}
			}
		}
		
		int val = Math.abs(start - link);
		min = Math.min(min, val);
	}

}	// end of class
