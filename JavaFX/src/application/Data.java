package application;

import java.util.Random;

public class Data {
	private int boardData[][] = new int[9][9];
	Random myRandom;
	
	public Data() {
		myRandom = new Random();
	
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (myRandom.nextInt(100) <=40) {
					boardData[i][j] = myRandom.nextInt(10);
				}
			}
		}
	}
	
	public int[][] getBoardData() {
		return boardData;
	}
	
	public void setBoardData(int[][] boardData) {
		this.boardData = boardData;
	}
	
	public Random getMyRandom() {
		return myRandom;
	}
	
	public void setBoard(int val, int x, int y) {
		boardData[x][y] = val;
	}
	
	public int getBoard(int x, int y) {
		return boardData[x][y];
	}
	
}
