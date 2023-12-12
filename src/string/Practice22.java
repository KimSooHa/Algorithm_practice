package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Practice22 {
	// 임스와 함께하는 미니게임 (백준 25757)
	
	static int n;
	static char type; // Y:2, F:3, O:4

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		type = st.nextToken().charAt(0);
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) 
			set.add(br.readLine());
		
		int t = type == 'Y' ? 2 : type == 'F' ? 3 : 4;
		
		int answer = set.size() / (t-1);
		System.out.println(answer);
	} // end of main
} // end of class