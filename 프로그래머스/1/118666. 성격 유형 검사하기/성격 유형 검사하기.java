import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        char[] charType = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        for(int i=0; i<survey.length; i++) {
            char[] sv = survey[i].toCharArray();
            if(choices[i] > 4) 
                map.put(sv[1], map.getOrDefault(sv[1], 0) + choices[i] - 4);
            else 
                map.put(sv[0], map.getOrDefault(sv[0], 0) + 4 - choices[i]);
        }
        
        for(int i=0; i<charType.length-1; i+=2) {
            char ch = charType[i];
            char c = charType[i+1];
            
            if(map.getOrDefault(c, 0) < map.getOrDefault(ch, 0) || map.getOrDefault(c, 0) == map.getOrDefault(ch, 0)) 
                answer += ch;    
            else
                answer += c;
        }
        
        return answer;
    }
}