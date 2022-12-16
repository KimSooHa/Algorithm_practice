package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practice3 {
	// 게임 맵 최단거리(프로그래머스)
	
	
	// 연결된 칸을 확인하기 위한 4방향의 위치
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	
	public static class Position {
		
		private int x;
		private int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}
	
	public static int solution(int[][] maps) {
        int answer = -1;
        
        int n = maps.length-1;
        int m = maps[0].length-1;
        
        int[][] graph = new int[n+1][m+1];
        
        
        for(int i=0; i<maps.length; i++)
        	Arrays.fill(graph[i], -1);
        
        Queue<Position> q = new LinkedList<>();
        
        q.offer(new Position(0, 0));
        
        graph[0][0] = 1;
        
        while(!q.isEmpty()) {
        	Position pos = q.poll();
        	int x = pos.getX();
        	int y = pos.getY();
        	
        	for(int i=0; i<4; i++) {
        		int nx = x + dx[i];
        		int ny = y + dy[i];
        		
        		
        		if(0<= nx && nx <= n && 0<= ny && ny <= m && maps[nx][ny] == 1 && graph[nx][ny] == -1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    
                    if(nx != n || ny != m)
                        q.offer(new Position(nx, ny));
        		}
        	}
        	
        }
        
	   answer = graph[n][m];
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		
		int answer = solution(maps);
		
		// 인구 이동 횟수 출력
		System.out.println(answer);

	}	// end of main


}	// end of class
