package implement;

import java.util.LinkedList;
import java.util.Queue;

public class Practice57 {
	// [1차]캐시(프로그래머스 lv2)
	
	public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> list = new LinkedList<>();
        
        for (int i = 0; i < cities.length; i++) {
        	if(cacheSize == 0) {
        		answer += 5;
        		continue;
        	}
        	
        	if(list.contains(cities[i].toUpperCase())) {	
    			list.remove(cities[i].toUpperCase());
        		list.offer(cities[i].toUpperCase());
        		answer += 1;
        	}
        	else {
        		if(list.size() >= cacheSize)
        			list.poll();
        		
        		list.offer(cities[i].toUpperCase());
        		answer += 5;
        	}
		}
        
        return answer;
    }


	public static void main(String[] args) {
		
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		System.out.println(solution(cacheSize, cities));
	} // end of main

} // end of class
