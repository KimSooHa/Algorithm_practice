package string;

public class Practice1 {
	// ���￡�� �輭�� ã��(���α׷��ӽ�)
	
	 public static String solution(String[] seoul) {
	        String answer = "";
	        int x = 0;

	        for(int i=0; i<seoul.length; i++) {	// Kim���� ���� ���ڿ��� �ִٸ�
	        	if(seoul[i].equals("Kim")) {
	        		x = i;	// ��� �ε��� ��ȯ
	        		break;
	        	}
	        		
	        }
	        
	        //x = Arrays.asList(seoul).indexOf("Kim");
	        
	        answer = "�輭���� " +  x + "�� �ִ�";
	        
	        return answer;
	    }
	
	public static void main(String[] args) {
		
		
		String[] seoul = {"Jane", "Kim"};
		
		
		
		System.out.println(solution(seoul));
		
		

	}

}
