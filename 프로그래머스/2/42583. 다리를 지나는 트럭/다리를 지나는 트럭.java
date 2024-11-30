import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 시간
        int weightSum = 0; // 다리 위의 총 무게
        int index = 0; // truck_weights 인덱스
        Queue<Integer> bridge = new LinkedList<>();
        
        // 다리 길이만큼 0으로 초기화하여 트럭이 없는 상태를 나타냄
        for(int i=0; i<bridge_length; i++) {
            bridge.add(0);
        }
        
        while(index < truck_weights.length) {
            answer++;
            // 다리 앞에서 나오는 트럭의 무게를 빼주기
            weightSum -= bridge.poll();
            
            // 다음 트럭이 다리 위에 올라갈 수 있는지 확인
            if(weightSum + truck_weights[index] <= weight) {
                bridge.add(truck_weights[index]);
                weightSum += truck_weights[index];
                index++;
            } else {
                // 무게 초과시 0을 추가하여 다리 확보
                bridge.add(0);
            }
        }
        
        // 마지막 트럭이 다리를 완전히 건너기 위한 시간 추가
        answer += bridge_length;
        return answer;
    }
}