package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Practice1 {
	// ��ũ ��Ʈ�ѷ�(���α׷��ӽ� - ��)
			
	// �ٸ� ��� �ڵ� ����
	// job�� ������ ������ �ð� ���� �ƴ� �� �ִ�.(������������ ���� �ʿ�!) => ����ð��� ª�� �۾����� ó��
	// 2. job �ϳ� ó���� �Ŀ� ���� job ��ü�� �ٽ� �����ؼ� job�� �����ؾ� �Ѵ�. => �ϳ��� �۾��� ������ �������� ���� ��û�� ���ؼ� ���� ª�� ����ð��� ���� �۾��� �����ؾ�
	// 3. ��ũ ��Ʈ�ѷ��� Job ó�� �Ŀ� ���� ���ϰ� ���� �� ó�� ����
	// 4, ���� �ð��� �ٸ� job�� ���� �� ���� �� �ִ�.
	
	
	public static int solution(int[][] jobs) {
		
		int answer = 0;
		int end = 0;	// ����ǰ� �� ������ �ð�
		int index = 0;// jobs �迭�� �ε���
		int count = 0;	// ����� ��û ����
		
		// ���� �迭 �������� ����(��û�ð� ��������) 
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		
		// ó���ð� ������������ �����ϴ� �켱���� ť 
		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		// ��û�� ��� ����� ������ �ݺ�
		while(count<jobs.length) {
			
			// �ϳ��� �۾��� �Ϸ�Ǵ� ����(end)���� ���� ��� ��û(�۾��� ��û�Ǵ� ������ end ��)�� ť�� ����
			while(index<jobs.length && jobs[index][0] <= end)
				pq.add(jobs[index++]);
			
			// ť�� ����ִٸ� �ϳ��� �۾��Ϸ�(end) ���Ŀ� �ٽ� ��û�� ���´ٴ� �ǹ� 
			// end�� ��û�� ���� ó������ ������
			if(pq.isEmpty()) 
				end = jobs[index][0];
			// �۾��� ������ ��(end ����) ���� ��û �� ���� ����ð��� ª�� ��û���� ���� 
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

