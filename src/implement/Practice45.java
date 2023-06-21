package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Practice45 {
	// 드래곤 커브(백준 15685)
	
	static int n; // 커브 갯수
	static int length = 101;
	static boolean[][] arr = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0}; // x축
    static int[] dy = {0, -1, 0, 1}; // y축
	static int cnt = 0;

	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// x, y:시작점, d:시작방향, g:세대
		// 1. 방향 구하기
		// 2. 꼭짓점 그리기
		// 3. 1x1인 정사각형 구하기
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 시작 방향
			int g = Integer.parseInt(st.nextToken()); // 세대
			
			draw(x, y, getDirections(d, g));
		}
		
		System.out.println(getNumberOfSquares());
				
	} // end of main

	
	public static int getNumberOfSquares() {
		int cnt = 0;
		
		 for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length-1; j++) {
                if (arr[i][j] && arr[i][j + 1] && arr[i + 1][j] && arr[i + 1][j + 1]) {
                    cnt++;
                }
            }
        }
		return cnt;
	}

	public static List<Integer> getDirections(int d, int g) {
		
		List<Integer> directions = new ArrayList<>();
		directions.add(d); // 시작 방향 추가
		// 이전 세대의 방향을 바탕으로 그림
		// 입력받은 세대의 커브 방향을 반시계 방향으로 리스트에 담기
		for(int i = 0; i < g; i++) {
			for (int j = directions.size()-1; j >= 0; j--) { // 마지막 방향 -> 처음방향까지 순서로 반복
				int dir = (directions.get(j) + 1) % 4; // (기존의 방향 + 1) % 4
				directions.add(dir); // 새로운 방향 추가
			}
		}
		
		return directions;
	}


    public static void draw(int x, int y, List<Integer> directions) {

        arr[x][y] = true;
        // 리스트의 방향으로 좌표에 그리기
        for (Integer direction : directions) {
            x += dx[direction];
            y += dy[direction];
            arr[x][y] = true;
        }
    }

}	// end of class