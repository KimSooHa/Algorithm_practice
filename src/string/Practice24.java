package string;

public class Practice24 {
	// 둘만의 암호 (프로그래머스 lv1)
	
	// 방법:1
	public static String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            int idx = 0;
            char ch = s.charAt(i);
            
            while(idx < index) {
                ch++;
                if(ch > 'z')
                    ch = 'a';
                if(!skip.contains(String.valueOf(ch))) {
                    idx++;
                }
            }
            answer += ch;
        }        
        
        return answer;
    }

	// 방법:2
//  public String solution(String s, String skip, int index) {
//  String answer = "";

//  for (int i = 0; i < s.length(); i++){
//      char ch = s.charAt(i);
//      int stop = 0;

//      while (stop < index){
//          ch = (char) ((ch - 97 + 1) % 26 + 97);
//          if (!skip.contains(String.valueOf(ch))){
//              stop++;
//          }
//      }
//      answer += ch;

//  }

//  return answer;
//}

	public static void main(String[] args) {
		
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;
		String result = "happy";
		
		String answer = solution(s, skip, index);
			
		System.out.println(result.equals(answer));
		
	} // end of main
} // end of class