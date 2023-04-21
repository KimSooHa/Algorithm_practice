package implement;

public class Practice14 {
	// ���� �ѹ�(���� 4673) 
	
	public static void main(String args[]) {
		boolean[] check = new boolean[10001];	// 1 ~ 10000
		
		for(int i=1; i<10001; i++) {
			int n = d(i);

			// return �� ���� �����ڰ� �ִ� �� = ����ϸ� �ȵǴ� �� = �����ڰ� �ִ� �ε����� �迭�� true�� ����
			if(n < 10001)	// 10000�� �Ѵ� ���� �ʿ� x
				check[n] = true;  
		}
		
		StringBuilder sb = new StringBuilder();
		// �����ڰ� ���� ������ �����ѹ��� ���
		for(int i=1; i<10001; i++) {
			if(!check[i])
				sb.append(i).append('\n');
		}
		System.out.println(sb);
		
	}	// end of main
	
	public static int d(int num) {
		int sum = num;
		
		while(num != 0) {
			sum += (num % 10);	// ù° �ڸ���
			num = num/10;
		}
		
		return sum;
	}
	
}	// end of class