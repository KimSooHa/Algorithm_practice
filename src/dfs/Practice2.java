package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice2 {
	// ������(���� 14502)
	
	// ������ ���� ũ��(n), ���� ũ��(m)
	public static int n, m;
	public static int result = 0;
	
	public static StringTokenizer st;
	
	// �Է¹��� �迭 �ʱ�ȭ
	public static int[][] arr = new int[8][8];
	// ���� �ε������� ������ �� �����ϱ� ���� �迭
	public static int[][] temp = new int[8][8];
	
	// 4���� �̵� ���⿡ ���� �迭(��,��,��,��)
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());

		// ������ ũ�� �Է¹ޱ�
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 2���� �迭�� �� ���� �Է¹ޱ�
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
			
		dfs(0);

		// ����� ���
		System.out.println(result);
		
	}	// end of main

	// ���� �켱 Ž���� �̿��� ��Ÿ���� ��ġ�ϸ鼭, �� �� ���� ������ ũ�� ���
	public static void dfs(int count) {
		
		if(count == 3) {	// ���� 3�� ��������
			
			// ������ �� �� �迭�� ����
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) 
					temp[i][j] = arr[i][j];
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(temp[i][j] == 2)	// ���̷����� �ִ� ��ġ���
						virus(i, j);	// ���̷��� �۶߸���
				}
			}
			
			// ���� ������ �ִ� ���
			result = Math.max(result, getCount());
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 0) {	// ��ĭ�̶��
					arr[i][j] = 1;	// �������
					count++;
					dfs(count);
					arr[i][j] = 0;	// ���̿켱Ž���� ������ ��Ÿ�� ����
					count--;	// ��Ÿ�� ���� ���̱�
				}
			}
		}
			
		
		
	}

	// 0�� ����(���� ������ ũ�� ���)
	public static int getCount() {
		int score = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(temp[i][j] == 0)
					score++;
			}
		}
		
		return score;
	}

	// ���̷��� �۶߸���
	public static void virus(int x, int y) {
		
		// ���̷��� �ִ� �������� 4���� ���̷��� �۶߸���
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// ������ ���� �����ȿ� ���� ��
			if(0<= nx && nx < n && 0 <= ny && ny < m) {	
				
				// ������ ��ĭ�̶��
				if(temp[nx][ny] == 0) {
					temp[nx][ny] = 2;	// ���̷��� �۶߸���
					virus(nx, ny);
				}
			}
		}
		
	}
	


}	// end of class
