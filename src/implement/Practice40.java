package implement;

import java.io.IOException;

class Practice40 {
	// 피로도(프로그래머스 lv2)
	// k: 유저의 현재 피로도
	// dungeons: [최소 필요 피로도, 소모 피로도]
	// 1 <= 최소 필요 피로도 >= 소모 피로도 <= 1,000
	
	static boolean[] visit;
	static int answer = 0;
	public static int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        
    	dfs(k, dungeons, visit);
        
        return answer;
    }

	public static void dfs(int k, int[][] dungeons, boolean[] visit) {
		
		int cnt = 0;
		
		if(k <= 0)
			return;
		
		// 유저가 탐험할 수 있는 최대 던전 수 구하기
		for (int i = 0; i < visit.length; i++) {
			if(visit[i]) cnt++;
		}
		
		answer = Math.max(answer, cnt);
		
		// 던전 탐험 순열
		for(int i = 0; i < dungeons.length; i++) {
			if(dungeons[i][0] > k || visit[i]) continue;
			
			visit[i] = true;
			dfs(k - dungeons[i][1], dungeons, visit);
			visit[i] = false;
		}
		
	}

	public static void main(String args[]) throws IOException {
		
		int k = 80;
		int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
		System.out.println(solution(k, dungeons));
	}

	
}	// end of class