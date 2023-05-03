package implement;

import java.util.ArrayList;
import java.util.Collections;

class Practice32 {
	// 기둥과 보 설치(프로그래머스)
	
	static class Node implements Comparable<Node> {
		private int x;
		private int y;
		private int stuff;
		
		public Node(int x, int y, int stuff) {
			this.x = x;
			this.y = y;
			this.stuff = stuff;
		}
		
		
		public int getX() {
			return x;
		}


		public int getY() {
			return y;
		}


		public int getStuff() {
			return stuff;
		}


		@Override
		public int compareTo(Node other) {
			// x, y 좌표가 모두 같은 경우 기둥이 보보다 앞으로
			if(this.x == other.x && this.y == other.y)
				return Integer.compare(this.stuff, other.stuff);
			// x좌표가 같은 경우 y좌표 기준으로 오름차순
			if(this.x == other.x)
				return Integer.compare(this.y, other.y);
			// x좌표 기준으로 오름차순
			return Integer.compare(this.x, other.x);
		}
	}

	public static int[][] solution(int n, int[][] build_frame) {
		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0]; // 가로 좌표
			int y = build_frame[i][1]; // 세로 좌표
			
			int stuff = build_frame[i][2]; // 구조물 종류(0 - 기둥, 1 - 보)
			int operate = build_frame[i][3]; // 구조물 설치(1)할지 삭제(0)할지
			
			// 삭제하는 경우
			if(operate == 0) {
				// 일단 삭제를 해본 뒤에
				int index = 0;
				for (int j = 0; j < answer.size(); j++) {
					if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && stuff == answer.get(j).get(2))
						index = j;
				}
				
				ArrayList<Integer> erased = answer.get(index);
				answer.remove(index);
				if(!possible(answer)) // 가능한 구조물인지 확인
					answer.add(erased); // 가능한 구조물이 아니라면 다시 설치	
			}
			// 설치하는 경우
			if(operate == 1) {
				// 일단 설치를 해본 뒤에
				ArrayList<Integer> inserted = new ArrayList<>();
				inserted.add(x);
				inserted.add(y);
				inserted.add(stuff);
				answer.add(inserted);
				// 가능한 구조물이 아니라면 다시 제거
				if(!possible(answer))
					answer.remove(answer.size()-1); 
			}
		}
		
		// 정렬 수행
		ArrayList<Node> ans = new ArrayList<>();
		for (int i = 0; i < answer.size(); i++) 
			ans.add(new Node(answer.get(i).get(0), answer.get(i).get(1), answer.get(i).get(2)));
		
		Collections.sort(ans);
		
		// 배열로 바꾸어 변환
		int[][] res = new int[ans.size()][3];
		for (int i = 0; i < ans.size(); i++) {
			res[i][0] = ans.get(i).getX();
			res[i][1] = ans.get(i).getY();
			res[i][2] = ans.get(i).getStuff();
		}
		
        return res;
    }
	
	static boolean possible(ArrayList<ArrayList<Integer>> answer) {
		for (int i = 0; i < answer.size(); i++) {
			int x = answer.get(i).get(0);
			int y = answer.get(i).get(1);
			int stuff = answer.get(i).get(2);
			
			// 설치된 것이 '기둥'인 경우(0)
			if(stuff == 0) {
				boolean check = false;
				// '바닥' 위라면 정상
				if(y == 0)
					check = true;
				// '보의 한쪽 끝 부분 위' 혹은 '다른 기둥 위'라면 정상
				for (int j = 0; j < answer.size(); j++) {
					// 기둥이 왼쪽에 위치 && 같은 y좌표
					if(x-1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) // 기둥이 보(1)의 오른쪽 끝부분
						check = true;
					// 기둥이 보의 오른쪽에 위치
					if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2))
						check = true;
					// 기둥이 다른 기둥의 위
					if(x == answer.get(j).get(0) && y-1 == answer.get(j).get(1) && 0 == answer.get(j).get(2))
						check = true;
				} // 아니라면 거짓 반환
				if(!check)
					return false;
			} else if(stuff == 1) { // 설치된 것이 '보'인 경우
				boolean check = false;
				boolean left = false;
				boolean right = false;
				
				// '한쪽 끝부분이 기둥 위' 혹은 '양쪽 끝부분이 다른 보와 동시에 연결'이라면 정상
				for (int j = 0; j < answer.size(); j++) {
					if(x == answer.get(j).get(0) && y-1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) // 보의 왼쪽 끝이 기둥 위
						check = true;
					if(x+1 == answer.get(j).get(0) && y-1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) // 보의 오른쪽 끝이 기둥 위
						check = true;
					if(x-1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) // 보의 왼쪽 끝이 왼쪽 보와 연결
						left = true;
					if(x+1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) // 보의 오른쪽 끝이 오른쪽 보와 연결
						right = true;
				}
				if(left && right)
					check = true;
				if(!check)
					return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		
		int n = 5;
		int[][] build_frame = {{1,0,0,1}, {1,1,1,1}, {2,1,0,1}, {2,2,1,1}, {5,0,0,1}, {5,1,0,1}, {4,2,1,1}, {3,2,1,1}};
		int[][] res = solution(n, build_frame);
		System.out.print("[");
		for (int i = 0; i < res.length; i++) {
			int x = res[i][0];
			int y = res[i][1];
			int stuff = res[i][2];
			
			System.out.print("[" + x + "," + y + "," + stuff + "]");
			if(i != res.length-1)
				System.out.print(",");
			else
				System.out.print("]");
		}		
	}	// end of main

}	// end of class