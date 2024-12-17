import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        
        for(int j=0; j<moves.length; j++) {
            int move = moves[j] - 1;
            for(int i=0; i<board.length; i++) {
                if(board[i][move] != 0) {
                    if(basket.size() > 0 && basket.peek() == board[i][move]) {
                        basket.pop();
                        answer += 2;
                    } else    
                        basket.push(board[i][move]);
                    board[i][move] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}