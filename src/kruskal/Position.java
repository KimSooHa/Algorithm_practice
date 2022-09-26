package kruskal;

public class Position implements Comparable<Position> {

	private int x;
	private int y;
	
	
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	
	// X축, Y축 순서대로 정렬
	@Override
	public int compareTo(Position other) {
		if(this.x == other.x)
			return Integer.compare(this.y, other.y);
		
		return Integer.compare(this.x, other.x);
	}

}
