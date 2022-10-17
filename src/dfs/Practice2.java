package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice2 {
	// 연구소(백준 14502)
	
	// 지도의 세로 크기(n), 가로 크기(m)
	public static int n, m;
	public static int result = 0;
	
	public static StringTokenizer st;
	
	// 입력받은 배열 초기화
	public static int[][] arr = new int[8][8];
	// 앞의 인덱스에서 누적된 값 저장하기 위한 배열
	public static int[][] temp = new int[8][8];
	
	// 4가지 이동 방향에 대한 배열(북,동,남,서)
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());

		// 지도의 크기 입력받기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 2차원 배열의 맵 정보 입력받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
			
		dfs(0);

		// 결과값 출력
		System.out.println(result);
		
	}	// end of main

	// 깊이 우선 탐색을 이용해 울타리를 설치하면서, 매 번 안전 영역의 크기 계산
	public static void dfs(int count) {
		
		if(count == 3) {	// 벽을 3개 세웠으면
			
			// 누적된 값 새 배열에 저장
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) 
					temp[i][j] = arr[i][j];
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(temp[i][j] == 2)	// 바이러스가 있는 위치라면
						virus(i, j);	// 바이러스 퍼뜨리기
				}
			}
			
			// 안전 영역의 최댓값 계산
			result = Math.max(result, getCount());
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 0) {	// 빈칸이라면
					arr[i][j] = 1;	// 벽세우기
					count++;
					dfs(count);
					arr[i][j] = 0;	// 깊이우선탐색이 끝나면 울타리 빼기
					count--;	// 울타리 개수 줄이기
				}
			}
		}
			
		
		
	}

	// 0의 개수(안전 영역의 크기 계산)
	public static int getCount() {
		int score = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(temp[i][j] == 0)
					score++;
			}
		}
		
		return score;
	}

	// 바이러스 퍼뜨리기
	public static void virus(int x, int y) {
		
		// 바이러스 있는 기준으로 4방향 바이러스 퍼뜨리기
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 영역이 지도 범위안에 있을 때
			if(0<= nx && nx < n && 0 <= ny && ny < m) {	
				
				// 영역이 빈칸이라면
				if(temp[nx][ny] == 0) {
					temp[nx][ny] = 2;	// 바이러스 퍼뜨리기
					virus(nx, ny);
				}
			}
		}
		
	}
	


}	// end of class
