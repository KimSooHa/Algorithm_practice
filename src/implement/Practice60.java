package implement;

public class Practice60 {
	// 콜라 문제(프로그래머스 lv1)

	public static int solution(int a, int b, int n) {
        return getCola(a, b, n, 0);
    }
    
    public static int getCola(int bottle, int cola, int empty, int total) {
        
        if(empty < bottle) 
            return total;
        
            
        total += (empty / bottle) * cola;
        empty = (empty/bottle)*cola + (empty % bottle);
        
        return getCola(bottle, cola, empty, total);
    }
	
	public static void main(String[] args) {
		
		// ex1
		System.out.println(solution(2, 1, 20));
		
		// ex2
		System.out.println(solution(3, 1, 20));
		
	} // end of main

} // end of class
