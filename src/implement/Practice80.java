package implement;

public class Practice80 {
	// 체육대회(프로그래머스 pccp 모의고사 1회 - 2번)

	static int[] board;
    static int result;
    static int r;
    
    public static int solution(int[][] ability) {
        board = new int[ability.length];
        r = ability[0].length;
        for(int i = 0; i < ability.length; i++)
            board[i] = i;
        
        permutation(0, ability);
        return result;
    }
    private static void permutation(int depth, int[][] ability) {
        if(depth == r) {
            int sum = 0;
            for(int i=0; i<r; i++)
                sum += ability[board[i]][i];
            result = Math.max(result, sum);
            return;
        }
        
        for(int i = depth; i < ability.length; i++) {
            swap(i, depth); 
            permutation(depth + 1, ability); 
            swap(depth, i); 
        }
    }
    private static void swap(int a, int b) {
        int tmp = board[b];
        board[b] = board[a];
        board[a] = tmp;
    }
	
	public static void main(String[] args) {
		// tc1.
		int[][] ability1 = {{40,10,10},{20,5,0},{30,30,30},{70,0,70},{100,100,100}};
		System.out.println(solution(ability1));
		
		// tc2.
//		int[][] ability2 = {{20,30},{30,20},{20,30}};
//		System.out.println(solution(ability2));
	} // end of main

} // end of class
