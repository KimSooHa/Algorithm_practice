package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Practice6 {
	// ������(���� 1446 - ���ͽ�Ʈ��)
	// 1�� �̵��ϸ鼭 ������ �� �Ÿ� ��� ����
	
	static class ShortCut implements Comparable<ShortCut> {
		
		private int start;
		private int end;
		private int distance;

		public ShortCut(int start, int end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
		

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public int getDistance() {
			return distance;
		}

		// �Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
		@Override
		public int compareTo(ShortCut o) {
			if(this.start < o.start)
				return -1;
			
			return 1;
		}
	}
	
	static StringTokenizer st;
		
	static final int INF = Integer.MAX_VALUE;
	static int n, d;
	static int[] movedDist; // �ִ����� ������ �Ÿ�
	// �� ��忡 ����Ǿ� �ִ� ��忡 ���� ���� �迭
	static ShortCut[] shortCuts;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		movedDist = new int[d+1]; // �ִܰŸ�
		shortCuts = new ShortCut[n];
		
		// �ʱ�ȭ
		Arrays.fill(movedDist, INF);
		
		// ������ �Է¹ޱ�
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			shortCuts[i] = new ShortCut(start, end, dist);
		}
		
		// ������ ���� �������� ����
		Arrays.sort(shortCuts);
		
		int nowDist = 0; // ���� ����
		int nowIdx = 0; // ������ �ε���
		movedDist[0] = 0;
		
		while(nowDist < d) {
			while(nowIdx < n) {
				if(shortCuts[nowIdx].getStart() != nowDist)	break;
				
				// ������ �̵�
				if(shortCuts[nowIdx].getEnd() <= d) {
					int distance = movedDist[nowDist] + shortCuts[nowIdx].getDistance();
					if(distance < movedDist[shortCuts[nowIdx].getEnd()])
						movedDist[shortCuts[nowIdx].getEnd()] = distance;
				}
				nowIdx++;
			}
			
			// ��ĭ �̵�
			if(movedDist[nowDist] + 1 < movedDist[nowDist+1])
				movedDist[nowDist+1] = movedDist[nowDist] + 1;
			
			nowDist++;
		}
		
		System.out.println(movedDist[d]);
		
	}	// end of main	
}	// end of class
