package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Practice10 {
	// 매직 스타(백준 3967)
	
	static char[][] map = new char[5][9];
	static boolean[] visited = new boolean[13];
	static ArrayList<Node> list = new ArrayList<>(); // 알파벳으로 채워야 할 곳을 담아두는 리스트
	
	static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j);
				// 수가 채워져 있지 않으면 해당 위치 리스트에 추가
				if(map[i][j] == 'x')
					list.add(new Node(i, j));
				// 기존 알파벳 사용한 인덱스는 방문 처리
				else if(map[i][j] != '.')
					visited[map[i][j]-65] = true; // A-64 = 1
			}
		}
		
		dfs(0);
		
	} // end of main

	public static void dfs(int idx) {
		if(idx == list.size()) {
			if(check()) {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 9; j++) {
						System.out.print(map[i][j]+"");
					}
					System.out.println();
				}
				System.exit(0);
			}
			else return;
		}
		
		for (int i = 0; i < 12; i++) { // A~L까지 탐색
			
			if(!visited[i]) { // 해당 알파벳이 쓰이지 않았다면
				Node a = list.get(idx);
				char alpha = (char) (65 + i); // A + i
				map[a.x][a.y] = alpha;
				visited[i] = true;
				dfs(idx+1);
				visited[i] = false;
				map[a.x][a.y] = '.';
			}
		}
	}

	public static boolean check() {
		// 4개로 이루어진 줄의 숫자 합하기
		int sum1 = (map[0][4]-'A'+1) + (map[1][3]-'A'+1)+ (map[2][2]-'A'+1)+(map[3][1]-'A'+1);
        int sum2 = (map[0][4]-'A'+1)+(map[1][5]-'A'+1)+(map[2][6]-'A'+1)+(map[3][7]-'A'+1);
        int sum3 = (map[1][1]-'A'+1)+(map[1][3]-'A'+1)+(map[1][5]-'A'+1)+(map[1][7]-'A'+1);
        int sum4 = (map[3][1]-'A'+1)+(map[3][3]-'A'+1)+(map[3][5]-'A'+1)+(map[3][7]-'A'+1);
        int sum5 = (map[4][4]-'A'+1)+(map[3][3]-'A'+1)+(map[2][2]-'A'+1)+(map[1][1]-'A'+1);
        int sum6 = (map[4][4]-'A'+1)+(map[3][5]-'A'+1)+(map[2][6]-'A'+1)+(map[1][7]-'A'+1);
		
        // 각 줄의 숫자 합이 26으로 모든 줄이 26이면 출력가능
		if(sum1 == 26 && sum2 == 26 && sum3 == 26 && sum4 == 26 && sum5 == 26 && sum6 == 26)
			return true;
		
		return false;
	}

} // end of class
