package string;

public class Practice1 {
	// 서울에서 김서방 찾기(프로그래머스)
	
	 public static String solution(String[] seoul) {
	        String answer = "";
	        int x = 0;

	        for(int i=0; i<seoul.length; i++) {	// Kim씨와 같은 문자열이 있다면
	        	if(seoul[i].equals("Kim")) {
	        		x = i;	// 헤당 인덱스 반환
	        		break;
	        	}
	        		
	        }
	        
	        //x = Arrays.asList(seoul).indexOf("Kim");
	        
	        answer = "김서방은 " +  x + "에 있다";
	        
	        return answer;
	    }
	
	public static void main(String[] args) {
		
		
		String[] seoul = {"Jane", "Kim"};
		
		
		
		System.out.println(solution(seoul));
		
		

	}

}
