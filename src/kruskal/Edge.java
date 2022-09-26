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



	// �Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
	@Override
	public int compareTo(Edge other) {
		if(this.distance < other.distance)
			return -1;
		
		return 1;
	}
	
}
