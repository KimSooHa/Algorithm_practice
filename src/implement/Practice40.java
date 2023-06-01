package implement;

import java.io.IOException;

class Practice40 {
	// �Ƿε�(���α׷��ӽ� lv2)
	// k: ������ ���� �Ƿε�
	// dungeons: [�ּ� �ʿ� �Ƿε�, �Ҹ� �Ƿε�]
	// 1 <= �ּ� �ʿ� �Ƿε� >= �Ҹ� �Ƿε� <= 1,000
	
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
		
		// ������ Ž���� �� �ִ� �ִ� ���� �� ���ϱ�
		for (int i = 0; i < visit.length; i++) {
			if(visit[i]) cnt++;
		}
		
		answer = Math.max(answer, cnt);
		
		// ���� Ž�� ����
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