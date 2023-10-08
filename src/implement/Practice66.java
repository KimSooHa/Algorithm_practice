package implement;

public class Practice66 {
	// 소수 만들기(프로그래머스 lv1)

	public static int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length-2; i++) {
            for(int j = i+1; j<nums.length-1; j++) {
                for(int z = j+1; z<nums.length; z++) {
                    if(isPrime(nums[i] + nums[j] + nums[z]))
                        answer++;
                }
            }
        }
        return answer;
    }
    
    public static boolean isPrime(int sum) {
        for(int i=2; i<sum/2; i++) {
            if(sum % i == 0)
                return false;
        }
        return true;
    }

	public static void main(String[] args) {

		// ex1
		int[] nums1 = {1,2,3,4};
		System.out.println("ex1 = " + solution(nums1));
		
		// ex2
		int[] nums2 = {1,2,7,6,4};
		System.out.println("ex2 = " + solution(nums2));

	} // end of main

} // end of class
