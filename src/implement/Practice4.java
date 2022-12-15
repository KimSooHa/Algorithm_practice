package implement;

public class Practice4 {
	// 직사각형(프로그래머스)
			
	public static int solution(int[][] sizes) {
        int answer = 0;
        
        int width = 0, height = 0;
        
        for(int[] rect : sizes) {
        	width = Math.max(width, Math.max(rect[0], rect[1]));
        	height = Math.max(height, Math.min(rect[0], rect[1]));
        }
        
        answer = width * height;
        
        return answer;
    }
	
	public static void main(String args[]) {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		int answer = solution(sizes);
		
		System.out.println(answer);
	}
	
}	// end of class