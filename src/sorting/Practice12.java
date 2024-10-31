package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Practice12 {
	// KCPC(백준 3758 - 실버2)
	
//	최종 점수가 같은 경우, 풀이를 제출한 횟수가 적은 팀의 순위가 높다. 
//	최종 점수도 같고 제출 횟수도 같은 경우, 마지막 제출 시간이 더 빠른 팀의 순위가 높다. 
	static int tc, n, k, t, m; // 테스트 데이터(tc), 팀 갯수(n), 문제갯수(k), 나의 팀 ID(t), 로그 엔트리 갯수(m)
	static int id, num, score; // 팀 ID(id), 문제번호(num), 획득한 점수(score) 
	static int[][] logs;
	
	static class Team implements Comparable<Team> {
        private int id; // 팀의 id
        private int score; // 점수
        private int count; // 제출 횟수
        private int time; // 최종 제출 시간

        public Team(int id, int score, int count, int time) {
            this.id = id;
            this.score = score;
            this.count = count;
            this.time = time;
        }
        
        public int getId() {
            return this.id;
        }
        
        public int getScore() {
            return this.score;
        }
        
        public int getCount() {
            return this.count;
        }
        
        public int getTime() {
            return this.time;
        }
        
        @Override
        public int compareTo(Team o) {
            if(this.getScore() == o.getScore()) {
            	if(this.getCount() == o.getCount())
            		return Integer.compare(this.getTime(), o.getTime());
            
        		return Integer.compare(this.getCount(), o.getCount());
        	}
            else
                return Integer.compare(o.getScore(), this.getScore());
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int idx=0; idx<tc; idx++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			logs = new int[m][3];
			int answer = 0; 
			
			for(int j=0; j<m; j++) {
				st = new StringTokenizer(br.readLine());
				id = Integer.parseInt(st.nextToken()); // id
				num = Integer.parseInt(st.nextToken()); // 문제 번호
				score = Integer.parseInt(st.nextToken()); // 점수
				logs[j][0] = id;
				logs[j][1] = num;
				logs[j][2] = score;				
			}
			
			int[][] saveScore = new int[n+1][k+1];
			int[] countSubmit = new int[n+1];
			int[] times = new int[n+1];
			int time = 0;
			for(int j=0; j<m; j++) {	
				int nowId = logs[j][0];
				int nowNum = logs[j][1];
				int nowScore = logs[j][2];
				
				countSubmit[nowId]++; // 현재 팀의 제출수 증가
				saveScore[nowId][nowNum] = Math.max(saveScore[nowId][nowNum], nowScore);
				times[nowId] = time;
				time++;
			}
			
			List<Team> list = new ArrayList<>();
			for(int i=1; i<=n; i++) {
				int sum = 0;
				for(int j=0; j<=k; j++) {
					sum += saveScore[i][j];
				}
				list.add(new Team(i, sum, countSubmit[i], times[i]));
			}
			
			Collections.sort(list);
			
			for(int j=0; j<list.size(); j++) {
				if(list.get(j).getId() == t) {
					answer = j+1;
					break;
				}
			}
			sb.append(answer + "\n");
		}
		System.out.print(sb);
	} // end of main
} // end of class
