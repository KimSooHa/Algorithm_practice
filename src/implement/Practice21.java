package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice21 {
	// 왕실의 나이트
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pos = br.readLine();
		int col = pos.charAt(0) - 'a' + 1;	// 문자를 숫자(1부터 시작)로 변경
		int row = pos.charAt(1) - '0';	// 문자를 숫자로 변경
		
		//나이트가 이동할 수 있는 8가지 방향 정의
		int[] dx = {-2, -1, 1, 2, 1, 2, -1, -2};
		int[] dy = {-1, -2, -2, -1, 2, 1, 2, 1};
		
		int cnt = 0;
		// 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
		for (int i = 0; i < 8; i++) {
			// 현재 입력값에서 각 경우의 수를 더한 값
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];
			// 더한 값이 8x8 범위에서 벗어나는지 확인
			if(nextRow < 1 || nextRow > 8 || nextCol < 1 || nextCol > 8) continue;
			
			cnt++;
		}
		System.out.println(cnt);
	}	// end of main
}	// end of class