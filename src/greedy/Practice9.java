package greedy;

public class Practice9 {
	// »ïÃÑ»ç(ÇÁ·Î±×·¡¸Ó½º lv1)

	public static int solution(int[] number) {
        int answer = 0;
        
        for(int i=0; i<number.length-2; i++) {
            int zero = 0;
            zero += number[i];
            for(int j=i+1; j<number.length; j++) {
                zero += number[j];
                for(int z=j+1; z<number.length; z++) {
                    zero += number[z];
                    
                    if(zero == 0) 
                        answer++;
                    
                    zero -= number[z];
                        
                }
                zero -= number[j];
            }
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int[] number = {-2, 3, 0, 2, -5};
		 System.out.println(solution(number));
	}	// end of main

}	// end of class
