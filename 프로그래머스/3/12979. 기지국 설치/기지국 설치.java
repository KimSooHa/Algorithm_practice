import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        // 슬라이딩 윈도우로 필요한 구간 찾기
        answer += getWidth(1, stations[0] - w - 1, 2*w+1);
        for(int i=1; i<stations.length; i++) {
            answer += getWidth(stations[i-1]+w+1, stations[i]-w-1, 2*w+1);
        }
        answer += getWidth(stations[stations.length-1]+w+1, n, 2*w+1);
        
        return answer;
    }
    
    public int getWidth(int l, int r, int w) {
        int num = r - l + 1;
        if(num <= 0) return 0;
        if(num % w == 0) return num / w;
        return num / w + 1;
    }
}