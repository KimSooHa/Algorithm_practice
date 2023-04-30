package implement;

import java.io.IOException;
import java.util.Scanner;

public class Practice28 {
	// 카펫
	
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // i: 가로크기, j: 세로크기
        for(int i=1; i<=brown; i++) {
            for(int j=1; j<=i; j++) {
                if(2*i + 2*j - 4 == brown) {
                    if(i*j - brown == yellow) {
                        answer[0] = i;
                        answer[1] = j;
                        break;
                    }
                }
            }
        }
        return answer;
    }
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int brown = sc.nextInt();
		int yellow = sc.nextInt();
		
		int[] answer = solution(brown, yellow);
		System.out.println("[" + answer[0] + ", " + answer[1] + "]");
		
	}	// end of main

}	// end of class