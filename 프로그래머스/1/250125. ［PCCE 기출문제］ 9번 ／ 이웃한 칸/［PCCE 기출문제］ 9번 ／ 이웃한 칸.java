class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        for(int i=0; i<4; i++) {
            int hCheck = h + dh[i];
            int wCheck = w + dw[i];
            
            if(hCheck < 0 || hCheck >= n || wCheck < 0 || wCheck >= n)
                continue;
            
            if(board[h][w].equals(board[hCheck][wCheck]))
                answer ++;
        }
    
        return answer;
    }
}