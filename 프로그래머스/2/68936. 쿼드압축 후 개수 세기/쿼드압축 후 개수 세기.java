class Solution {
	// sol 1
	static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        quad(arr, arr.length, 0, 0);
        return answer;
    }
    
    public void quad(int[][] arr, int size, int x, int y){        
        // 같은 값으로만 갖고 있으면, 해당 값 갯수 증가
        if(isSame(arr, size, x, y, arr[x][y])) {
            if(arr[x][y] == 0)
                answer[0]++;
            else
                answer[1]++;
            return;
        } 
        // 아니면 범위 4등분해서 과정 반복
        int length = size / 2;

        quad(arr, length, x, y);
        quad(arr, length, x + length, y);
        quad(arr, length, x, y + length);
        quad(arr, length, x + length, y + length);
    }
    
    // 범위 내부의 수들이 모두 같은 값을 갖고 있는지 체크
    public boolean isSame(int[][] arr, int size, int x, int y, int num) {
        for(int i=x; i<x + size; i++) {
            for(int j=y; j<y + size; j++) {                
                if(num != arr[i][j])
                    return false;
            }
        }
        return true;
    }
	
	
	
	// sol 2
//    public int[] solution(int[][] arr) {
//        int[] answer = new int[2];
//        
//        quad(arr, arr.length, 0, 0);
//        for(int i=0; i<arr.length; i++) {
//            for(int j=0; j<arr.length; j++) {
//                if(arr[i][j] == 0)
//                    answer[0] ++;
//                else if(arr[i][j] == 1)
//                    answer[1] ++;
//            }
//        }
//        
//        return answer;
//    }
//    
//    public void quad(int[][] arr, int size, int x, int y){
//        if(size <= 1)
//            return;
//        
//        if(isSame(arr, size, x, y)) {
//            for(int i=x; i<x + size; i++) {
//                for(int j=y; j<y + size; j++) {
//                    if(i == x && j == y)
//                        continue;
//                    
//                    arr[i][j] = -1;
//                }
//            }
//        } else {
//            int length = size / 2;
//            
//            quad(arr, length, x, y);
//            quad(arr, length, x + length, y);
//            quad(arr, length, x, y + length);
//            quad(arr, length, x + length, y + length);
//        }
//    }
//    
//    public boolean isSame(int[][] arr, int size, int x, int y) {
//        int num = -1;
//        
//        for(int i=x; i<x + size; i++) {
//            for(int j=y; j<y + size; j++) {
//                if(i == x && j == y)
//                    num = arr[i][j];
//                
//                if(num != arr[i][j])
//                    return false;
//            }
//        }
//        return true;
//    }
}