package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Practice45 {
	// �巡�� Ŀ��(���� 15685)
	
	static int n; // Ŀ�� ����
	static int length = 101;
	static boolean[][] arr = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0}; // x��
    static int[] dy = {0, -1, 0, 1}; // y��
	static int cnt = 0;

	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// x, y:������, d:���۹���, g:����
		// 1. ���� ���ϱ�
		// 2. ������ �׸���
		// 3. 1x1�� ���簢�� ���ϱ�
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // ���� ����
			int g = Integer.parseInt(st.nextToken()); // ����
			
			draw(x, y, getDirections(d, g));
		}
		
		System.out.println(getNumberOfSquares());
				
	} // end of main

	
	public static int getNumberOfSquares() {
		int cnt = 0;
		
		 for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length-1; j++) {
                if (arr[i][j] && arr[i][j + 1] && arr[i + 1][j] && arr[i + 1][j + 1]) {
                    cnt++;
                }
            }
        }
		return cnt;
	}

	public static List<Integer> getDirections(int d, int g) {
		
		List<Integer> directions = new ArrayList<>();
		directions.add(d); // ���� ���� �߰�
		// ���� ������ ������ �������� �׸�
		// �Է¹��� ������ Ŀ�� ������ �ݽð� �������� ����Ʈ�� ���
		for(int i = 0; i < g; i++) {
			for (int j = directions.size()-1; j >= 0; j--) { // ������ ���� -> ó��������� ������ �ݺ�
				int dir = (directions.get(j) + 1) % 4; // (������ ���� + 1) % 4
				directions.add(dir); // ���ο� ���� �߰�
			}
		}
		
		return directions;
	}


    public static void draw(int x, int y, List<Integer> directions) {

        arr[x][y] = true;
        // ����Ʈ�� �������� ��ǥ�� �׸���
        for (Integer direction : directions) {
            x += dx[direction];
            y += dy[direction];
            arr[x][y] = true;
        }
    }

}	// end of class