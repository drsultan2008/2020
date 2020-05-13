package AlgoThayDung;

public class DirectedEdge {
	private int from;
	private int to;
	private int weight;
	
	public DirectedEdge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "DirectedEdge [v=" + from + ", w=" + to + ", weight=" + weight + "]";
	}
	
}
