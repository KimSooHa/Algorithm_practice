import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int max = Math.max(arrayA[0], arrayB[0]);
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        for(int i=2; i<=max; i++) {
            if(isAllDivided(i, arrayA) && isNotAllDivided(i, arrayB))
                answer = Math.max(answer, i);
            else if(isAllDivided(i, arrayB) && isNotAllDivided(i, arrayA))
                answer = Math.max(answer, i);
        }
        
        return answer;
    }
    
    public boolean isAllDivided(int num, int[] arr) {
        for(int card : arr) {
            if(card % num != 0)
                return false;
        }
        return true;
    }
    
    public boolean isNotAllDivided(int num, int[] arr) {
        for(int card : arr) {
            if(card % num == 0)
                return false;
        }
        return true;
    }
}