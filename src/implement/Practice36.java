package implement;

import java.util.ArrayList;

class Practice36 {
	// �Ҽ� ã��(���α׷��ӽ� lv2)
	
	static ArrayList<Integer> arr = new ArrayList<>();
	static boolean[] check = new boolean[7];
	
	public static int solution(String numbers) {
        int answer = 0;
        
        for(int i=0; i<numbers.length(); i++) 
        	dfs(numbers, "", i+1);
        
        for(int i=0; i<arr.size(); i++) {
        	if(isPrime(arr.get(i)))
        		answer++;
        }
        
        return answer;
    }
	
	// �Ҽ� üũ
	public static boolean isPrime(int n) {
		if(n<2) return false;
		
		for(int i=2; i<=n/2; i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}


	// ��Ʈ��ŷ
	public static void dfs(String str, String temp, int m) {
		if(temp.length() == m) {
			int num = Integer.parseInt(temp);
			if(!arr.contains(num)) // num�� ������ �߰�
				arr.add(num);
		}
		
		for (int i = 0; i < str.length(); i++) {
			if(!check[i]) { // false���
				// �湮ó��
				check[i] = true;
				// temp�� ���� �߰��ؼ� ����
				temp += str.charAt(i);
				dfs(str, temp, m);
				// ������ �Ϸ�Ǹ� ������ �湮ó���� �ε����� false�� ����
				check[i] = false;
				// temp�������� ������ �ڸ��� ���ڸ� �����ϰ� ����
				temp = temp.substring(0, temp.length()-1);
			}
		}
		
	}


	public static void main(String args[]) {
		
		String numbers = "17";
		System.out.println(solution(numbers));
		
	}	// end of main
}	// end of class