package string;

public class Practice2 {
	// �ڵ��� ��ȣ ������(���α׷��ӽ�)
	
	 public static String solution(String phone_number) {
	        String answer = "";
	        
	        char[] arr = phone_number.toCharArray();
	        
	        for(int i=phone_number.length()-5; i>=0; i--) 	
	        	arr[i] = '*';
	        
	        for(char a : arr)
	        	answer += a;
	        
	        return answer;
	    }
	
	public static void main(String[] args) {
		
		
		String phone_number	= "01033334444";
		
		
		
		System.out.println(solution(phone_number));
		
		

	}

}
