package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice19 {
	// 상하좌우
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] plans = br.readLine().split(" ");
		int x = 1, y = 1;
		
		// L, R, U ,D에 따른 이동방향
		int dx[] = {0, 0, -1, 1};
		int dy[] = {-1, 1, 0, 0};
		
		char[] moveTypes = {'L', 'R', 'U', 'D'};
		
		// 이동 계획을 하나씩 확인
		for (int i = 0; i < plans.length; i++) {
			char plan = plans[i].charAt(0);
			
			// 이동 후 좌표 구하기
			int nx = 0, ny = 0;
			
			// 4방향 중에 입력방향에 해당하는 방향과 같은 값만큼 현재 좌표에서 이동하기
			for (int j = 0; j < 4; j++) {
				if(plan == moveTypes[j]) {
					nx = x + dx[j];
					ny = y + dy[j];
				}
			}
			
			// 공간을 벗어나는 경우 무시
			if(nx < 1 || ny < 1 || nx > n || ny > n) continue;
				
			x = nx;
			y = ny;
		}
		
		System.out.println(x + " " + y);
	}	// end of main
}	// end of class