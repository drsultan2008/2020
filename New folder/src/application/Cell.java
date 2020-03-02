package application;

public class Cell {
	int r,c;
	Cell(){
		r=-1;
		c=-1;
	}
	Cell(int r, int c){
		this.r=r;
		this.c=c;
	}
	int getRow() {
		return r;
	}
	int getCol() {
		return c;
	}
}
