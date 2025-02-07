import java.util.*;

class Solution {
    
    static String type;
	
	static class Data implements Comparable<Data> {
		
		private int code;
		private int date;
		private int maximum;
		private int remain;
		
		public Data(int code, int date, int maximum, int remain) {
			this.code = code;
			this.date = date;
			this.maximum = maximum;
			this.remain = remain;
		}
		
		public int getCode() {
			return this.code;
		}
		
		public int getDate() {
			return this.date;
		}
		
		public int getMaximum() {
			return this.maximum;
		}
		
		public int getRemain() {
			return this.remain;
		}
		
		
		@Override
		public int compareTo(Data o) {
			if(type.equals("code"))
				return this.code - o.code;
			else if (type.equals("date"))
				return this.date - o.date;
			else if(type.equals("maximum"))
				return this.maximum - o.maximum;
			
			return this.remain - o.remain;
		}
		
	}
	
	public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] dataType = {"code", "date", "maximum", "remain"};
        type = sort_by;
        int idx = 0;
        for(int i=0; i<dataType.length; i++) {
        	if(ext.equals(dataType[i]))
        		idx = i;
        }
        List<Data> list = new ArrayList<>();
        for(int i=0; i<data.length; i++) {
        	if(data[i][idx] < val_ext)
        		list.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
        }
        
        Collections.sort(list);
        
        int[][] answer = new int[list.size()][4];
        
        for(int i=0; i<list.size(); i++) {
        	answer[i][0] = list.get(i).getCode();
        	answer[i][1] = list.get(i).getDate();
        	answer[i][2] = list.get(i).getMaximum();
        	answer[i][3] = list.get(i).getRemain();
        }
        
        return answer;
    }
}