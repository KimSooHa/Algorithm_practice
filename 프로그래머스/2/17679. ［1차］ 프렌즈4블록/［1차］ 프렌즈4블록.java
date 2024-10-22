import java.util.*;
class Solution {
    public static int m, n;
    public static char[][] blocks;
    public static boolean[][] visited;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        blocks = new char[m][n];
        
        for(int i=0; i<m; i++) {
            char[] b = board[i].toCharArray();
            for(int j=0; j<n; j++) {
                blocks[i][j] = b[j];
            }
        }
        
        while(true) {
            visited = new boolean[m][n];

            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    char ch = blocks[i][j];
                    if(ch >= 'A' && ch <= 'Z' && ch == blocks[i+1][j] && ch == blocks[i][j+1] && ch == blocks[i+1][j+1]) {
                        visited[i][j] = true;
                        visited[i+1][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j+1] = true;
                        checkBlock(i+1, j);
                        checkBlock(i, j+1);
                        checkBlock(i+1, j+1);
                    }
                }
            }

            ArrayList<Character>[] list = new ArrayList[n];
            for(int i=0; i<n; i++) {
                list[i] = new ArrayList<>();
                for(int j=m-1; j>=0; j--) {
                    if(!visited[j][i]) 
                        list[i].add(blocks[j][i]);
                }
            }

            int cnt = 0;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(visited[i][j])
                        cnt++;
                }
            }
            if(cnt == 0) 
                break;
            
            blocks = new char[m][n];
            for(int i=0; i<n; i++) {
                for(int j=m-1; j>=0; j--) {
                    if(list[i].size() > 0) {
                        blocks[j][i] = list[i].get(0);
                        list[i].remove(0);
                    }
                }
            }   
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(blocks[i][j] < 'A' || blocks[i][j] > 'Z')
                    answer++;
            }
        }
        
        return answer;
    }
    
    static void checkBlock(int x, int y) {
        if(x+1 < m && y+1 < n) {
            if(blocks[x][y] >= 'A' && blocks[x][y] <= 'Z' && blocks[x][y] == blocks[x+1][y] && blocks[x][y] == blocks[x][y+1] && blocks[x][y] == blocks[x+1][y+1]) {
                visited[x][y] = true;
                visited[x+1][y] = true;
                visited[x][y+1] = true;
                visited[x+1][y+1] = true;
            }
        }
    }
}