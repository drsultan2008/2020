package application;

public class Controller {
	private Board board;
	private Data data;
	Controller(){
		
	}
	Controller(Board board, Data data){
		this.board = board;
		this.data = data;
	}
	public Data getData() {
		return data;
	}
	public void set(String rep, int x, int y) {
		data.set(rep, x, y);
	}
	
}
