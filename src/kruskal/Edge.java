package kruskal;

public class Edge implements Comparable<Edge> {

	private int distance;
	private int nodeA;
	private int nodeB;
	
	
	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}

	

	public int getDistance() {
		return distance;
	}



	public int getNodeA() {
		return nodeA;
	}



	public int getNodeB() {
		return nodeB;
	}



	// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(Edge other) {
		if(this.distance < other.distance)
			return -1;
		
		return 1;
	}
	
}
