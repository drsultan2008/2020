package application;

public class Cell {
	private int row, col;
	Cell(){
		row = 0;
		col = 0;
	}
	
	Cell(int row, int col){
		this.row=row;
		this.col=col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
}
