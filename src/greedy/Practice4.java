package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Practice4 {
	// Ä·ÇÎ (¹éÁØ 4796)
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> arr = new ArrayList<>();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(l == 0 && p == 0 && v == 0)
				break;
			
			arr.add(l * (v/p) + Math.min(l, v%p));
		}
		
		for(int i=0, k=1; i<arr.size(); i++) {
			System.out.println("Case " + k + ": " + arr.get(i));	
			k++;
		}
		
		
		
	}	// end of main

}	// end of class
