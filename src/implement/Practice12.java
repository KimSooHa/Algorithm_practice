package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice12 {
	// 2007ณโ(น้มุ 1924) 
	public static String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int today = 0;
		for(int i=1; i<x; i++) {
			if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12) {
				today += (31 % 7);
			} else if(i==4 || i==6 || i==9 || i==11) {
				today += (30 % 7);
			}
			else
				today += (28 % 7);
		}
		
		today += (y % 7);
		
		System.out.println(week[today%week.length]);
		
		
	}	// end of main
	
}	// end of class