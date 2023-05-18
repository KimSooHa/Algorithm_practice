package implement;

import java.util.ArrayList;

class Practice36 {
	// 소수 찾기(프로그래머스 lv2)
	
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
	
	// 소수 체크
	public static boolean isPrime(int n) {
		if(n<2) return false;
		
		for(int i=2; i<=n/2; i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}


	// 백트래킹
	public static void dfs(String str, String temp, int m) {
		if(temp.length() == m) {
			int num = Integer.parseInt(temp);
			if(!arr.contains(num)) // num이 없으면 추가
				arr.add(num);
		}
		
		for (int i = 0; i < str.length(); i++) {
			if(!check[i]) { // false라면
				// 방문처리
				check[i] = true;
				// temp에 숫자 추가해서 조합
				temp += str.charAt(i);
				dfs(str, temp, m);
				// 조합이 완료되면 직전의 방문처리한 인덱스를 false로 변경
				check[i] = false;
				// temp변수에서 마지막 자리의 숫자를 제외하고 갱신
				temp = temp.substring(0, temp.length()-1);
			}
		}
		
	}


	public static void main(String args[]) {
		
		String numbers = "17";
		System.out.println(solution(numbers));
		
	}	// end of main
}	// end of class