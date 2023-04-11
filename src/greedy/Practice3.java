package greedy;

import java.util.Arrays;

public class Practice3 {
	// ü���� (���α׷��ӽ� lv1)
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(reserve);
        Arrays.sort(lost);

        // ���� ü������ ������ �л��� �������� ���
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // �������� �л����� ü������ �����ִ� ���
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(reserve[j]+1 == lost[i] || reserve[j]-1 == lost[i]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};
		System.out.println(solution(n, lost, reserve));
		
		
	}	// end of main

}	// end of class
