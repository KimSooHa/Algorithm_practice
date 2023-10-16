package implement;

public class Practice71 {
	// [1��] ��Ʈ ����(���α׷��ӽ� lv1)

    public static int solution(String dartResult) {
        int num = 0, idx = 0;
        String str = "";
        int[] dart = new int[3];
        // * : ���� ����*2, �ش� ����*2 / # : �ش� ���� * (-1)
        // S : 1����, D : 2����, T : 3����
        for(int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            // ������ ��
            if(c>='0'&&c<='9')
                 str+=String.valueOf(c);
            // ���ʽ��� �� 
            else if(c == 'S' || c == 'D' || c == 'T') {
                num = Integer.parseInt(str);
                 if(c == 'S')
                    dart[idx++] = (int)Math.pow(num, 1);
                else if(c == 'D') 
                    dart[idx++] = (int)Math.pow(num, 2);
                else
                    dart[idx++] = (int)Math.pow(num, 3);
                
                str = "";
                // �ɼ��� ��
            } else {
                if(c == '*') {
                    dart[idx-1] *= 2;
                    if(idx - 2 >= 0) dart[idx-2] *= 2;
                } else dart[idx-1] *= (-1);
            }
        }
        return dart[0] + dart[1] + dart[2];
    }

	public static void main(String[] args) {

		// ex1
		String dartResult = "1S2D*3T";
		System.out.println(solution(dartResult));
		
		// ex2
		dartResult = "1D2S#10S";
		System.out.println(solution(dartResult));
		
		// ex3
		dartResult = "1D2S0T";
		System.out.println(solution(dartResult));
		
		// ex4
		dartResult = "1S*2T*3S";
		System.out.println(solution(dartResult));
		
		// ex5
		dartResult = "1D#2S*3S";
		System.out.println(solution(dartResult));
		
		// ex6
		dartResult = "1T2D3D#";
		System.out.println(solution(dartResult));
		
		// ex7
		dartResult = "1D2S3T*";
		System.out.println(solution(dartResult));

	} // end of main

} // end of class
