import java.util.*;

class Solution {
	
	public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] dataType = {"code", "date", "maximum", "remain"};
        int idx = 0;
        int sortIdx = 0;
        for(int i=0; i<dataType.length; i++) {
        	if(ext.equals(dataType[i]))
        		idx = i;
        	if(sort_by.equals(dataType[i]))
        		sortIdx = i;
        }
        
        final int index = sortIdx;
        List<int[]> list = new ArrayList<>();
        
        for(int i=0; i<data.length; i++) {
        	if(data[i][idx] < val_ext)
        		list.add(data[i]);
        }
        
        Collections.sort(list, (o1, o2) -> o1[index] - o2[index]);
        
        int[][] answer = new int[list.size()][4];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}