import java.io.*;
import java.util.*;

public class Main {
	public static StringTokenizer st;
	public static double h, w, n, m;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int answer;
        
        int x = (int) Math.ceil(h/(n+1));
        int y = (int) Math.ceil(w/(m+1));
        answer = x * y;

        System.out.println(answer);
	} // end of main
} // end of class