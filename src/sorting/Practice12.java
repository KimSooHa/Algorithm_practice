package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Practice12 {
	// KCPC(���� 3758 - �ǹ�2)
	
//	���� ������ ���� ���, Ǯ�̸� ������ Ƚ���� ���� ���� ������ ����. 
//	���� ������ ���� ���� Ƚ���� ���� ���, ������ ���� �ð��� �� ���� ���� ������ ����. 
	static int tc, n, k, t, m; // �׽�Ʈ ������(tc), �� ����(n), ��������(k), ���� �� ID(t), �α� ��Ʈ�� ����(m)
	static int id, num, score; // �� ID(id), ������ȣ(num), ȹ���� ����(score) 
	static int[][] logs;
	
	static class Team implements Comparable<Team> {
        private int id; // ���� id
        private int score; // ����
        private int count; // ���� Ƚ��
        private int time; // ���� ���� �ð�

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
				num = Integer.parseInt(st.nextToken()); // ���� ��ȣ
				score = Integer.parseInt(st.nextToken()); // ����
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
				
				countSubmit[nowId]++; // ���� ���� ����� ����
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
