package implement;

public class Practice76 {
	// �湮 ����(���α׷��ӽ� lv2 - Summer/Winter Coding(~2018))

	static int n = 11, m = 11;
    // �׳� 3���� �迭 �����ؼ� to -> from ���� �ٸ� �������� true ǥ�����ֱ�
    public static int solution(String dirs) {
        int answer = 0;
        boolean[][][] isVisited = new boolean[n][m][4];

        // ��, ��, ��, ��(3���� ���� ���� ���� ���� ��ġ���� �ݴ���⿡�� �� ���� �ִ��� Ȯ�ΰ����ϵ��� ���� ����)
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
            
            // �� �������� ���� ���� ���ٸ�(���� ��ġ���� ���� ����, ���� ��ġ���� �� �ݴ���� �ΰ� �� Ȯ��)
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
