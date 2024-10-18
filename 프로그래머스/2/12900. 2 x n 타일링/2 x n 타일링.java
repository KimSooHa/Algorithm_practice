class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] rectangle = new int[n+1]; // n * 2
        // tile : 2 * 1
        rectangle[0] = 1;
        rectangle[1] = 1;
        rectangle[2] = 2;
        
        for(int i=3; i<n+1; i++) {
            rectangle[i] = (rectangle[i-1] + rectangle[i-2]) % 1000000007;
        }
        answer = rectangle[n];
        return answer;
    }
}