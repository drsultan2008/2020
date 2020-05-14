package DatabaseThayTuan;

public class Piece {
	private String from;
	private String to;
	
	public Piece(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "Piece [from=" + from + ", to=" + to + "]";
	}
	
}
