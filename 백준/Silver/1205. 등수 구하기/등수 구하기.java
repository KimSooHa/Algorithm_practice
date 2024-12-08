import java.io.*;
import java.util.*;
public class Main {
    static int n, x, p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		if(n == 0) {
			System.out.println(1);
			return;
		}
		
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(x);
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list, Collections.reverseOrder());
		if(n == p && list.get(list.size()-1) == x) {
			System.out.println(-1);
			return;
		}
			
		for(int i=0; i<p; i++) {
			if(list.get(i) == x) {
				System.out.println(i+1);
				return;
			}
		}
	} // end of main
}