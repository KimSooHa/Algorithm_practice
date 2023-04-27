package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Practice23 {
	// ���� ����
	static int n, m, x, y, d;
	static StringTokenizer st;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		// ���� ũ�� �Է¹ޱ�
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		// ���� ĳ������ ��ġ
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		// ���� ĳ������ ����(direction)
		d = Integer.parseInt(st.nextToken());

		// ��, ��, ��, �� ���� ����
		int[] dx = {-1, 0, 1, 0};	// ���ʱ���
		int[] dy = {0, 1, 0, -1};	// ���ʱ���
		
		// �湮�� ��ġ�� �����ϱ� ���� ���� �����Ͽ� 0���� �ʱ�ȭ
		int xy[][] = new int[n][m];
		// ��ü �� ����
		int[][] arr = new int [n][m];
		xy[x][y] = 1;	// ���� ��ġ�� ��ǥ �湮 ó��
		
		// ���� �� ä���
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());	
		}
		// 8���� ���⿡ ���Ͽ� �� ��ġ�� �̵��� �������� Ȯ��
		int cnt = 1;// �湮��
		int turnTime = 0;	// ȸ��Ƚ��
		
		while(true) {
			// �������� ȸ��
			turnLeft();
			// ������ġ���� �̵��������� �̵��ϱ�
			int nx = x + dx[d];
			int ny = y + dy[d];
			// ȸ���� ���� ���鿡 ������ ���� ĭ�� �����ϴ� ��� �̵�
			if(xy[nx][ny] == 0 && arr[nx][ny] == 0) {
				xy[nx][ny] = 1;
				x = nx;
				y = ny;
				cnt++;
				turnTime = 0;
				continue;
			}
			// ȸ���� ���� ���鿡 ������ ���� ĭ�� ���ų� �ٴ��� ���
			else
				turnTime++;
			// �� ���� ��� �� �� ���� ���
			if(turnTime == 4) {
				nx = x - dx[d];
				ny = y - dy[d];
				// �ڷ� �� �� �ִٸ� �̵�
				if(arr[nx][ny] == 0) {
					x = nx;
					y= ny;					
				} else break;	// �ڰ� �ٴٷ� �����ִ� ��� 
				
				turnTime = 0;
			}
		}
		
		System.out.println(cnt);
		
	}	// end of main

	public static void turnLeft() {
		// 1�� ���ָ鼭 ��,��,��,�� ����, �� ���� ���� �ݽð� ���� 90�� ȸ����Ű��
		d -= 1;
		if(d == -1)	// ���ʿ��� ȸ���� ���� �������� ����
			d = 3;
	}
}	// end of class