package shortestPath;

public class Node implements Comparable<Node> {

	private int index;
	private int distance;
	
	
	
	public Node(int index, int distance) {
		super();
		this.index = index;
		this.distance = distance;
	}



	public int getIndex() {
		return index;
	}



	public int getDistance() {
		return distance;
	}



	@Override
	public int compareTo(Node other) {
		
		if(this.distance < other.distance)
			return -1;
		
		return 1;
	}

}
