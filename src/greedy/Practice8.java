package greedy;

import java.util.Arrays;

public class Practice8 {
	// ����Ʈ(���α׷��ӽ� lv2)
	// ������ ���� ���� �����԰� ���� ������ ����� ���� �����԰� ���� ������ ����鳢�� ��Ʈ�� �¿��
	public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        
        for(int i=people.length-1; i>=min; i--) {
        	if(people[i] + people[min] <= limit) {
                answer++;
                min++;
            } else
                answer++;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		 System.out.println(solution(people, limit));
	}	// end of main

}	// end of class
