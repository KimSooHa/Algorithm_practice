class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        if(sticker.length == 1)
            return sticker[0];
        
        if(sticker.length <= 2)
            return Math.max(sticker[0], sticker[1]);
        
        int[] even = new int[sticker.length-1], odd = new int[sticker.length];
        even[0] = sticker[0];
        even[1] = even[0];
        
        for(int i=2; i<sticker.length-1; i++) {
            even[i] = Math.max(even[i-1], sticker[i] + even[i-2]);
        }
        
        odd[0] = 0;
        odd[1] = sticker[1];
        
        for(int i=2; i<sticker.length; i++) {
            odd[i] = Math.max(odd[i-1], sticker[i] + odd[i-2]);    
        }
        
        answer = Math.max(even[even.length-1], odd[odd.length-1]);
        return answer;
    }
}