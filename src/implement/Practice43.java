package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Practice43 {
	// 컨베이어 벨트 위의 로봇(백준 20055)
	static int n, k;
	
	static StringTokenizer st;
	static int A[];
	static boolean robot[];
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		A = new int[2 * n];
		robot = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n * 2; i++) 
			A[i] = Integer.parseInt(st.nextToken()); 
		
		System.out.println(simulation(0));
				
	} // end of main


	// 로봇과 함께 한 칸 회전
	// 벨트가 회전하는 방향으로 한칸 이동할 수 있으면 이동, 아니면 가만히 있
	// 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 함
	// 내구도가 0인 칸의 개수가 k개 이상이면 과정 종료
	public static int simulation(int cnt) {
		
		while(isOk()) {
			// 벨트 한 칸 회전
			int temp = A[A.length-1]; 
			for (int i = A.length-1; i > 0; i--) // 뒤에서부터 각 인덱스 값 뒤로 옮기기 
				A[i] = A[i - 1];
			
			A[0] = temp; // 맨 뒤의 인덱스는 맨 앞으로 위치
			
			for (int i = robot.length-1; i > 0; i--) // 로봇도 벨트와 같이 회전 
				robot[i] = robot[i-1];
			
			robot[0] = false; // 로봇 첫번째 위치 비움
				
			robot[n-1] = false; // 내리는 위치의 로봇 내리기
			
			for(int i = n-1; i > 0; i--) { // 로봇 이동가능하면 이동
				if(robot[i-1] && !robot[i] && A[i] >= 1) {
					robot[i] = true;
					robot[i-1] = false;
					A[i]--;
				}
			}
			
			if(A[0] > 0) { // 올라가는 위치에 로봇 올리기
				robot[0] = true;
				A[0]--;
			}
			
			cnt++; // 진행 단계 올리기
		}
		
		return cnt;
	}


	// 내구도가 0인 칸의 개수가 k개 이상인지 체크
	public static boolean isOk() {
		
		int cnt = 0;
		
		for (int i = 0; i < A.length; i++) {
			
			if(A[i] == 0)
				cnt++;
			
			if(cnt >= k)
				return false;
		}
		return true;
	}

}	// end of class