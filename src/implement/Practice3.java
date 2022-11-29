package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice3 {
	// 치킨 배달(백준 15686)
			
	// 보드의 크기(n), 최대 치킨집 개수(m)
	public static int n, m;
	public static int[][] arr = new int[50][50]; // 맵 정보
	public static ArrayList<Position> chicken = new ArrayList<>();
	public static ArrayList<Position> house = new ArrayList<>();
	
	public static StringTokenizer st;
	
	
	public static class Position {
		
		private int x;
		private int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
		
	}
	
	public static class Combination {
		private int n;	// 치킨집 개수
		private int m;	// 치킨집 최대 개수
		private int[] now;	// 현재 조합
		private ArrayList<ArrayList<Position>> result;	// 모든 조합
		
		public Combination(int n, int m) {
			this.n = n;
			this.m = m;
			this.now = new int[m];
			this.result = new ArrayList<ArrayList<Position>>();
		}
		
		public void combination(ArrayList<Position> arr, int depth, int index, int target) {
			// 치킨집 최대 개수가 되었으면
			if(depth == m) {
				ArrayList<Position> temp = new ArrayList<>();
				
				// 현재 조합의 치킨 위치를 리스트에 추가
				for(int i=0; i<now.length; i++) 
					temp.add(arr.get(now[i]));
				
				result.add(temp);	// 리스트를 result 리스트에 추가(치킨의 최대 개수만큼)
				
				return;
			}
			if(target == n)
				return;
			
			now[index] = target;
			
			combination(arr, depth+1, index+1, target+1);
			
			combination(arr, depth, index, target+1);
		}
		
		// 모든 조합의 리스트 반환
		public ArrayList<ArrayList<Position>> getResult() {
			return result;
		}
		
	}
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 1)
					house.add(new Position(i, j));	// 일반 집
				else if(arr[i][j] == 2)
					chicken.add(new Position(i, j));	// 치킨 집
			}
		}
		
		// 모든 치킨 집 중에서 m개의 치킨 집을 뽑는 조합 계산
		Combination comb = new Combination(chicken.size(), m);
		comb.combination(chicken, 0, 0, 0);
		ArrayList<ArrayList<Position>> chickenList = comb.getResult();
		
		// 치킨 거리의 합의 최소를 찾아 출력
		int result = (int)1e9;	// 최대값으로 놓고 비교하기 위해 무한을 의미하는 값으로 10억을 설정
		
		// 각 조합 리스트로 도시의 치킨 거리의 최솟값 구하기
		for(int i=0; i<chickenList.size(); i++) {
			result = Math.min(result, getSum(chickenList.get(i)));
		}
		
		System.out.println(result);

	}	// end of main	


	public static int getSum(ArrayList<Position> chickens) {
		int result = 0;
		
		// 모든 집에 대하여
		for(int i=0; i<house.size(); i++) {
			int hx = house.get(i).getX();
			int hy = house.get(i).getY();
			
			// 가장 가까운 치킨집을 찾기
			int temp = (int)1e9;
			
			for(int j=0; j<chickens.size(); j++) {
				int cx = chickens.get(j).getX();
				int cy = chickens.get(j).getY();
				
				temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));	// 모든 집을 기준으로 가장 가까운 치킨집 구하기
			}
			
			// 모든 집의 치킨거리의 합(도시의 치킨거리) 구하기
			result += temp;
			
		}
		
		return result;
	}
	
}	// end of class

