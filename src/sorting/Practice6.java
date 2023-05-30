package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice6 {
	// 보물(백준 1026)
	static int n;
	static int min = 0;
	static ArrayList<Integer> a = new ArrayList<>();
	static ArrayList<Integer> b = new ArrayList<>();
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a.add(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			b.add(Integer.parseInt(st.nextToken()));
			
		
		Collections.sort(a);
		Collections.sort(b, Collections.reverseOrder());
		
		for (int i = 0; i < n; i++) 
			min += (a.get(i) * b.get(i));
		
		
		System.out.println(min);
		
	}	// end of main

}	// end of class
