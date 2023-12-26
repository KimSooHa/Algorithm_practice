package string;

public class Practice23 {
	// ¼ýÀÚ Â¦²á (ÇÁ·Î±×·¡¸Ó½º lv1)
	
	public static String solution(String X, String Y) {
        int[] x = new int[10];
        int[] y = new int[10];
        
        for(String str : X.split("")) {
            int num = Integer.parseInt(str);
            x[num]++;
        }
        for(String str : Y.split("")) {
            int num = Integer.parseInt(str);
            y[num]++;
        }
        int[] arr = new int[10];
        for(int i=0; i<10; i++) 
            arr[i] = x[i] >= y[i] ? y[i] : x[i];
        
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            for(int j=0; j<arr[i]; j++)
                sb.append(i);
        }
        String answer = sb.toString();
        
        if(answer.equals(""))
            return "-1";
        else if(answer.replace("0", "").equals(""))
            return "0";
        
        return answer;
    }

	public static void main(String[] args) {
		
		String X = "100";
		String Y = "2345";
		System.out.println(solution(X, Y));
		
		X = "100";
		Y = "203045";
		System.out.println(solution(X, Y));
		
		X = "100";
		Y = "123450";
		System.out.println(solution(X, Y));
		
		X = "12321";
		Y = "42531";
		System.out.println(solution(X, Y));
		
		X = "5525";
		Y = "1255";
		System.out.println(solution(X, Y));
	} // end of main
} // end of class