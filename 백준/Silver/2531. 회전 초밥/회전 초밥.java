import java.io.*;
import java.util.*;

public class Main {
	static int n, d, k, c; // 초밥벨트에 놓인 접시의 수(N), 초밥의 가짓수(d), 연속해서 먹는 접시의 수(k), 쿠폰 번호(c)
	static int max = -1;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++)
			list.add(Integer.parseInt(br.readLine()));
		
		int start = 0, end = n-1;
		int idx = 0;
		Set<Integer> set = new HashSet<>();
		while(start <= end) {
			if(idx >= k) {
				idx = 0;
				max = Math.max(!set.contains(c) ? set.size() + 1 : set.size(), max);
				start ++;
				set.clear();
			}
			idx++;
			set.add(list.get((start + idx) % n));
			
		}
		
		System.out.println(max);
	}
} // end of class