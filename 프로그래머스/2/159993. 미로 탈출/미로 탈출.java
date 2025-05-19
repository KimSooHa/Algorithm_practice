import java.util.*;
class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    
    static int max = Integer.MAX_VALUE;
    public int solution(String[] maps) {
        int answer = 0;
        // 시작, 레버, 출구 좌표 
        int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;
        
        map = new int[maps.length][maps[0].length()];
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                char c = maps[i].charAt(j);
                if(c == 'O') continue;
                if(c == 'X') map[i][j] = max;
                else if(c == 'S') {
                    sx = i;
                    sy = j;
                }
                else if(c == 'L') {
                    lx = i;
                    ly = j;
                } else if(c == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
        
        // 시작 -> 레버
        int moveLever = move(sx, sy, lx, ly);
        if(moveLever == max) return -1;
        answer += moveLever;
        
        // 레버 -> 출구 
        int moveExit = move(lx, ly, ex, ey);
        if(moveExit == max) return -1;
        answer +=  moveExit;
    
        return answer;
    }
    
    public int move(int sx, int sy, int ex, int ey) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] arr = new int[map.length][map[0].length];
        for(int i=0; i<arr.length; i++) {
            Arrays.fill(arr[i], max);
        }
        arr[sx][sy] = 0;
        queue.add(new int[] {sx, sy});
        
        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            int x = q[0];
            int y = q[1];
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || map[nx][ny] == max)
                    continue;
                
                // 이전 위치의 최소값과 비교(첫방문인지 확인)
                if(arr[x][y] + 1 < arr[nx][ny]) {
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        return arr[ex][ey];
    }
}