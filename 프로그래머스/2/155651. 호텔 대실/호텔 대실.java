import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int[][] book = new int[book_time.length][2];
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0]));
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<book_time.length; i++) {
            String[] startTime = book_time[i][0].split(":");
            String[] endTime = book_time[i][1].split(":");
            int start = Integer.parseInt(startTime[0])*60 + Integer.parseInt(startTime[1]);
            int end = Integer.parseInt(endTime[0])*60 + Integer.parseInt(endTime[1]);
            
            queue.offer(new int[]{start, end});
            if(!queue.isEmpty()) {
                int cnt = 0;
                while(cnt < queue.size()) {
                    int[] reserve = queue.poll();
                    int checkin = reserve[0];
                    int checkout = reserve[1];
                    if(checkout + 10 > start) 
                        queue.offer(new int[]{checkin, checkout});
                    else
                        break;
                    cnt++;
                }
            }
        }
        
        return queue.size();
    }
}