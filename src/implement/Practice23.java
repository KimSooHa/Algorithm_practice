package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Practice23 {
	// 게임 개발
	static int n, m, x, y, d;
	static StringTokenizer st;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		// 맵의 크기 입력받기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		// 현재 캐릭터의 위치
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		// 현재 캐릭터의 방향(direction)
		d = Integer.parseInt(st.nextToken());

		// 북, 동, 남, 서 방향 정의
		int[] dx = {-1, 0, 1, 0};	// 북쪽기준
		int[] dy = {0, 1, 0, -1};	// 서쪽기준
		
		// 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
		int xy[][] = new int[n][m];
		// 전체 맵 정보
		int[][] arr = new int [n][m];
		xy[x][y] = 1;	// 현재 위치한 좌표 방문 처리
		
		// 게임 맵 채우기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());	
		}
		// 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
		int cnt = 1;// 방문수
		int turnTime = 0;	// 회전횟수
		
		while(true) {
			// 왼쪽으로 회전
			turnLeft();
			// 현재위치에서 이동방향으로 이동하기
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
			if(xy[nx][ny] == 0 && arr[nx][ny] == 0) {
				xy[nx][ny] = 1;
				x = nx;
				y = ny;
				cnt++;
				turnTime = 0;
				continue;
			}
			// 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
			else
				turnTime++;
			// 네 방향 모두 갈 수 없는 경우
			if(turnTime == 4) {
				nx = x - dx[d];
				ny = y - dy[d];
				// 뒤로 갈 수 있다면 이동
				if(arr[nx][ny] == 0) {
					x = nx;
					y= ny;					
				} else break;	// 뒤가 바다로 막혀있는 경우 
				
				turnTime = 0;
			}
		}
		
		System.out.println(cnt);
		
	}	// end of main

	public static void turnLeft() {
		// 1씩 빼주면서 북,서,남,동 방향, 즉 왼쪽 방향 반시계 방향 90도 회전시키기
		d -= 1;
		if(d == -1)	// 븍쪽에서 회전일 때는 서쪽으로 대입
			d = 3;
	}
}	// end of class