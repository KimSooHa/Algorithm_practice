import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int left = 0, right = 0, sum = 0, answer = 0;
		
		while(true) {
			if(sum>=m) {
				sum -= list.get(left++);
			}else if(right==n) break;
			else {
				sum += list.get(right++);
			}
			if(sum==m) {
				answer++;
			}
			
		}
		
		System.out.println(answer);
	} // end of main
} // end of class