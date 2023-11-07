package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice75 {
	// 문자열 교환(백준 1522)

	// 주어진 문자열 0번째 인덱스부터 문자열 끝까지 시작해, 그 위치에서 a의 일이까지 살펴보면서 b가 있을 경우 b를 a와 교환
	// 교환횟수의 최솟값 = b와 a를 직접 교환 x. b가 있다면 b의 카운팅을 세주고 최솟값 구하기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch = br.readLine().toCharArray();
		int aCnt = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<ch.length; i++) {
			if(ch[i] == 'a')
				aCnt++;
		}
		
		for(int i=0; i<ch.length; i++) {
			int bCnt = 0;
			// 0 인덱스부터 끝 인덱스까지 살펴보면서 b의 개수 카운팅.
			for(int j=i; j<aCnt+i; j++) {
				if(ch[j%ch.length] == 'b') // 문자열이 원형으로 이어져있으므로 나머지 연산자를 통해서 주어진 문자열의 범위에 넘어가면 다시 0번째부터 살펴보기!
					bCnt++;
			}
			// b의 최솟값 = 최소의 교환횟수
			min = Math.min(min, bCnt);
		}
		System.out.println(min);
	} // end of main
} // end of class
