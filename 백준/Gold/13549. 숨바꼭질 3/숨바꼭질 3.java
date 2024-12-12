import java.io.*;
import java.util.*;
public class Main {
	static int n, k;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static int max = 100000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new boolean[max+1];
		findBrother();
		System.out.println(min);
	} // end of main
	
	public static void findBrother() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(n, 0));
			
		while(!q.isEmpty()) {
			Node node = q.poll();
			visited[node.getX()] = true;
			if(node.getX() == k)
				min = Math.min(min, node.getTime());
			
			if(node.getX() * 2 <= max && visited[node.getX() * 2] == false)
				q.offer(new Node(node.getX() * 2, node.getTime()));
			if(node.getX() + 1 <= max && visited[node.getX() + 1] == false)
				q.offer(new Node(node.getX() + 1, node.getTime() + 1));
			if(node.getX() - 1 >= 0 && visited[node.getX() - 1] == false)
				q.offer(new Node(node.getX() - 1, node.getTime() + 1));
		}
	}
	
	public static class Node {
		private int x;
		private int time;
        
        public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
		
		public int getX() {
			return x;
		}
		
		public int getTime() {
			return time;
		}
	}
} // end of class