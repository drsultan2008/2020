package application;

import javafx.event.*;

public class moveEvent implements EventHandler<ActionEvent>{
	Cell cell;
	Board board;
	moveEvent(int i, int j, Board board){
		this.cell= new Cell(i,j);
		this.board=board;
	}
	@Override
	public void handle(ActionEvent e) {
		board.move(cell);
	}
}
