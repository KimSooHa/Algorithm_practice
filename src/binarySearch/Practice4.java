package binarySearch;

import java.util.Arrays;

public class Practice4 {
	// �Ա� �ɻ�(���α׷��ӽ�)
	// ���� ���� �ɸ��� �ð��� ���� ���� �ɸ� �ð�(�Ա��ɻ縦 ��ٸ��� ��� �� * �ɻ���� �Ѹ��� �ɻ��ϴµ� �ɸ��� �ð��� ���� ū �ð�)�� �������� �̺�Ž���ϴ� ���� ����Ʈ!
	// �߰����� �� �ɻ���� �ɸ��� �ð����� ������ �� �ɻ���� �ɻ簡���� �ο��� ��� ���ؼ� �Ա��ɻ� ����ο��� ��
	
	public static long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long start = 0;
        long end = (long)n * times[times.length-1];
        
        while(start <= end) {
        	long mid = (start + end) / 2;
        	long cnt = 0;	// �� �ɻ��� �ο�
        	
        	for(int i=0; i<times.length; i++) {	// ���� �ɻ��ϴ�(�ɸ��� �ð� ����) �ɻ�� ������ �ɻ�ó��
        		cnt += mid / times[i];
        	}
        	
        	if(cnt < n) {	// �ؾ��� �ο����� �ɻ�ó�� ���� -> �ð� �� �ʿ�
        		start = mid + 1;
        	}
        	else {	// �ؾ��� �ο����� �ɻ�ó�� ������ -> �ð��� �ٿ��� �� �ְ� ����� �ð��� �����.
        		end = mid - 1;
        		answer = mid;
        	}
        }
        
        
        return answer;
    }

	public static void main(String[] args) {
				
		int n = 6;
		int[] times = {7, 10};
				
		// �ɻ���� �Ա��ɻ� ����ڸ� �ɻ��ϴµ� �ɸ��� �ּҽð�
		long answer = solution(n, times);  
		
		System.out.println(answer);

	}	// end of main
	
}	// end of class
