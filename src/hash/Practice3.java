package hash;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice3 {
	// 의상(프로그래머스 lv2)

	public static int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        // A의 종류가 N개, B의 종류가 M개일 때 선택하는 모든 경우의 수 = (N+1)(M+1) => +1의 의미는 해당 종류를 선택하지 않음을 의미
        // 각 종류의 옷가지 수에 +1(옷 안입은거)들을 거듭해서 곱해주고, 마지막에 -1(다 벗은 경우의 수)을 해줘야 한다.
        for(String[] clothe : clothes) {
        	if(map.containsKey(clothe[1])) {
        		int tmp = map.get(clothe[1]);
        		map.put(clothe[1], tmp+1);
        	} else
        		map.put(clothe[1], 2); 
        }
        
		for(String k : map.keySet()) 
			answer *= map.get(k);
		
		
		// 옷을 하나라도 선택해야 하므로 다 벗은 경우의 수는 -1 해줘야 한다.
        return answer -1;
    }
	
	public static void main(String[] args) throws IOException {
		
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));

	}	// end of main

}	// end of class
