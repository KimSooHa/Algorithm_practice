package implement;

public class Practice55 {
	// n^2 배열 자르기(프로그래머스 lv2)
	
	//(1,1)(1,2)(1,3)
    //(2,1)(2,2)(2,3)
    //(3,1)(3,2)(3,3)
    // ==
    //max(1,1)max(1,2)max(1,3) = 1 2 3
    //max(2,1)max(2,2)max(2,3) = 2 2 3
    //max(3,1)max(3,2)max(3,3) = 3 3 3
    // ==
    //1차원 배열로 변환
    //idx    = 0 1 2 3 4 5 6 7 8
    //value  = 1 2 3 2 2 3 3 3 3

    // idx / n = 2/3 = 0 + 1 = 1
    // idx % n = 2%3 = 1 + 1 = 2

    //1차원 배열 2번 idx 는 2차원 배열 (1,2)와 같다.
    //(1,2)중 큰 값이 2차원 배열 value 이므로, 1차원 배열의 2번 idx 는 2

    //-> 이런식으로 left...(right-left) 까지 구함
    //(int) 형변환이 가능한 이유는 value 값은 무조건 n 이하이고, n <= 10,000,000 이다.
	
	public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        
        for(int i=0; i<answer.length; i++) {
            int x = (int)(left / n);
            int y = (int)(left % n);
            answer[i] = Math.max(x, y) + 1;
            left++;
        }
        
        return answer;
    }


	public static void main(String[] args) {

		int n = 3;
		long left = 2;
		long right = 5;
		
		int[] result = solution(n, left, right);
		
		for(int arr : result) {
			System.out.println(arr);		
		}
	} // end of main

} // end of class
