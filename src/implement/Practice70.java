package implement;

public class Practice70 {
	// 덧칠하기(프로그래머스 lv1)

	public static int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] isBlank = new boolean[n];
        for(int i=0; i<section.length; i++) 
            isBlank[section[i]-1] = true;

        for(int i=0; i<n; i++) {
            if(isBlank[i]) {
                while(i+m > n) i--;

                for(int j=0; j<m; j++) 
                    isBlank[i+j] = false;
                answer++;
            }
        }

        return answer;
    }
	
	// ---------------------
	// 다른 방식 풀이
	// 1.
//	public static int solution(int n, int m, int[] section) {
//        int roller = section[0];
//        int cnt = 1;
//        for(int i = 1; i < section.length; i++) {
//            if(roller + m <= section[i]) {
//                cnt++;
//                roller = section[i];
//            }
//        }
//        return cnt;
//    }
	
	// 2.
//	public static int solution(int n, int m, int[] section) {
//        int maxPainted = 0, cntPaint = 0;
//        for (int point : section) {
//            if (maxPainted <= point) {
//                maxPainted = point + m;
//                cntPaint++;
//            }
//        }
//        return cntPaint;
//    }

	public static void main(String[] args) {

		// ex1
		int n = 8, m = 4;
		int[] section1 = {2, 3, 6};
		System.out.println(solution(n, m, section1));
		
		// ex2
		n = 5;
		m = 4;
		int[] section2 = {1, 3};
		System.out.println(solution(n, m, section2));
		
		// ex2
		n = 4;
		m = 1;
		int[] section3 = {1, 2, 3, 4};
		System.out.println(solution(n, m, section3));
	} // end of main

} // end of class
