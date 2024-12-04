class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        quad(arr, arr.length, 0, 0);
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(arr[i][j] == 0)
                    answer[0] ++;
                else if(arr[i][j] == 1)
                    answer[1] ++;
            }
        }
        
        return answer;
    }
    
    public void quad(int[][] arr, int size, int x, int y){
        if(size <= 1)
            return;
        
        if(isSame(arr, size, x, y)) {
            for(int i=x; i<x + size; i++) {
                for(int j=y; j<y + size; j++) {
                    if(i == x && j == y)
                        continue;
                    
                    arr[i][j] = -1;
                }
            }
        } else {
            int length = size / 2;
            
            quad(arr, length, x, y);
            quad(arr, length, x + length, y);
            quad(arr, length, x, y + length);
            quad(arr, length, x + length, y + length);
        }
    }
    
    public boolean isSame(int[][] arr, int size, int x, int y) {
        int num = -1;
        
        for(int i=x; i<x + size; i++) {
            for(int j=y; j<y + size; j++) {
                if(i == x && j == y)
                    num = arr[i][j];
                
                if(num != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}