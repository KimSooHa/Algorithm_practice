package string;

public class Practice16 {
	// 푸드 파이트 대회 (프로그래머스) 
	    
	 public static String solution(int[] food) {
        String answer = "";
        
        for(int i=0; i<food.length; i++) {
            if(food[i] % 2 != 0) {
                food[i]--;
            }
            food[i] /= 2;
        }
        
        for(int i=0; i<food.length; i++) {
            for(int j=0; j<food[i]; j++) 
                answer += i;       
        }
        answer += "0";
        
        for(int i=food.length-1; i>=0; i--) {
            for(int j=0; j<food[i]; j++) 
                answer += i;    
        }
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		int[] food = {1, 3, 4, 6};
		String result = solution(food);
		
		for (int i = 0; i < result.length(); i++) 
			System.out.println(result.charAt(i));			
		
	}
}