package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Practice1 {
	// 디스크 컨트롤러(프로그래머스 - 힙)
			
	// 다른 사람 코드 참고
	// job이 들어오는 순서는 시간 순이 아닐 수 있다.(오름차순으로 정렬 필요!) => 수행시간이 짧은 작업부터 처리
	// 2. job 하나 처리한 후에 남은 job 전체를 다시 검토해서 job을 실행해야 한다. => 하나의 작업이 끝나는 시점까지 들어온 요청에 대해서 가장 짧은 수행시간을 가진 작업을 선택해야
	// 3. 디스크 컨트롤러가 Job 처리 후에 일은 안하고 있을 때 처리 주의
	// 4, 같은 시간은 다른 job이 여러 개 들어올 수 있다.
	
	
	public static int solution(int[][] jobs) {
		
		int answer = 0;
		int end = 0;	// 수행되고 난 직후의 시간
		int index = 0;// jobs 배열의 인덱스
		int count = 0;	// 수행된 요청 갯수
		
		// 원본 배열 오름차순 정렬(요청시간 오름차순) 
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		
		// 처리시간 오름차순으로 정렬하는 우선순위 큐 
		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		// 요청이 모두 수행될 때까지 반복
		while(count<jobs.length) {
			
			// 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청(작업이 요청되는 시점과 end 비교)을 큐에 넣음
			while(index<jobs.length && jobs[index][0] <= end)
				pq.add(jobs[index++]);
			
			// 큐가 비어있다면 하나의 작업완료(end) 이후에 다시 요청이 들어온다는 의미 
			// end를 요청의 가장 처음으로 맞춰줌
			if(pq.isEmpty()) 
				end = jobs[index][0];
			// 작업이 끝나기 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행 
			else {
				int[] temp = pq.poll();
				answer += end + temp[1] - temp[0];
				end += temp[1];
				count++;
			}
		}
		
		int avg = (int) Math.floor(answer/jobs.length);
		
		return avg;
	}
	
	public static void main(String args[]) {
		
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		
		System.out.println(solution(jobs));

	}	// end of main	

	
}	// end of class

