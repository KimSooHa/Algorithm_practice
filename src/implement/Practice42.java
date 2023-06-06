package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Practice42 {
	// ลท(น้มุ 1063)
	static int n;
	static int kingX, kingY, stoneX, stoneY;
	static StringTokenizer st;
	static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
	static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
	static String[] dir = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		kingY = s.charAt(0) - 'A' + 1;
		kingX = s.charAt(1) - '0';
		s = st.nextToken();
		stoneY = s.charAt(0) - 'A' + 1;
		stoneX = s.charAt(1) - '0';
		n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < 8; j++) {
				if(str.equals(dir[j])) {
					int kingNx = kingX + dx[j];
					int kingNy = kingY + dy[j];
					int stoneNx = stoneX + dx[j];
					int stoneNy = stoneY + dy[j];
					
					if(check(kingNx, kingNy)) {
						if(kingNx == stoneX && kingNy == stoneY) {
							if(check(stoneNx, stoneNy)) {
								kingX = kingNx;
								kingY = kingNy;
								stoneX = stoneNx;
								stoneY = stoneNy;							
							}
							
						} else  {
							kingX = kingNx;
							kingY = kingNy;
						}
					}
				}
			}
		}
		
		kingY = kingY - 1 + 'A';
		stoneY = stoneY - 1 + 'A';
		System.out.println((char)kingY + "" + kingX);
		System.out.println((char)stoneY + "" + stoneX);
	} // end of main


	static boolean check(int x, int y) {
		if(0 >= x || x > 8 || 0 >= y || y > 8)return false;
		return true;
	}
}	// end of class