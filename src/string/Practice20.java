package string;

public class Practice20 {
	// [3차] n진수 게임 (프로그래머스 lv2)

	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        int num = 0;
        for(int i=0; i<t*m; i++) {
            str += Integer.toString(num, n).toUpperCase();
            num++;
        }
        
        for(int i=p-1; i<t*m; i+=m)
            answer += str.charAt(i);
        
        return answer;
    }


	public static void main(String[] args) {

		// ex1
		int n = 2, t = 4, m = 2, p = 1;
		System.out.println(solution(n, t, m, p));

		System.out.println("------");
		// ex2
		n = 16;
		t = 16;
		m = 2;
		p = 1;
		System.out.println(solution(n, t, m, p));
		
		System.out.println("------");
		// ex3
		n = 16;
		t = 16;
		m = 2;
		p = 2 ;
		System.out.println(solution(n, t, m, p));
	} // end of main
} // end of class