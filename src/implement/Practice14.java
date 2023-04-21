package implement;

public class Practice14 {
	// 셀프 넘버(백준 4673) 
	
	public static void main(String args[]) {
		boolean[] check = new boolean[10001];	// 1 ~ 10000
		
		for(int i=1; i<10001; i++) {
			int n = d(i);

			// return 된 수는 생성자가 있는 수 = 출력하면 안되는 수 = 생성자가 있는 인덱스의 배열은 true로 대입
			if(n < 10001)	// 10000이 넘는 수는 필요 x
				check[n] = true;  
		}
		
		StringBuilder sb = new StringBuilder();
		// 생성자가 없는 숫자인 셀프넘버만 출력
		for(int i=1; i<10001; i++) {
			if(!check[i])
				sb.append(i).append('\n');
		}
		System.out.println(sb);
		
	}	// end of main
	
	public static int d(int num) {
		int sum = num;
		
		while(num != 0) {
			sum += (num % 10);	// 첫째 자리수
			num = num/10;
		}
		
		return sum;
	}
	
}	// end of class