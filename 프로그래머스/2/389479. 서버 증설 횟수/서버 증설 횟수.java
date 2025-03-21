class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[players.length];
        
        for(int i=0; i<players.length; i++) {
            int player = players[i];
            int size = player / m;
            
            if(size > 0) {
                if(servers[i] < size) {
                    int diff = size - servers[i];
                    answer += diff;
                    for (int j = 0; j < k; j++) {
                        if(i + j >= servers.length)
                            break;
                        servers[i + j] += diff;
                    }
                }
            }
        }
        
        return answer;
    }
}