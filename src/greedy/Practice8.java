package greedy;

import java.util.Arrays;

public class Practice8 {
	// 구명보트(프로그래머스 lv2)
	// 정렬을 통해 가장 몸무게가 많이 나가는 사람과 가장 몸무게가 적게 나가는 사람들끼리 보트에 태우기
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
