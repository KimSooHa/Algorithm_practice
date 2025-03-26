import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int total = new HashSet<>(Arrays.asList(gems)).size();
        
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        Map<String, Integer> carrots = new HashMap<>();
        
        while(right < gems.length) {
            carrots.put(gems[right], carrots.getOrDefault(gems[right], 0) + 1);
            while(carrots.size() == total) {
                if(right - left < min) {
                    min = right - left;
                    answer[0] = left+1;
                    answer[1] = right+1;
                }
                
                carrots.put(gems[left], carrots.get(gems[left]) - 1);
                if(carrots.get(gems[left]) == 0)
                    carrots.remove(gems[left]);
                left++;
            }
            right++;
        }
        
        return answer;
    }
}