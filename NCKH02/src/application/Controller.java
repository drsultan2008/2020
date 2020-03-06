package application;

public class Controller {
	private Board board;
	private Data data;
	Controller(Board board, Data data){
		this.board = board;
		this.data = data;
	}
	public Data getData() {
		return data;
	}
}
