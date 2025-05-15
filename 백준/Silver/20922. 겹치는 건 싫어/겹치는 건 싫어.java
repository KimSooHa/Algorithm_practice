import java.io.*;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		  
		int n = Integer.parseInt(st.nextToken()); // 정수(n)
		int k = Integer.parseInt(st.nextToken()); // 같은원소갯수(k)	
		List<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			list.add(Integer.parseInt(st.nextToken()));   
		
		int start = 0, end = n-1;
		int idx = 0, max = -1;
        int[] arr = new int[200001];
		while(start <= end) {
			if(idx >= n || arr[list.get(idx)] >= k) {
				max = Math.max(max, idx - start);
				arr[list.get(start)]--;
				start++;
				continue;
			}
			arr[list.get(idx++)]++;
        }
        
		System.out.println(max);
	}
} // end of class