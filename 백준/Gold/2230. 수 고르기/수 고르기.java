import java.io.*;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		  
		int n = Integer.parseInt(st.nextToken()); // 정수(n)
		int m = Integer.parseInt(st.nextToken()); // 두 수의 차이(m)
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			list.add(Integer.parseInt(br.readLine()));  
		
		Collections.sort(list);
		
		int start = 0, end = n-1, mid = 0, idx = 0;
		int min = 2000000000;
		while(idx <= end) {
			mid = (start + end) / 2;
			if(start > end || mid >= n) {
				idx++;
				start = idx;
				end = n-1;
				continue;
			}

			if(list.get(mid) - list.get(idx) < m) {
				start = mid+1;
			}
			else if(list.get(mid) - list.get(idx) >= m) {
				min = Math.min(min, list.get(mid) - list.get(idx));
				if(min == m)
					break;
				end = mid-1;
			}
		}
		System.out.println(min);
	}
} // end of class