package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice5 {
	// 안테나(백준 18310)
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) 
			list.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(list);
		// 중간값(median) 출력
		System.out.println(list.get((n-1) / 2));
		
		
	}	// end of main

}	// end of class
