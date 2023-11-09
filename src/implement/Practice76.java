package implement;

public class Practice76 {
	// 방문 길이(프로그래머스 lv2 - Summer/Winter Coding(~2018))

	static int n = 11, m = 11;
    // 그냥 3차원 배열 선언해서 to -> from 각각 다른 방향으로 true 표시해주기
    public static int solution(String dirs) {
        int answer = 0;
        boolean[][][] isVisited = new boolean[n][m][4];

        // 상, 우, 좌, 하(3에서 현재 방향 빼면 다음 위치에서 반대방향에서 온 적이 있는지 확인가능하도록 방향 설정)
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        
        int x = 5, y = 5;
        
        for(int i=0; i<dirs.length(); i++) {
            int dir = 0;
            if(dirs.charAt(i) == 'U') dir = 0;
             else if(dirs.charAt(i) == 'R') dir = 1;
             else if(dirs.charAt(i) == 'L') dir = 2;
             else if(dirs.charAt(i) == 'D') dir = 3;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(!isPossibleToMove(nx, ny)) continue;
            
            // 이 방향으로 들어온 적이 없다면(현재 위치에서 가는 방향, 다음 위치에서 올 반대방향 두개 다 확인)
            if(!isVisited[nx][ny][3-dir] && !isVisited[x][y][dir]) {
                answer++;
                isVisited[x][y][dir] = true;
                isVisited[nx][ny][3-dir] = true;
            }
            x = nx;
            y = ny;
        }
        
        return answer;
    }
    
    private static boolean isPossibleToMove(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

	public static void main(String[] args) {
		
		// ex1
		String dirs = "ULURRDLLU";
		System.out.println(solution(dirs));
		
		// ex2
		dirs = "LULLLLLLU";
		System.out.println(solution(dirs));
		
	} // end of main
} // end of class
