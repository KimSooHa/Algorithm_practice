class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] leftCurr = {3, 0}; 
        int[] rightCurr = {3, 2};
        int left = -1, right = -2;
        int[] two = {0, 1};
        int[] five = {1, 1};
        int[] eight = {2, 1};
        int[] zero = {3, 1};
        
        for(int i=0; i<numbers.length; i++) { 
            int number = numbers[i];
            if(number == 1 ||number == 4 || number == 7) {
                answer += "L";
                left = number;
            }
                
            else if(number == 3 ||number == 6 || number == 9) {
                answer += "R";
                right = number;
            }
                
            else {
                if(left != -1) {
                    if(left == 0) {
                        leftCurr[0] = 3;
                        leftCurr[1] = 1;
                    }
                    else {
                        leftCurr[0] =  (left-1) / 3;
                        leftCurr[1] = (left-1) % 3;
                    }
                }
                if(right != -2) {
                    if(right == 0) {
                        rightCurr[0] = 3;
                        rightCurr[1] = 1;
                    }
                    else {
                        rightCurr[0] = (right-1) / 3;
                        rightCurr[1] = (right-1) % 3;
                    }
                }
                int leftDist = 0, rightDist = 0;
                
                    leftDist = Math.abs(leftCurr[0] - (number == 0 ? 3 :(number-1)/3)) + Math.abs(leftCurr[1] - (number == 0 ? 1 : ((number-1)%3)));    
                    rightDist = Math.abs(rightCurr[0] - (number == 0 ? 3 :(number-1)/3)) + Math.abs(rightCurr[1] - (number == 0 ? 1 : ((number-1)%3)));
                if(leftDist < rightDist) {
                    answer += "L";
                    left = number;
                } else if(leftDist > rightDist) {
                    answer += "R";
                    right = number;
                }
                else {
                    if(hand.equals("right")) {
                        answer += "R";
                        right = number;
                    }
                        
                    else {
                        answer += "L";
                        left = number;
                    }
                } 
            }
        }
        return answer;
    }
}