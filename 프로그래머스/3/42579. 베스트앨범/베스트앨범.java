import java.util.*;

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Map<Integer, Integer>> maps = new HashMap<>();
        
        for(String genre : genres) {
            maps.put(genre, new HashMap<>());
        }
        
        for(int i=0; i<genres.length; i++) {
            maps.get(genres[i]).put(i, plays[i]);
        }
        
        Map<String, Integer> maps2 = new HashMap<>();
        for(String str : maps.keySet()) {
            for(int play : maps.get(str).keySet()) {
                maps2.put(str, maps2.getOrDefault(str, 0) + maps.get(str).get(play));
            }
        }
        
        List<String> keySet = new ArrayList<>(maps2.keySet());
        keySet.sort((o1, o2) -> (maps2.get(o2).compareTo(maps2.get(o1))));
        
        keySet.forEach(key -> { 
            Map<Integer, Integer> indexMap = maps.get(key);
            List<Integer> playNums = new ArrayList<>(indexMap.keySet());
            playNums.sort((o1, o2) -> (indexMap.get(o2).compareTo(indexMap.get(o1))));
            
            answer.add(playNums.get(0));
            if(playNums.size() > 1) {
                answer.add(playNums.get(1));
            }
        });
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}