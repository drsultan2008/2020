package application;

import java.util.Observable;

public class Board{
	String[][] boardData = new String[7][5];
	Data data;
	Board(Data data) {
		this.data = data;
		setDefault();
	}
	
	public void setTunner(boolean turner) {
		turner = !turner;
	}
	
	public String [][] getBoardData() {
		return boardData;
	}
	
	public String get(int x, int y) {
		return boardData[x][y];
	}
	
	public void set(String rep, int x, int y) {
		boardData[x][y] = rep;
		// Extends
	}
	public boolean isWiner() {
		
		return false;
	}
	public void setDefault() {
		// Init
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				boardData[i][j] = "###";
			}
		}
		// Not board in game
		for (int i=0; i<2; i++) {
			for(int j=0; j<5; j++) {
				boardData[i][j] = "XXX";
			}
		}
		
		// Hum
		boardData[0][2] = "Hum";
		boardData[1][1] = "Hum";
		boardData[1][3] = "Hum";
		boardData[2][2] = "###";
		boardData[1][2] = "###";
		
		// Tot
		boardData[3][0] = "Tot";
		boardData[4][0] = "Tot";
		boardData[5][0] = "Tot";
		boardData[6][0] = "Tot";
		
		boardData[3][1] = "Tot";
		boardData[4][1] = "Tot";
		boardData[5][1] = "Tot";
		boardData[6][1] = "Tot";
		
		boardData[3][3] = "Tot";
		boardData[4][3] = "Tot";
		boardData[5][3] = "Tot";
		boardData[6][3] = "Tot";
		
		boardData[3][4] = "Tot";
		boardData[4][4] = "Tot";
		boardData[5][4] = "Tot";
		boardData[6][4] = "Tot";
		
		// BTom
		boardData[6][2] = "BTom";
		
		// Extends
	}
}

