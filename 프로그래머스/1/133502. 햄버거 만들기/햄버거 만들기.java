import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] burger = {1, 2, 3, 1};
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<ingredient.length; i++) {
            list.add(ingredient[i]);
        }
        
        int idx = 0;
        int ingIdx = list.size() - 3;
        while(idx <= ingIdx) {
            if(list.get(idx) == burger[0] && list.get(idx+1) == burger[1] && list.get(idx+2) == burger[2] && list.get(idx+3) == burger[3]) {
                list.remove(idx + 3);
                list.remove(idx + 2);
                list.remove(idx + 1);
                list.remove(idx + 0);
                answer++;
                ingIdx -= 4;
                if(idx - 4 >= -1) idx -= 4;
                else idx = -1;
            }
            idx++;
        }
        
        return answer;
    }
}