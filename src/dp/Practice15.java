package dp;

import java.util.ArrayList;
import java.util.List;

public class Practice15 {
	// N���� ǥ��(���α׷��ӽ�)
	// n���� ���� �� �ִ� �ּ� ���ڸ� ã�� x. ���ڸ� i�� ������� �� ��������� ��� ������ �ϳ��� �뿡 ���

	public static int solution(int N, int number) {
        
        List<ArrayList<Integer>> list = new ArrayList<>();
        
        // �� 8���� �� �����
        for (int i = 0; i <= 8; i++) 
			list.add(new ArrayList<>());
        
        list.get(1).add(N); // ���� 1���� �� �� �ڱ� �ڽŹۿ� ����(�ʱ�ȭ)
		
    	if(number == N)
    		return 1;
    	
    	// ���� 2������ Ž��
    	for (int i = 2; i <= 8; i++) {
    		ArrayList<Integer> total = list.get(i); // ���ڸ� i�� ���� ���� ���ڵ��� �� ����Ʈ
    		
    		// ���� ����Ʈ�� ������ ã��
    		for (int j = 1; j < i; j++) {
				ArrayList<Integer> a = list.get(j);
				ArrayList<Integer> b = list.get(i-j);
				
				for(int x : a) {
					for(int y : b) {
						total.add(x+y);
						total.add(x-y);
						total.add(x*y);
						if(x != 0 && y != 0)
							total.add(x/y);
					}
				}
				// ���� ���ڷ� �Ȱ� �߰��ϱ�
				// n�� �ݺ�Ƚ����ŭ �ٿ��� �־��ֱ�
				total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
			}
    		
    		if(total.contains(number))
    			return i;
		}
        
        return -1;
    }
	
	

	public static void main(String[] args) {

		
		int n = 5;
		int number = 12;
		
		System.out.println(solution(n, number));

	} // end of main

} // end of class
