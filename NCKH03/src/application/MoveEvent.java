package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveEvent implements EventHandler<ActionEvent>{
	Cell cell;
	Board board;
	MoveEvent(int i, int j, Board board){
		this.cell= new Cell(i,j);
		this.board=board;
	}
	@Override
	public void handle(ActionEvent e) {
		board.moveEvent(cell);
	}
}
