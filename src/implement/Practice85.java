package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice85 {
	// ��Ű�� ��ü ����(���� 20125 - �ǹ�4)
	static int n, x, y;
	static char[][] board;
	static boolean isHead;
	static int leftArm, rightArm, leftLeg, rightLeg, waist = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		board = new char[n][n];
		
		// ���� ä���
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j=0; j<n; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j] == '*' && !isHead) {
					isHead = true;
					if(board[i+1][j] == '*') { // ������ġ
						// ���� ���尡 (1,1)���� �����̹Ƿ� 1 ���ϱ�
						x = i + 1 + 1;
						y = j + 1;
						leftArm = getLength(i+1, j, "left");
						rightArm = getLength(i+1, j, "right");
						waist = getLength(i+1, j, "default");
						leftLeg = getLength(i+1+waist, j-1, "default");
						rightLeg = getLength(i+1+waist, j+1, "default");
						break;
					}
				}
			}
		}
		System.out.println(x + " " + y);
		System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
	} // end of main


	public static int getLength(int i, int j, String str) {
		int cnt = 0;
		switch (str) {
			case "left": {
				while(true) {
					j--;
					if(j < 0  || board[i][j] == '_')
						return cnt;
					if(board[i][j] == '*')
						cnt++;
				}
			}
			case "right" : {
				while(true) {
					j++;
					if(j >= n || board[i][j] == '_')
						return cnt;
					if(board[i][j] == '*')
						cnt++;
				}
			}
			 // �㸮, ���� �ٸ�, ������ �ٸ�
			default : {
				while(true) {
					i++;
					if(i >= n || board[i][j] == '_')
						return cnt;
					if(board[i][j] == '*')
						cnt++;
				}
			}
		}
	}
} // end of class