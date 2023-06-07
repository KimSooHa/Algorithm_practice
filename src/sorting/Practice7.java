package sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Practice7 {
	// 귤 고르기(프로그래머스 lv2)
	
	public static int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> arr = new HashMap<>();
        
        for(int t : tangerine) {
            arr.put(t, arr.getOrDefault(t, 0)+1); // getOrDefault: 해당 key값으로 value가 있으면 해당 value를, 없으면 지정한 default값 반환
        }
        
        ArrayList<Integer> list = new ArrayList<>(arr.values());
        Collections.sort(list, Collections.reverseOrder());
        int cnt = 0;
        for(Integer li : list) {
            if(cnt >= k) 
                break;
                
            answer++;    
            cnt += li;
        }
        
        return answer;
    }
	
	public static void main(String[] args) throws IOException {
		
		int k = 6;
		int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
		System.out.println(solution(k, tangerine));
		
	}	// end of main

}	// end of class
