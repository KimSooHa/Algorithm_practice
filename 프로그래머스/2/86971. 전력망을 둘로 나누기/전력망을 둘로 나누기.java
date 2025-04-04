import java.util.*;
class Solution {
    
    public int[] parent;
    
    public int findParent(int n) {
        if(parent[n] != n) {
            parent[n] = findParent(parent[n]);
        }
        return parent[n];
    }
    
    public void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        
        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int len = wires.length;
        
        for(int i=0; i<len; i++) {
            parent = new int[n+1];
            
            for(int j=1; j<=n; j++) {
                parent[j] = j;
            }
            
            for(int j=0; j<len; j++) {
                if(i == j) continue;
                
                if(findParent(wires[j][0]) != findParent(wires[j][1]))
                    union(wires[j][0], wires[j][1]);
            }
            
            Map<Integer, Integer> map = new HashMap<>();
            
            for(int j=1; j<=n; j++) {
                int root = findParent(j);
                map.put(root, map.getOrDefault(root, 0) + 1);
            }
            
            if(map.size() == 2) {
                List<Integer> cnt = new ArrayList<>(map.values());
                int diff = Math.abs(cnt.get(0) - cnt.get(1));
                answer = Math.min(answer, diff);   
            }    
        }
        
        return answer;
    }
}