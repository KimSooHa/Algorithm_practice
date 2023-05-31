package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Practice39 {
	// 나이트 투어(백준 1331)
	// 이동 가능한 위치인지 판별하는 방법: x방향으로 2칸 y방향으로 1칸 or x방향으로 1칸 y방향으로 2칸
	// -> 이전 x좌표와 현재 x좌표, 이전 y좌표와 현재 y좌표의 차를 절대값으로 구해 1,2또는 2,1이 나온다면 이동할 수 있는 위치로 판별

	static int nowx, nowy, prevx, prevy;

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<String> visit = new ArrayList<>(); // 방문한 좌표를 저장하기 위한 리스트
		String st = br.readLine();
		int startx = st.charAt(0); // 첫번째 위치 저장
		int starty = st.charAt(1);
		prevx = startx;
		prevy = starty;
		
		visit.add(st);
		
		for (int i = 0; i < 35; i++) {
			String s = br.readLine();
			nowx = s.charAt(0);
			nowy = s.charAt(1);
			
			// 방문한 적 있는 곳에 또 다시 방문하면 Invalid
			if(visit.contains(s)) {
				System.out.println("Invalid");
				return;
			}
			// 나이트가 이전 위치에서 이동할 수 있는 위치이면 이전위치를 현재위치로 변경
			if(Math.abs(nowx - prevx) == 2 && Math.abs(nowy - prevy) == 1 || Math.abs(nowx - prevx) == 1 && Math.abs(nowy - prevy) == 2) {
				visit.add(s);
				prevx = nowx;
				prevy = nowy;
				continue;
			} else { // 그렇지 않다면 Invalid
				System.out.println("Invalid");
				return;				
			}
		}
		
		// 나이트가 마지막 도달위치에서 첫번쨰 위치로 갈 수 있으면 Valid
		if(Math.abs(nowx - startx) == 2 && Math.abs(nowy - starty) == 1 || Math.abs(nowx - startx) == 1 && Math.abs(nowy - starty) == 2) {
			System.out.println("Valid");
			return;
		}
		// 나이트가 마지막 도달위치에서 첫번째 위치로 갈 수 없으면 Invalid
		System.out.println("Invalid");
	}

	
}	// end of class