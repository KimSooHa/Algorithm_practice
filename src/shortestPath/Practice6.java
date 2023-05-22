package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Practice6 {
	// 지름길(백준 1446 - 다익스트라)
	// 1씩 이동하면서 지름길 및 거리 계산 수행
	
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

		// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
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
	static int[] movedDist; // 최단으로 운전한 거리
	// 각 노드에 연결되어 있는 노드에 대한 정보 배열
	static ShortCut[] shortCuts;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		movedDist = new int[d+1]; // 최단거리
		shortCuts = new ShortCut[n];
		
		// 초기화
		Arrays.fill(movedDist, INF);
		
		// 지름길 입력받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			shortCuts[i] = new ShortCut(start, end, dist);
		}
		
		// 시작점 기준 오름차순 정렬
		Arrays.sort(shortCuts);
		
		int nowDist = 0; // 현재 길이
		int nowIdx = 0; // 지름길 인덱스
		movedDist[0] = 0;
		
		while(nowDist < d) {
			while(nowIdx < n) {
				if(shortCuts[nowIdx].getStart() != nowDist)	break;
				
				// 지름길 이동
				if(shortCuts[nowIdx].getEnd() <= d) {
					int distance = movedDist[nowDist] + shortCuts[nowIdx].getDistance();
					if(distance < movedDist[shortCuts[nowIdx].getEnd()])
						movedDist[shortCuts[nowIdx].getEnd()] = distance;
				}
				nowIdx++;
			}
			
			// 한칸 이동
			if(movedDist[nowDist] + 1 < movedDist[nowDist+1])
				movedDist[nowDist+1] = movedDist[nowDist] + 1;
			
			nowDist++;
		}
		
		System.out.println(movedDist[d]);
		
	}	// end of main	
}	// end of class
