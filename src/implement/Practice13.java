package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Practice13 {
	// 팰린드롬수(백준 1259) 
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> arr = new ArrayList<>();
		 
		while(true) {
			String[] str = br.readLine().split("");

			if(str.length == 1 && str[0].equals("0"))
				break;
			
			String isSame = "yes";
			for(int i=0; i<str.length/2; i++) {
				if(!str[i].equals(str[str.length-1-i])) {
					isSame = "no";
					break;
				}
			}
			arr.add(isSame);
		}
		
		for(String s : arr)
			System.out.println(s);			
		
		
	}	// end of main
	
}	// end of class