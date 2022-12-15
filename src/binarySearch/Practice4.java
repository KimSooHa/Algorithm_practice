package binarySearch;

import java.util.Arrays;

public class Practice4 {
	// 입국 심사(프로그래머스)
	// 가장 적게 걸리는 시간과 가장 오래 걸릴 시간(입국심사를 기다리는 사람 수 * 심사관이 한명을 심사하는데 걸리는 시간중 가장 큰 시간)을 기준으로 이분탐색하는 것이 포인트!
	// 중간값을 각 심사관이 걸리는 시간으로 나눠서 각 심사관이 심사가능한 인원을 모두 더해서 입국심사 대기인원과 비교
	
	public static long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long start = 0;
        long end = (long)n * times[times.length-1];
        
        while(start <= end) {
        	long mid = (start + end) / 2;
        	long cnt = 0;	// 총 심사한 인원
        	
        	for(int i=0; i<times.length; i++) {	// 빨리 심사하는(걸리는 시간 적은) 심사관 순으로 심사처리
        		cnt += mid / times[i];
        	}
        	
        	if(cnt < n) {	// 해야할 인원보다 심사처리 못함 -> 시간 더 필요
        		start = mid + 1;
        	}
        	else {	// 해야할 인원보다 심사처리 많이함 -> 시간을 줄여서 더 최고 경우의 시간을 만든다.
        		end = mid - 1;
        		answer = mid;
        	}
        }
        
        
        return answer;
    }

	public static void main(String[] args) {
				
		int n = 6;
		int[] times = {7, 10};
				
		// 심사원이 입국심사 대기자를 심사하는데 걸리는 최소시간
		long answer = solution(n, times);  
		
		System.out.println(answer);

	}	// end of main
	
}	// end of class
