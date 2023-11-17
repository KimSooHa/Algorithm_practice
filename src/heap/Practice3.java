package heap;

import java.util.PriorityQueue;

public class Practice3 {
	// ���߿켱����ť(���α׷��ӽ� lv3)
	
	public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(); // �ּ���
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2) -> { // �ִ���(�������� ���밪���� ū���� �켱������ ���� ������ ������ ��쵵 ���ؼ� ���ĵǵ��� �ϱ�)
            if(o1 > o2) return -1;
            return 1;
        });
        
        for(int i=0; i<operations.length; i++) {
            String[] str = operations[i].split(" ");
            
            // I�� ��쿡�� ���� ť�� ����
            if(str[0].equals("I")) {
                pqMin.offer(Integer.parseInt(str[1]));
                pqMax.offer(Integer.parseInt(str[1]));
            // D�� ��쿡�� -1�̸� �ּҰ� ����, 1�̸� �ִ� ����
            } else if(str[0].equals("D") && !pqMin.isEmpty() || !pqMax.isEmpty()) {
                if(str[1].equals("-1")) { // �ּҰ� ����(-1)�ؾ� �ϴ� ��쿡�� �ּ����� �켱���� ���� ���� �� Ȯ�� �� �ִ������� �����ϱ�
                    int num = pqMin.poll();
                    pqMax.remove(num);
                } else if(str[1].equals("1")) { // �ִ밪 ����(1)�ؾ� �ϴ� ��쿡�� �ִ����� �켱���� ���� ���� �� Ȯ�� �� �ּ������� �����ϱ�
                    int num = pqMax.poll();
                    pqMin.remove(num);
                }
            }
        }
        // ���� ����ִ� ���ڰ� ������ [0, 0] ��ȯ
        if(pqMin.isEmpty() && pqMax.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else { // ���� ���ڰ� ����ִٸ�[�ִ�, �ּڰ�] ��ȯ
            answer[0] = pqMax.peek();
            answer[1] = pqMin.peek();
        }   
        return answer;
    }
	
	public static void main(String args[]) {
		// ex1
		String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		int[] result1 = solution(operations1);
		System.out.println(result1[0] + ", " + result1[1]);
		
		System.out.println("========");
		
		// ex2
		String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int[] result2 = solution(operations2);
		System.out.println(result2[0] + ", " + result2[1]);
	}	// end of main	
}	// end of class

